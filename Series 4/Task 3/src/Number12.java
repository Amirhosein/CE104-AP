public class Number12 extends Card implements Action{
    public Number12(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        return "num12";
    }
}
