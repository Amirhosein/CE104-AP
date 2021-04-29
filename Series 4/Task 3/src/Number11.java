public class Number11 extends Card implements Action{
    public Number11(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        return "num11";
    }
}
