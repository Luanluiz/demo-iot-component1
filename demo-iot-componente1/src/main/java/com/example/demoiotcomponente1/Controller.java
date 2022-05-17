package com.example.demoiotcomponente1;

import org.jivesoftware.smack.chat.Chat;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final XmppService xmppService;

    public Controller(XmppService xmppService) {
        this.xmppService = xmppService;
    }

    @GetMapping("/iot/temp")
    public int perguntarTemperatura() {
        final int[] temp = {0};
        System.out.println(">> temperatura");
        try {
            EntityBareJid jid = JidCreate.entityBareFrom("user@10.1.11.122");
            Chat chat = this.xmppService.getChatManager().createChat(jid);
            chat.sendMessage("temperatura");
            chat.addMessageListener((chat1, message) -> {
                temp[0] = Integer.parseInt(message.getBody());
                System.out.println("<< temperatura " + message.getBody());
            });

            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return temp[0];
    }

    @GetMapping("/iot/luz")
    public boolean acenderApagarLuz() {
        final boolean[] luzAcessa = {true};
        System.out.println(">> luz");
        try {
            EntityBareJid jid = JidCreate.entityBareFrom("user@10.1.11.122");
            Chat chat = this.xmppService.getChatManager().createChat(jid);
            chat.sendMessage("luz");
            chat.addMessageListener((chat1, message) -> {
                luzAcessa[0] = Boolean.parseBoolean(message.getBody());
                System.out.println("<< luz " + luzAcessa[0]);
            });
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return luzAcessa[0];
    }
}
