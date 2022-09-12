package telran.chat.tasks;

import telran.chat.model.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class Reciever implements Runnable{
    Socket socket;

    public Reciever(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();
            System.out.println(message.getUserName() +": " + message.getText()+ " " + message.getSendTime().format(DateTimeFormatter.BASIC_ISO_DATE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
