package com.example.demoiotcomponente1;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.packet.*;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class DemoIotComponente1Application {

    private final XmppService xmppService;

    public static void main(String[] args) {
        SpringApplication.run(DemoIotComponente1Application.class, args);
    }

    public DemoIotComponente1Application(XmppService xmppService) {
        this.xmppService = xmppService;
        teste();
    }

    public void teste() {
        try {
            xmppService.conect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

