/**
 * The type Number 2.
 */
public class Number2 extends Card implements Action {


    /**
     * Instantiates a new Number 2.
     *
     * @param number the number
     * @param color  the color
     */
    public Number2(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        return "num2";
    }
}
