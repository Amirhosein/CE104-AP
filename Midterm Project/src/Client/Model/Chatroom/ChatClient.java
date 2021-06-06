package Client.Model.Chatroom;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Amir Iravanimanesh
 * @date 6/6/2021
 */
public class ChatClient {
    private String userName;
    private Socket socket;

    public ChatClient(Socket socket, String userName) {
        this.socket = socket;
        this.userName = userName;
        System.out.println("fahmidam");
        execute();
    }

    public void execute() {
        new ReadThread(socket, this).start();
        new WriteThread(socket, this).start();
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    String getUserName() {
        return this.userName;
    }

}