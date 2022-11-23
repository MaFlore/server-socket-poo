package Client;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Message.Message;

public class ClientSocket {

    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("localhost", 7777);
        System.out.println("Connexion réussie.");

        OutputStream outputStream = socket.getOutputStream();
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Bonjour de l'autre côté!"));
        messages.add(new Message("Comment vas-tu?"));
        messages.add(new Message("Quelle heure est-il?"));
        messages.add(new Message("Hi hi hi hi."));

        System.out.println("Envoi de messages au serveur");
        objectOutputStream.writeObject(messages);

        System.out.println("Fermeture du socket et arrêt du programme.");
        socket.close();
    }
}