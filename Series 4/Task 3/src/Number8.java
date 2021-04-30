/**
 * The type Number 8.
 */
public class Number8 extends Card implements Action {
    /**
     * Instantiates a new Number 8.
     *
     * @param number the number
     * @param color  the color
     */
    public Number8(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        return "num8";
    }
}
