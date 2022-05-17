package com.example.demoiotcomponente1;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.impl.JidCreate;
import org.springframework.stereotype.Service;

@Service
public class XmppService {

    private XMPPTCPConnection conn;

    public void conect() throws Exception {
        XMPPTCPConnectionConfiguration.Builder builder = //
                XMPPTCPConnectionConfiguration.builder() //
                        .setHost("127.0.0.1") //
                        .setPort(5222) //
                        .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled) //
                        .setSendPresence(true) //
                        .setXmppDomain(JidCreate.domainBareFrom("10.1.11.122"))//
                ;

        conn = new XMPPTCPConnection(builder.build());
        conn.connect();
        conn.login("teste", "teste");

        System.out.println("Conectado");

    }

    public ChatManager getChatManager() {
        return ChatManager.getInstanceFor(conn);
    }

}
