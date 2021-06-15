package Project.Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import Project.Console.ConsoleColors;

/**
 * The type Chat client.
 *
 * @author Amir Iravanimanesh
 * @date 6 /7/2021
 */
public class ChatClient {
    private final String hostname;
    private final int port;
    private String userName;
    private ReadThread readThread;
    private WriteThread writeThread;
    /**
     * The constant type.
     */
    public static boolean type = true;
    /**
     * The Users.
     */
    public ArrayList<String> users = new ArrayList<>();

    /**
     * Instantiates a new Chat client.
     *
     * @param hostname the hostname
     * @param port     the port
     */
    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Execute.
     */
    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);

            System.out.println("Connected to the chat server");

            readThread = new ReadThread(socket, this);
            writeThread = new WriteThread(socket, this);

            readThread.start();
            writeThread.start();

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }

    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    String getUserName() {
        return this.userName;
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        String hostname = "localhost";
        int port = 6000;

        ChatClient client = new ChatClient(hostname, port);
        client.execute();
    }

    /**
     * Night phase.
     */
    void nightPhase() {
        type = false;
        System.out.print(ConsoleColors.WHITE_BOLD);
        System.out.println("""
                                 _.._
                               .' .-'`
                              /  /
                NIGHT PHASE  |  |
                              \\  \\
                               '._'-._
                                  ```""");
        System.out.print(ConsoleColors.RESET);
    }

    /**
     * Day phase.
     */
    void dayPhase() {
        type = true;
        System.out.print(ConsoleColors.YELLOW_BRIGHT);
        System.out.println("""
                                 ;   :   ;
                              .   \\_,!,_/   ,
                               `.,'     `.,'
                                /         \\
                DAY PHASE  ~ -- :         : -- ~
                                \\         /
                               ,'`._   _.'`.
                              '   / `!` \\   `
                                 ;   :   ;""");
        System.out.print(ConsoleColors.RESET);
    }

    /**
     * Voting phase.
     */
    void votingPhase() {
        System.out.print("Please choose user to death: ");
    }
}
