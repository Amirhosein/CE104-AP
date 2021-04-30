import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        int choose;
        System.out.println("Number of Players (3, 4, 5): ");
        choose = scanner.nextInt();
        if (choose == 3) {
            Player player1 = new Player("player1");
            Player player2 = new Player("player2");
            Player player3 = new Player("player3");
            players.add(player1);
            players.add(player2);
            players.add(player3);
        } else if (choose == 4) {
            Player player1 = new Player("player1");
            Player player2 = new Player("player2");
            Player player3 = new Player("player3");
            Player player4 = new Player("player4");
            players.add(player1);
            players.add(player2);
            players.add(player3);
            players.add(player4);
        } else if (choose == 5) {
            Player player1 = new Player("player1");
            Player player2 = new Player("player2");
            Player player3 = new Player("player3");
            Player player4 = new Player("player4");
            Player player5 = new Player("player5");
            players.add(player1);
            players.add(player2);
            players.add(player3);
            players.add(player4);
            players.add(player5);
        }

        Game game = new Game(players);
        while (game.nextTurn());
    }
}
