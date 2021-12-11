package Project.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * The type Read thread.
 *
 * @author Amir Iravanimanesh
 * @date 6 /7/2021
 */
public class ReadThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private final ChatClient client;

    /**
     * Instantiates a new Read thread.
     *
     * @param socket the socket
     * @param client the client
     */
    public ReadThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;

        try {
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error getting input stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                String response = reader.readLine();
                if (response.equalsIgnoreCase("NIGHT TIME")) {
                    client.nightPhase();
                    continue;
                } else if (response.equalsIgnoreCase("DAY TIME")) {
                    client.dayPhase();
                    continue;
                } else if (response.equalsIgnoreCase("VOTING")) {
                    ChatClient.type = true;
                    client.votingPhase();
                } else if (response.contains("SPEAK")) {
                    ChatClient.type = true;
                } else if (response.equalsIgnoreCase("MUTE")) {
                    ChatClient.type = false;
                }
                System.out.println("\n" + response);

            } catch (IOException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}
