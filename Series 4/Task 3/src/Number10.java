public class Number10 extends Card implements Action {
    public Number10(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        return "num10";
    }
}
