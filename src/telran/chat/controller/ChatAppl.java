package telran.chat.controller;

import telran.chat.tasks.Reciever;
import telran.chat.tasks.Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatAppl {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("enter your username");
        String userName = br.readLine();
        String serverAddress = "127.0.0.1";
        int port = 9000;
        try(Socket socket = new Socket(serverAddress,port);) {
            Thread receiver = new Thread(new Reciever(socket));
            Thread sender = new Thread(new Sender(userName,socket,receiver));
            sender.start();
            sender.join();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
