import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Random random = new Random();
    private final Scanner input = new Scanner(System.in);
    private final ArrayList<Player> players;
    private final ArrayList<Card> storage = new ArrayList<>();
    private int turn;
    private int direction = 1;
    private Card lastCard;

    private int choose;

    public Game(ArrayList<Player> players) {
        this.players = players;
        Card card2r = new Number2(2, 1);
        Card card3r = new Card(3, 1);
        Card card4r = new Card(4, 1);
        Card card5r = new Card(5, 1);
        Card card6r = new Card(6, 1);
        Card card7r = new Number7(7, 1);
        Card card8r = new Number8(8, 1);
        Card card9r = new Card(9, 1);
        Card card10r = new Number10(10, 1);
        Card card11r = new Number11(11, 1);
        Card card12r = new Number12(12, 1);
        Card card13r = new Card(13, 1);
        Card card14r = new Card(14, 1);
        Card card2b = new Number2(2, 2);
        Card card3b = new Card(3, 2);
        Card card4b = new Card(4, 2);
        Card card5b = new Card(5, 2);
        Card card6b = new Card(6, 2);
        Card card7b = new Number7(7, 2);
        Card card8b = new Number8(8, 2);
        Card card9b = new Card(9, 2);
        Card card10b = new Number10(10, 2);
        Card card11b = new Number11(11, 2);
        Card card12b = new Number12(12, 2);
        Card card13b = new Card(13, 2);
        Card card14b = new Card(14, 2);
        Card card2B = new Number2(2, 3);
        Card card3B = new Card(3, 3);
        Card card4B = new Card(4, 3);
        Card card5B = new Card(5, 3);
        Card card6B = new Card(6, 3);
        Card card7B = new Number7(7, 3);
        Card card8B = new Number8(8, 3);
        Card card9B = new Card(9, 3);
        Card card10B = new Number10(10, 3);
        Card card11B = new Number11(11, 3);
        Card card12B = new Number12(12, 3);
        Card card13B = new Card(13, 3);
        Card card14B = new Card(14, 3);
        Card card2g = new Number2(2, 4);
        Card card3g = new Card(3, 4);
        Card card4g = new Card(4, 4);
        Card card5g = new Card(5, 4);
        Card card6g = new Card(6, 4);
        Card card7g = new Number7(7, 4);
        Card card8g = new Number8(8, 4);
        Card card9g = new Card(9, 4);
        Card card10g = new Number10(10, 4);
        Card card11g = new Number11(11, 4);
        Card card12g = new Number12(12, 4);
        Card card13g = new Card(13, 4);
        Card card14g = new Card(14, 4);
        storage.add(card2g);
        storage.add(card3g);
        storage.add(card4g);
        storage.add(card5g);
        storage.add(card6g);
        storage.add(card7g);
        storage.add(card8g);
        storage.add(card9g);
        storage.add(card10g);
        storage.add(card11g);
        storage.add(card12g);
        storage.add(card13g);
        storage.add(card14g);
        storage.add(card2r);
        storage.add(card3r);
        storage.add(card4r);
        storage.add(card5r);
        storage.add(card6r);
        storage.add(card7r);
        storage.add(card8r);
        storage.add(card9r);
        storage.add(card10r);
        storage.add(card11r);
        storage.add(card12r);
        storage.add(card13r);
        storage.add(card14r);
        storage.add(card2b);
        storage.add(card3b);
        storage.add(card4b);
        storage.add(card5b);
        storage.add(card6b);
        storage.add(card7b);
        storage.add(card8b);
        storage.add(card9b);
        storage.add(card10b);
        storage.add(card11b);
        storage.add(card12b);
        storage.add(card13b);
        storage.add(card14b);
        storage.add(card2B);
        storage.add(card3B);
        storage.add(card4B);
        storage.add(card5B);
        storage.add(card6B);
        storage.add(card7B);
        storage.add(card8B);
        storage.add(card9B);
        storage.add(card10B);
        storage.add(card11B);
        storage.add(card12B);
        storage.add(card13B);
        storage.add(card14B);

        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                int temp = random.nextInt(storage.size());
                player.addCard(storage.get(temp));
                storage.remove(temp);
            }
        }

        turn = random.nextInt(players.size());
        lastCard = storage.get(random.nextInt(storage.size()));
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

    public void number2b() {
        Card card = players.get(turn).getCards().get(random.nextInt(players.get(turn).getCards().size()));
        players.get(random.nextInt(players.size())).addCard(card);
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

    public void printHand(int index) {
        Iterator<Card> iterator = players.get(index).getCards().iterator();
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
        printHand(turn);
        System.out.println("""
                                     =============================
                                                Last Card:         \s
                """);
        printCard(lastCard);
        for (Player player : players) {
            System.out.print(player.getName() + ": " + player.getCards().size() + "                   ");
        }
        System.out.println();

    }

    public boolean nextTurn() {
        System.out.println(turn);
        if (turn == players.size() && direction == 1)
            turn = 0;
        else if (turn == -1 && direction == -1)
            turn = players.size() - 1;

        else if (turn == 0) {
            printGame();
            System.out.println("\nPlease choose a card (type index of card from top (0) to down): ");
            choose = input.nextInt();
            if (choose == -1) {
                players.get(0).getCards().add(storage.get(random.nextInt(storage.size())));
                if (players.get(0).getCards().get(players.get(0).getCards().size() - 1).getValue() == lastCard.getValue() || players.get(0).getCards().get(players.get(0).getCards().size() - 1).getColor() == lastCard.getColor()) {
                    lastCard = players.get(0).getCards().get(players.get(0).getCards().size() - 1);
                    if (players.get(0).getCards().get(players.get(0).getCards().size() - 1) instanceof Action)
                        detectAction(((Action) players.get(0).getCards().get(players.get(0).getCards().size() - 1)).action(), 0);
                    players.get(0).getCards().remove(players.get(0).getCards().size() - 1);

                }
                turn += direction;
                return true;
            }
            if (players.get(0).getCards().get(choose).getValue() != lastCard.getValue() && players.get(0).getCards().get(choose).getColor() != lastCard.getColor()) {
                return true;
            }

            lastCard = players.get(0).getCards().get(choose);
            if (players.get(0).getCards().get(choose) instanceof Action)
                detectAction(((Action) players.get(0).getCards().get(choose)).action(), 0);
            players.get(0).getCards().remove(choose);
            turn += direction;
        } else {
            printGame();
            boolean state = false;
            for (Card card : players.get(turn).getCards()) {
                if (card.getColor() == lastCard.getColor() || card.getValue() == lastCard.getValue()) {
                    lastCard = card;
                    if (card instanceof Action)
                        detectAction(((Action) card).action(), 1);
                    players.get(turn).getCards().remove(card);
                    state = true;
                    break;
                }
            }
            if (!state) {
                players.get(turn).getCards().add(storage.get(random.nextInt(storage.size())));
                if (players.get(turn).getCards().get(players.get(turn).getCards().size() - 1).getValue() == lastCard.getValue() || players.get(turn).getCards().get(players.get(turn).getCards().size() - 1).getColor() == lastCard.getColor()) {
                    lastCard = players.get(turn).getCards().get(players.get(turn).getCards().size() - 1);
                    if (lastCard instanceof Action)
                        detectAction(((Action) lastCard).action(), 1);
                    players.get(turn).getCards().remove(players.get(turn).getCards().size() - 1);
                }
                turn += direction;
                return true;
            }

            turn += direction;

        }

        for (Player player : players)
            if (player.getCards().size() == 0)
                return false;

        return true;
    }

    public void detectAction(String string, int mode) {
        switch (string) {
            case "num2":
                if (mode == 0)
                    number2();
                else number2b();
                break;
            case "num7":
                number7();
                break;
            case "num7b":
                number7b();
                break;
            case "num8":
                number8();
                break;
            case "num10":
                number10();
                break;
            case "num11":
                number11();
                break;
            case "num12":
                number12();
                break;
        }

    }

    public void number7() {
        int defaultno = 2;
        boolean stat = true;
        while (stat) {
            turn += direction;
            if (turn == players.size() && direction == 1)
                turn = 0;
            else if (turn == -1 && direction == -1)
                turn = players.size() - 1;
            for (Card card : players.get(turn).getCards()) {
                if (card.getValue() == 7) {
                    storage.add(card);
                    players.get(turn).getCards().remove(card);
                    lastCard = card;
                    defaultno += 2;
                    break;
                } else {
                    turn += direction;
                    if (turn == players.size() && direction == 1)
                        turn = 0;
                    else if (turn == -1 && direction == -1)
                        turn = players.size() - 1;

                    for (int i = 0; i < defaultno; i++) {
                        Card temp = storage.get(random.nextInt(storage.size()));
                        players.get(turn).addCard(temp);
                        storage.remove(temp);
                    }
                    stat = false;
                }

            }

        }

    }

    public void number7b() {
        int defaultno = 4;
        boolean stat = true;
        while (stat) {
            turn += direction;
            if (turn == players.size() && direction == 1)
                turn = 0;
            else if (turn == -1 && direction == -1)
                turn = players.size() - 1;

            for (Card card : players.get(turn).getCards()) {
                if (card.getValue() == 7) {
                    storage.add(card);
                    players.get(turn).getCards().remove(card);
                    lastCard = card;
                    defaultno += 2;
                    break;
                } else {
                    turn += direction;
                    if (turn == players.size() && direction == 1)
                        turn = 0;
                    else if (turn == -1 && direction == -1)
                        turn = players.size() - 1;

                    for (int i = 0; i < defaultno; i++) {
                        Card temp = storage.get(random.nextInt(storage.size()));
                        players.get(turn).addCard(temp);
                        storage.remove(temp);
                    }
                    stat = false;
                }

            }

        }

    }

    public void number8() {
        turn -= direction;
    }

    public void number10() {
        direction *= -1;
    }

    public void number11() {
        turn += direction;
    }

    public void number12() {
        System.out.print("Please enter the color: ");
        String string;
        input.nextLine();
        string = input.nextLine();
        if (string.equalsIgnoreCase("red")) {
            lastCard.setColor(1);
        } else if (string.equalsIgnoreCase("blue")) {
            lastCard.setColor(2);
        } else if (string.equalsIgnoreCase("black"))
            lastCard.setColor(3);
        else if (string.equalsIgnoreCase("green"))
            lastCard.setColor(4);
    }
}