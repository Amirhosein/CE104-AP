package Server.Controller;

import Server.Model.Chatroom.ChatServer;
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
    private final ArrayList<Socket> sockets = new ArrayList<>();
    public static String status;
    public static int readycount = 0;

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
                System.out.println("New client connected "
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
            System.out.println(count);
            while (true)
                if (readycount == count) {
                    System.out.println("12333");
                    broadcast("chatroom");
                    break;
                }else System.out.println("KIR");
            ChatServer chatServer = new ChatServer(sockets);

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
                        System.out.println(clientSocket + " :" + player.getUsername());
                        readycount++;
                        System.out.println(readycount);
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
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void broadcast(String string) throws IOException {
        for (Socket socket : sockets) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(string);
        }
    }
}