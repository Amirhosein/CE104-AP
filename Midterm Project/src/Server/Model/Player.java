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
    private final String password;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private boolean isDuplicate(String username) {
        for (Player player : players)
            if (player.getUsername().equalsIgnoreCase(username))
                return false;
        return true;
    }

    public boolean register(String username, String password) {
        if (isDuplicate(username))
            return false;
        Player player = new Player(username, password);
        players.add(player);
        return true;
    }

    public Player login(String username, String password) {
        Player player = new Player(username, password);
        for (Player player1 : players)
            if (player1.equals(player))
                return player;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getUsername(), player.getUsername()) && Objects.equals(getPassword(), player.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }
}
