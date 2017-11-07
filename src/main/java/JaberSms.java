import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;

import java.util.Scanner;

/**
 * Created by poliksanya on 07.11.17.
 */
public class JaberSms {

    public static void main(String[] args) {
        try {
            ConnectionConfiguration config = new ConnectionConfiguration("127.0.0.1" ,5222);
            //config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
            // config.setDebuggerEnabled(false);
            config.setSendPresence(true);
            XMPPConnection con = new XMPPConnection(config);
            con.connect();
            //AccountManager manager = con.getAccountManager();
            //manager.createAccount("User2", "12345");
            con.login("Kirk", "12345");

            Chat chat = con.getChatManager().createChat("matt@test1.jabber", new MessageListener() {
                //@Override
                public void processMessage(Chat chat, Message message) {
                    if (!(message.getBody() == null))
                        System.out.println(chat.getParticipant() + " said: " + message.getBody());
                }
            });
            System.out.println("Connected!");
            Scanner scanner = new Scanner(System.in);

            //chat.sendMessage("Paw!");


            while (con.isConnected())
            {
                chat.sendMessage(scanner.nextLine());
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // write your code here
    }
}
