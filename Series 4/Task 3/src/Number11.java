/**
 * The type Number 11.
 */
public class Number11 extends Card implements Action {
    /**
     * Instantiates a new Number 11.
     *
     * @param number the number
     * @param color  the color
     */
    public Number11(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        return "num11";
    }
}
