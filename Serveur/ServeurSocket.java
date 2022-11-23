package Serveur;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import Message.Message;

public class ServeurSocket {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        ServerSocket ss = new ServerSocket(7777);
        System.out.println("Socket en attente de la connexion...");
        Socket socket = ss.accept();
        System.out.println("Connexion sur le port " + socket + "!");

        InputStream inputStream = socket.getInputStream();
        
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        List<Message> listOfMessages = (List<Message>) objectInputStream.readObject();
        System.out.println("messages reçu [" + listOfMessages.size() + "] de : " + socket);
        
        System.out.println("Tous les messages : ");
        listOfMessages.forEach((msg)-> System.out.println(msg.getText()));

        System.out.println("Fermeture du socket.");
        ss.close();
        socket.close();
    }
}
