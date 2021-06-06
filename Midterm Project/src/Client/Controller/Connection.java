package Client.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Client.Model.Chatroom.ChatClient;
import Client.View.Menu;
import Client.View.TerminalInput;

/**
 * @author Amir Iravanimanesh
 * @date 5/31/2021
 */
public class Connection {
    private String username;

    public Connection() {
        Menu.mainMenu();
        int port = Integer.parseInt(TerminalInput.getInput());


        try (Socket socket = new Socket("localhost", port)) {

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            String line;

            while (true) {
                line = TerminalInput.getInput();
                out.println(line);
                out.flush();
                if (in.readLine().equalsIgnoreCase("Registration failed"))
                    Menu.registerError();
                else {
                    Menu.successfulRegister();
                    username = line;
                    break;
                }
            }
            ChatClient chatClient = new ChatClient(socket, username);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
