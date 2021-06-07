package Server;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author Amir Iravanimanesh
 * @date 6/7/2021
 */
public class ChatServer {
    private final List<String> userNames = new ArrayList<>();
    private final Set<UserThread> userThreads = new HashSet<>();

    public void execute() {
        int port = 6000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Chat Server is listening on port " + port);

            while (userThreads.size() < 10) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");

                UserThread newUser = new UserThread(socket, this);
                userThreads.add(newUser);
                newUser.start();
            }
            while (true) {
                if (userNames.size() == 10)
                    break;
                else {
                    sleep(2000);
                }
            }
            for (int i = 0; i < 3; i++) {
                sleep(2000);
                broadcast("Game is about to start ...", null);
            }
            setRoles();
            broadcast("NIGHT TIME", null);
            announeRoles();
            sleep(5000);
            broadcast("DAY TIME", null);

        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void announeRoles() {
        notifyRole("GOD FATHER", "***You are the god father, the true leader" +
                "\n of mafias.***");
        notifyRole("DOCTOR LECTRE", "***You are the Doctor lectre the savior of mafias.***");
        notifyRole("MAFIA", "***You are the normal mafia, but it doesnt mean that you are not necessary." +
                "***");
        notifyRole("DOCTOR", "***You are the doctor of citizens. the hope and savior of them***");
        notifyRole("DETECTIVE", "***You are the detective.***");
        notifyRole("DIE HARD", "***You are the Die Hard.***");
        notifyRole("SNIPER", "***You are the Sniper.***");
        notifyRole("MAYOR", "***You are the Mayor.***");
        notifyRole("PSYCHOLOGIST", "***You are the Psychologist.***");
        notifyRole("CITIZEN", "***You are the normal Citizen.***");
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.execute();
    }

    /**
     * Delivers a message from one user to others (broadcasting)
     */
    void broadcast(String message, UserThread excludeUser) {
        for (UserThread aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }

    /**
     * Stores username of the newly connected client.
     */
    void addUserName(String userName) {
        userNames.add(userName);
    }

    /**
     * When a client is disconneted, removes the associated username and UserThread
     */
    void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }

    List<String> getUserNames() {
        return this.userNames;
    }

    /**
     * Returns true if there are other users connected (not count the currently connected user)
     */
    boolean hasUsers() {
        return !this.userNames.isEmpty();
    }

    private void setRoles() {
        Set<UserThread> userThreads1 = new HashSet<>(userThreads);
        UserThread randomUserThread = randomThread(userThreads1.size(), userThreads1);
        for (String s : Arrays.asList("GOD FATHER", "MAFIA", "DOCTOR LECTRE", "CITIZEN", "DOCTOR", "DETECTIVE", "SNIPER", "MAYOR", "DIE HARD")) {
            assert randomUserThread != null;
            randomUserThread.setRole(s);
            userThreads1.remove(randomUserThread);
            randomUserThread = randomThread(userThreads1.size(), userThreads1);
        }
        assert randomUserThread != null;
        randomUserThread.setRole("PSYCHOLOGIST");
        userThreads1.remove(randomUserThread);


    }

    private UserThread randomThread(int size, Set<UserThread> userThreadList) {
        Random random = new Random();
        int item = random.nextInt(size);
        int i = 0;
        for (UserThread userThread : userThreadList) {
            if (i == item)
                return userThread;
            i++;
        }
        return null;
    }

    void notifyRole(String role, String message) {
        for (UserThread userThread : userThreads) {
            if (userThread.getRole().equalsIgnoreCase(role))
                userThread.sendMessage(message);
        }
    }

}
