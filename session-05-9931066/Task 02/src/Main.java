/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(1,1,1,1);
        Shape rect2 = new Rectangle(2,1,2,1);
        Shape tr1 = new Triangle(1,1,1);
        Shape tr2 = new Triangle(3,4,5);
        Shape cr1 = new Circle(1);
        Paint paint = new Paint();
        paint.addShape(rect1);
        paint.addShape(rect2);
        paint.addShape(tr1);
        paint.addShape(tr2);
        paint.addShape(cr1);
        paint.drawAll();
        paint.printAll();
        paint.describeEqualSides();
    }
}
