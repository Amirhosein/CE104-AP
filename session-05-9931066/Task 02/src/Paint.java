import java.util.ArrayList;

/**
 * The type Paint.
 */
public class Paint {
    /**
     * The Shapes.
     */
    ArrayList<Shape> shapes = new ArrayList<>();

    /**
     * Add shape.
     *
     * @param shape the shape
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Draw all.
     */
    public void drawAll() {
        for (Shape shape : shapes)
            System.out.println(shape.draw());
    }

    /**
     * Print all.
     */
    public void printAll() {
        for (Shape shape : shapes)
            System.out.println(shape.toString());
    }

    /**
     * Describe equal sides.
     */
    public void describeEqualSides() {
        for (Shape shape : shapes)
            if (shape instanceof Triangle && ((Triangle) shape).isEquilateral())
                System.out.println(shape.toString());
            else if (shape instanceof Rectangle && ((Rectangle) shape).isSquare())
                System.out.println(shape.toString());
    }
}
