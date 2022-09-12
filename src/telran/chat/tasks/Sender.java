package telran.chat.tasks;

import telran.chat.model.Message;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

public class Sender implements Runnable{
    String userName;
    Socket socket;
    Thread receiver;

    public Sender(String userName, Socket socket, Thread receiver) {
        this.userName = userName;
        this.socket = socket;
        this.receiver = receiver;
    }

    @Override
    public void run() {
        receiver.setDaemon(true);
        receiver.start();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String text = br.readLine();
            while (!"exit".equalsIgnoreCase(text)){
                Message msg = new Message(LocalDateTime.now(),text,userName);
                oos.writeObject(msg);
                text = br.readLine();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
