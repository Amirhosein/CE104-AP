public class Card {
    private final int number;
    private int color;

    public int getValue() {
        return number;
    }

    public int getColor() {
        return color;
    }

    public Card(int number, int color) {
        this.number = number;
        this.color = color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
