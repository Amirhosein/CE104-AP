package Server;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author Amir Iravanimanesh
 * @date 6/7/2021
 */
public class ChatServer {
    public static final List<String> userNames = new ArrayList<>();
    private final Set<UserThread> userThreads = new HashSet<>();
    public static HashMap<String, ArrayList<String>> userAndVotes;
    public static String state = "NORMAL";
    public static ArrayList<String> deadUsers = new ArrayList<>();

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
                broadcast("Game is about to start ...", null, null);
            }
            setRoles();
            introductionNightPhase();
            dayPhase();
            votingPhase();
            dayPhase();
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void introductionNightPhase() {
        broadcast("NIGHT TIME", null, null);
        announceRoles();
        sleep(5000);
    }

    private void nightPhase() {
        broadcast("NIGHT TIME", null, null);

    }

    private void mafiaNight() {
        state = "MAFIA";
        notifyRole("GODFATHER", "SPEAK");
        notifyRole("MAFIA", "SPEAK");
        notifyRole("DOCTOR LECTRE", "SPEAK");
        sleep(10000);
        state = "GODFATHER";
        showAliveUsers("GODFATHER");


    }

    private void dayPhase() {
        broadcast("DAY TIME", null, null);
        showAliveUsers();
        sleep(20000);
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void announceRoles() {
        notifyRole("GODFATHER", "***You are the god father, the true leader" +
                "of mafias.***" +
                "\nNORMAL MAFIA: " +
                getUsernameByRole("MAFIA") +
                "\nDOCTOR LECTRE: " + getUsernameByRole("DOCTOR LECTRE")
        );
        notifyRole("DOCTOR LECTRE", "***You are the Doctor lectre the savior of mafias.***" +
                "\nNORMAL MAFIA: " + getUsernameByRole("MAFIA") +
                "\nGODFATHER: " + getUsernameByRole("GODFATHER"));
        notifyRole("MAFIA", "***You are the normal mafia, but it doesnt mean that you are not necessary." +
                "***" +
                "\nGODFATHER: " + getUsernameByRole("GODFATHER") +
                "\nDOCTOR LECTRE: " + getUsernameByRole("DOCTOR LECTRE"));
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
    void broadcast(String message, UserThread userThread, ArrayList<String> dead) {
        for (UserThread aUser : userThreads) {
            boolean check = true;
            if (dead != null)
                for (String string : dead) {
                    if (aUser.getUserName().equalsIgnoreCase(string)) {
                        check = false;
                        break;
                    }
                }
            if (aUser == userThread) {
                check = false;
            }
            if (check) {
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
        return userNames;
    }

    /**
     * Returns true if there are other users connected (not count the currently connected user)
     */
    boolean hasUsers() {
        return !userNames.isEmpty();
    }

    private void setRoles() {
        Set<UserThread> userThreads1 = new HashSet<>(userThreads);
        UserThread randomUserThread = randomThread(userThreads1.size(), userThreads1);
        for (String s : Arrays.asList("GODFATHER", "MAFIA", "DOCTOR LECTRE", "CITIZEN", "DOCTOR", "DETECTIVE", "SNIPER", "MAYOR", "DIE HARD")) {
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

    String getUsernameByRole(String role) {
        for (UserThread userThread : userThreads)
            if (userThread.getRole().equalsIgnoreCase(role))
                return userThread.getUserName();
        return null;
    }

    void showAliveUsers() {
        String finalString = "Alive Users: ";
        for (UserThread userThread : userThreads)
            if (userThread.userIsAlive())
                finalString = finalString.concat("{" + userThread.getUserName() + "}");
        broadcast(finalString, null, null);
    }

    void showAliveUsers(String role) {
        String finalString = "Alive Users: ";
        for (UserThread userThread : userThreads)
            if (userThread.userIsAlive())
                finalString = finalString.concat("{" + userThread.getUserName() + "}");
        notifyRole(role, finalString);
    }

    void votingPhase() {
        state = "VOTING";
        userAndVotes = new HashMap<>();
        for (String string : userNames) {
            userAndVotes.put(string, new ArrayList<>());
        }
        userAndVotes.put("NONE", new ArrayList<>());
        broadcast("VOTING", null, null);
        while (true) {
            sleep(1500);
            int sum = 0;
            for (String user : userNames) {
                sum += userAndVotes.get(user).size();
            }
            if (sum == userNames.size())
                break;
        }
        String result = " ";
        for (String user : userNames) {
            result = result.concat("[" + user + "] :");
            for (String votedBy : userAndVotes.get(user)) {
                result = result.concat("{" + votedBy + "} | ");
            }
            result = result.concat("Count = " + userAndVotes.get(user).size() + "\n");
        }
        int max = 0;
        String dead = "";
        for (String string : userNames) {
            if (userAndVotes.get(string).size() >= max) {
                max = userAndVotes.get(string).size();
                dead = string;
            }
        }
        int count = 0;
        for (String string : userNames) {
            if (userAndVotes.get(string).size() == max) {
                count++;
            }
        }
        if (count > 1) {
            result = result.concat("No one dies.\n");
        } else {
            result = result.concat(dead + "died by users vote.\n");
            deadUsers.add(dead);
        }
        broadcast(result, null, null);
    }


}
