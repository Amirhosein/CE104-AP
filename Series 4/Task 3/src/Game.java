import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Random random = new Random();
    private Scanner input = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Card> Storage = new ArrayList<>();
    private int turn;
    private int direction = 1;
    private Card lastCard;

    private int choose;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Game(ArrayList<Player> players) {
        this.players = players;
        Card card2r = new Card(2, 1);
        Card card3r = new Card(3, 1);
        Card card4r = new Card(4, 1);
        Card card5r = new Card(5, 1);
        Card card6r = new Card(6, 1);
        Card card7r = new Card(7, 1);
        Card card8r = new Card(8, 1);
        Card card9r = new Card(9, 1);
        Card card10r = new Card(10, 1);
        Card card11r = new Card(11, 1);
        Card card12r = new Card(12, 1);
        Card card13r = new Card(13, 1);
        Card card14r = new Card(14, 1);
        Card card2b = new Card(2, 2);
        Card card3b = new Card(3, 2);
        Card card4b = new Card(4, 2);
        Card card5b = new Card(5, 2);
        Card card6b = new Card(6, 2);
        Card card7b = new Card(7, 2);
        Card card8b = new Card(8, 2);
        Card card9b = new Card(9, 2);
        Card card10b = new Card(10, 2);
        Card card11b = new Card(11, 2);
        Card card12b = new Card(12, 2);
        Card card13b = new Card(13, 2);
        Card card14b = new Card(14, 2);
        Card card2B = new Card(2, 3);
        Card card3B = new Card(3, 3);
        Card card4B = new Card(4, 3);
        Card card5B = new Card(5, 3);
        Card card6B = new Card(6, 3);
        Card card7B = new Card(7, 3);
        Card card8B = new Card(8, 3);
        Card card9B = new Card(9, 3);
        Card card10B = new Card(10, 3);
        Card card11B = new Card(11, 3);
        Card card12B = new Card(12, 3);
        Card card13B = new Card(13, 3);
        Card card14B = new Card(14, 3);
        Card card2g = new Card(2, 4);
        Card card3g = new Card(3, 4);
        Card card4g = new Card(4, 4);
        Card card5g = new Card(5, 4);
        Card card6g = new Card(6, 4);
        Card card7g = new Card(7, 4);
        Card card8g = new Card(8, 4);
        Card card9g = new Card(9, 4);
        Card card10g = new Card(10, 4);
        Card card11g = new Card(11, 4);
        Card card12g = new Card(12, 4);
        Card card13g = new Card(13, 4);
        Card card14g = new Card(14, 4);
        Storage.add(card2g);
        Storage.add(card3g);
        Storage.add(card4g);
        Storage.add(card5g);
        Storage.add(card6g);
        Storage.add(card7g);
        Storage.add(card8g);
        Storage.add(card9g);
        Storage.add(card10g);
        Storage.add(card11g);
        Storage.add(card12g);
        Storage.add(card13g);
        Storage.add(card14g);
        Storage.add(card2r);
        Storage.add(card3r);
        Storage.add(card4r);
        Storage.add(card5r);
        Storage.add(card6r);
        Storage.add(card7r);
        Storage.add(card8r);
        Storage.add(card9r);
        Storage.add(card10r);
        Storage.add(card11r);
        Storage.add(card12r);
        Storage.add(card13r);
        Storage.add(card14r);
        Storage.add(card2b);
        Storage.add(card3b);
        Storage.add(card4b);
        Storage.add(card5b);
        Storage.add(card6b);
        Storage.add(card7b);
        Storage.add(card8b);
        Storage.add(card9b);
        Storage.add(card10b);
        Storage.add(card11b);
        Storage.add(card12b);
        Storage.add(card13b);
        Storage.add(card14b);
        Storage.add(card2B);
        Storage.add(card3B);
        Storage.add(card4B);
        Storage.add(card5B);
        Storage.add(card6B);
        Storage.add(card7B);
        Storage.add(card8B);
        Storage.add(card9B);
        Storage.add(card10B);
        Storage.add(card11B);
        Storage.add(card12B);
        Storage.add(card13B);
        Storage.add(card14B);

        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                int temp = random.nextInt(Storage.size());
                player.addCard(Storage.get(temp));
                Storage.remove(temp);
            }
        }

        turn = random.nextInt(players.size());
        lastCard = Storage.get(random.nextInt(Storage.size()));
    }


    public void number2() {
        Card card = players.get(turn).getCards().get(random.nextInt(players.get(turn).getCards().size()));

        System.out.println("Choose Player:");

        int index = 1;
        for (Player player : players) {
            System.out.println(index + ". " + player.getName() + '\n');
            index++;
        }

        choose = input.nextInt();

        players.get(choose - 1).addCard(card);

    }

    public Card getLastCard() {
        return lastCard;
    }

    public void printCard(Card card) {
        String string;
        if (card.getValue() == 11) {
            string = "A";
        } else if (card.getValue() == 12)
            string = "B";
        else if (card.getValue() == 13)
            string = "C";
        else if (card.getValue() == 14)
            string = "D";
        else string = Integer.toString(card.getValue());
        if (card.getColor() == 1) {
            System.out.print(ConsoleColors.RED_BOLD);
            System.out.println("                          -------------------                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |   " + string + "             |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          -------------------                          ");
            System.out.print(ConsoleColors.RESET);
        } else if (card.getColor() == 2) {
            System.out.print(ConsoleColors.BLUE_BOLD);
            System.out.println("                          -------------------                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |   " + string + "             |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          -------------------                          ");
            System.out.print(ConsoleColors.RESET);
        } else if (card.getColor() == 3) {
            System.out.print(ConsoleColors.WHITE_BOLD);
            System.out.println("                          -------------------                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |   " + string + "             |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          -------------------                          ");
            System.out.print(ConsoleColors.RESET);
        } else if (card.getColor() == 4) {
            System.out.print(ConsoleColors.GREEN_BOLD);
            System.out.println("                          -------------------                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |   " + string + "             |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          |                 |                          ");
            System.out.println("                          -------------------                          ");
            System.out.print(ConsoleColors.RESET);
        }

    }

    public void printHand() {
        Iterator<Card> iterator = players.get(0).getCards().iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (!iterator.hasNext()) {
                printCard(card);
                break;
            }
            String string;
            if (card.getValue() == 11) {
                string = "A";
            } else if (card.getValue() == 12)
                string = "B";
            else if (card.getValue() == 13)
                string = "C";
            else if (card.getValue() == 14)
                string = "D";
            else string = Integer.toString(card.getValue());
            if (card.getColor() == 1) {
                System.out.print(ConsoleColors.RED_BOLD);
                System.out.println("                          -------------------                          ");
                System.out.println("                          |                 |                          ");
                System.out.println("                          |   " + string + "             |                          ");

                System.out.print(ConsoleColors.RESET);
            } else if (card.getColor() == 2) {
                System.out.print(ConsoleColors.BLUE_BOLD);
                System.out.println("                          -------------------                          ");
                System.out.println("                          |                 |                          ");
                System.out.println("                          |   " + string + "             |                          ");

                System.out.print(ConsoleColors.RESET);
            } else if (card.getColor() == 3) {
                System.out.print(ConsoleColors.WHITE_BOLD);
                System.out.println("                          -------------------                          ");
                System.out.println("                          |                 |                          ");
                System.out.println("                          |   " + string + "             |                          ");

                System.out.print(ConsoleColors.RESET);
            } else if (card.getColor() == 4) {
                System.out.print(ConsoleColors.GREEN_BOLD);
                System.out.println("                          -------------------                          ");
                System.out.println("                          |                 |                          ");
                System.out.println("                          |   " + string + "             |                          ");

                System.out.print(ConsoleColors.RESET);
            }
        }
    }

    public void printGame() {
        printHand();
        System.out.println("                     =============================\n" +
                "                                Last Card:          \n");
        printCard(lastCard);
        for (Player player : players) {
            System.out.print(player.getName() + ": " + player.getCards().size() + "                   ");
        }

    }

    public boolean nextTurn() {
        if (turn == players.size() + 1)
            turn = 0;
        else if (turn == -1)
            turn = players.size();
        else if (turn == 0) {
            printGame();
            System.out.println("\nPlease choose a card (type index of card from top (0) to down): ");
            choose = input.nextInt();
            if (players.get(0).getCards().get(choose).getValue() != lastCard.getValue() && players.get(0).getCards().get(choose).getColor() != lastCard.getColor())
                return true;
            lastCard = players.get(0).getCards().get(choose);
            players.get(0).getCards().remove(choose);
            turn += direction;
        } else {
            for (Card card : players.get(turn).getCards()){
                if (card.getColor() == lastCard.getColor() || card.getValue() == lastCard.getValue()){
                    lastCard = players.get(0).getCards().get(choose);
                    players.get(0).getCards().remove(choose);
                    break;
                }
            }

            turn += direction;

        }

        for (Player player : players)
            if (player.getCards().size() == 0)
                return false;

        return true;
    }
}
