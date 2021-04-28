public class Number2 extends Card implements Action {


    public Number2(int number, int color) {
        super(number, color);
    }

    @Override
    public String action() {
        return "num2";
    }
}
