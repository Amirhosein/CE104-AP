package Server.Model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Amir Iravanimanesh
 * @date 5/31/2021
 */
public class Player {
    public static ArrayList<Player> players = new ArrayList<>();

    private final String username;

    public Player(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    private static boolean isDuplicate(String username) {
        for (Player player : players)
            if (player.getUsername().equalsIgnoreCase(username))
                return true;
        return false;
    }

    public static Player register(String username) {
        if (isDuplicate(username)){
            return null;
        }
        Player player = new Player(username);
        players.add(player);
        return player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getUsername(), player.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }
}
