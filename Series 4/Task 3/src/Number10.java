/**
 * The type Number 10.
 */
public class Number10 extends Card implements Action {
    /**
     * Instantiates a new Number 10.
     *
     * @param number the number
     * @param color  the color
     */
    public Number10(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        return "num10";
    }
}
