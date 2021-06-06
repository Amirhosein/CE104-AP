package Server.Controller;

import Server.Model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author Amir Iravanimanesh
 * @date 5/31/2021
 */
public class Connection {
    public static HashMap<Socket, Player> playerHashMap = new HashMap<>();
    private ArrayList<Socket> sockets = new ArrayList<>();

    public Connection() {
        ServerSocket server = null;
        int defCount = 2;
        int count = 0;


        try {

            // server is listening on port 1234
            server = new ServerSocket(6060);
            server.setReuseAddress(true);

            // running infinite loop for getting
            // client request
            while (count < defCount) {

                // socket object to receive incoming client
                // requests
                Socket client = server.accept();

                // Displaying that new client is connected
                // to server
                System.out.println("New client connected"
                        + client.getInetAddress()
                        .getHostAddress());
                // create a new thread object
                ClientHandler clientSock
                        = new ClientHandler(client);

                // This thread will handle the client
                // separately
                new Thread(clientSock).start();
                sockets.add(client);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ClientHandler class
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private String username;

        // Constructor
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;
            try {

                // get the outputstream of client
                out = new PrintWriter(
                        clientSocket.getOutputStream(), true);

                // get the inputstream of client
                in = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    Player player;
                    if ((player = Player.register(line)) != null) {
                        out.println("Registered successfully");
                        username = line;
                        Connection.playerHashMap.put(clientSocket, player);
                        break;

                    } else {
                        out.println("Registration failed");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}