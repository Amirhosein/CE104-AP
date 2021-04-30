/**
 * The type Number 12.
 */
public class Number12 extends Card implements Action {
    /**
     * Instantiates a new Number 12.
     *
     * @param number the number
     * @param color  the color
     */
    public Number12(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        return "num12";
    }
}
