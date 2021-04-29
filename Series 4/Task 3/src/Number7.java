public class Number7 extends Card implements Action {
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
