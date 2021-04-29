public class Number8 extends Card implements Action{
    public Number8(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        return "num8";
    }
}
