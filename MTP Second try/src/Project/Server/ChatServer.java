package Project.Server;

import java.io.*;
import java.net.*;
import java.util.*;

import Project.Console.ConsoleColors;

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
    public static String toBeSavedCitizen;
    public static String SavedMafia;

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
            nightPhase();
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
        mafiaNight();
        lectreNight();
    }

    private void lectreNight() {
        state = "DOCTOR LECTRE";
        notifyRole("DOCTOR LECTRE", "CHOOSE A MAFIA TO HEAL.");
    }

    private void mafiaNight() {
        state = "MAFIA";
        notifyRole("GODFATHER", "SPEAK: Discuss about who to be killed by GODFATHER");
        notifyRole("MAFIA", "SPEAK: Discuss about who to be killed by GODFATHER");
        notifyRole("DOCTOR LECTRE", "SPEAK: Discuss about who to be killed by GODFATHER");
        sleep(10000);
        state = "GODFATHER";
        showAliveUsers("GODFATHER");
        do {
            sleep(500);
        } while (!state.equalsIgnoreCase("GODFATHER DONE"));
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
        notifyRole("GODFATHER", ConsoleColors.YELLOW_BRIGHT + "***You are the god father, the true leader" +
                "of mafias.***" +
                "\nNORMAL MAFIA: " +
                getUsernameByRole("MAFIA") +
                "\nDOCTOR LECTRE: " + getUsernameByRole("DOCTOR LECTRE") + ConsoleColors.RESET)
        ;
        notifyRole("DOCTOR LECTRE", ConsoleColors.YELLOW_BRIGHT + "***You are the Doctor lectre the savior of mafias.***" +
                "\nNORMAL MAFIA: " + getUsernameByRole("MAFIA") +
                "\nGODFATHER: " + getUsernameByRole("GODFATHER"));
        notifyRole("MAFIA", ConsoleColors.YELLOW_BRIGHT + "***You are the normal mafia, but it doesnt mean that you are not necessary." +
                "***" +
                "\nGODFATHER: " + getUsernameByRole("GODFATHER") +
                "\nDOCTOR LECTRE: " + getUsernameByRole("DOCTOR LECTRE") + ConsoleColors.RESET);
        notifyRole("DOCTOR", ConsoleColors.YELLOW_BRIGHT + "***You are the doctor of citizens. the hope and savior of them***" + ConsoleColors.RESET);
        notifyRole("DETECTIVE", ConsoleColors.YELLOW_BRIGHT + "***You are the detective.***" + ConsoleColors.RESET);
        notifyRole("DIE HARD", ConsoleColors.YELLOW_BRIGHT + "***You are the Die Hard.***" + ConsoleColors.RESET);
        notifyRole("SNIPER", ConsoleColors.YELLOW_BRIGHT + "***You are the Sniper.***" + ConsoleColors.RESET);
        notifyRole("MAYOR", ConsoleColors.YELLOW_BRIGHT + "***You are the Mayor.***" + ConsoleColors.RESET);
        notifyRole("PSYCHOLOGIST", ConsoleColors.YELLOW_BRIGHT + "***You are the Psychologist.***" + ConsoleColors.RESET);
        notifyRole("CITIZEN", ConsoleColors.YELLOW_BRIGHT + "***You are the normal Citizen.***" + ConsoleColors.RESET);
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

    String getRoleByUsername(String username) {
        for (UserThread userThread : userThreads)
            if (userThread.getUserName().equalsIgnoreCase(username))
                return userThread.getRole();
        return null;
    }

    void showAliveUsers() {
        String finalString = ConsoleColors.GREEN_BOLD + "Alive Users: ";
        for (UserThread userThread : userThreads)
            if (userThread.userIsAlive())
                finalString = finalString.concat("{" + userThread.getUserName() + "}");
        finalString = finalString.concat(ConsoleColors.RESET);
        broadcast(finalString, null, null);
    }

    void showAliveUsers(String role) {
        String finalString = ConsoleColors.GREEN_BOLD + "Alive Users: ";
        for (UserThread userThread : userThreads)
            if (userThread.userIsAlive())
                finalString = finalString.concat("{" + userThread.getUserName() + "}");
        finalString = finalString.concat(ConsoleColors.RESET);
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
            deadUsers.add(dead);
            killUser(dead);
        }
        broadcast(result, null, null);
    }

    public void killUser(String username) {
        for (UserThread userThread : userThreads)
            if (userThread.getUserName().equalsIgnoreCase(username))
                userThread.setAlive(false);
        if (username != null)
            broadcast(ConsoleColors.RED_BOLD + username + " died." + ConsoleColors.RESET, null, null);
    }


}