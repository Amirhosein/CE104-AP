/**
 * The type Number 7.
 */
public class Number7 extends Card implements Action {
    /**
     * Instantiates a new Number 7.
     *
     * @param number the number
     * @param color  the color
     */
    public Number7(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        if (getColor() == 3)
            return "num7b";
        else return "num7";
    }
}
