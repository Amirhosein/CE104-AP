package Project.Server;

public class Night {
    private final ChatServer chatServer;

    public Night(ChatServer chatServer) {
        this.chatServer = chatServer;
    }

    void dieHardNight() {
        if (!chatServer.roleIsAlive("DIE HARD"))
            return;
        ChatServer.state = "DIE HARD";
        chatServer.notifyRole("DIE HARD", "SPEAK: DO YOU WANT TO USE YOUR ABILITY?(Y/N)");
        do {
            chatServer.sleep(500);
        } while (!ChatServer.state.equalsIgnoreCase("DIE HARD DONE"));
    }

    void psychologistNight() {
        if (!chatServer.roleIsAlive("PSYCHOLOGIST"))
            return;
        ChatServer.state = "PSYCHOLOGIST";
        chatServer.notifyRole("PSYCHOLOGIST", "SPEAK: DO WANT TO USE YOUR ABILITY?(Y/N)");
        do {
            chatServer.sleep(500);
        } while (!ChatServer.state.equalsIgnoreCase("PSYCHOLOGIST DONE"));
    }

    void sniperNight() {
        if (!chatServer.roleIsAlive("SNIPER"))
            return;
        ChatServer.state = "SNIPER";
        chatServer.notifyRole("SNIPER", "SPEAK: DO YOU WANT TO TRY YOUR LUCK?(Y/N)");
        do {
            chatServer.sleep(500);
        } while (!ChatServer.state.equalsIgnoreCase("SNIPER DONE"));
    }

    void detectiveNight() {
        if (!chatServer.roleIsAlive("DETECTIVE"))
            return;
        ChatServer.state = "DETECTIVE";
        chatServer.notifyRole("DETECTIVE", "SPEAK: CHOOSE A USER TO BE INQUIRED.");
        do {
            chatServer.sleep(500);
        } while (!ChatServer.state.equalsIgnoreCase("DETECTIVE DONE"));
    }

    void lectreNight() {
        if (!chatServer.roleIsAlive("DOCTOR LECTRE"))
            return;
        ChatServer.state = "DOCTOR LECTRE";
        chatServer.notifyRole("DOCTOR LECTRE", "SPEAK: CHOOSE A MAFIA TO HEAL.");
        do {
            chatServer.sleep(500);
        } while (!ChatServer.state.equalsIgnoreCase("DOCTOR LECTRE DONE"));
    }

    void doctorNight() {
        if (!chatServer.roleIsAlive("DOCTOR"))
            return;
        ChatServer.state = "DOCTOR";
        chatServer.notifyRole("DOCTOR", "SPEAK: CHOOSE A USER TO HEAL:");
        do {
            chatServer.sleep(500);
        } while (!ChatServer.state.equalsIgnoreCase("DOCTOR DONE"));
    }

    void mafiaNight() {
        ChatServer.state = "MAFIA";
        chatServer.notifyRole("GODFATHER", "SPEAK: Discuss about who to be killed by GODFATHER");
        chatServer.notifyRole("MAFIA", "SPEAK: Discuss about who to be killed by GODFATHER");
        chatServer.notifyRole("DOCTOR LECTRE", "SPEAK: Discuss about who to be killed by GODFATHER");
        chatServer.sleep(10000);
        ChatServer.state = "GODFATHER";
        chatServer.showAliveUsers("GODFATHER");
        do {
            chatServer.sleep(500);
        } while (!ChatServer.state.equalsIgnoreCase("GODFATHER DONE"));
    }
}