import java.util.ArrayList;

/**
 * The type Paint.
 */
public class Paint {
    private ArrayList<Triangle> triangles = new ArrayList<>();
    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    private ArrayList<Circle> circles = new ArrayList<>();

    /**
     * Add triangle.
     *
     * @param triangle the triangle
     */
    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    /**
     * Add circle.
     *
     * @param circle the circle
     */
    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    /**
     * Add rectangle.
     *
     * @param rectangle the rectangle
     */
    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * Draw all.
     */
    public void drawAll() {
        for (Triangle triangle : triangles)
            System.out.println(triangle.draw());

        for (Rectangle rectangle : rectangles)
            System.out.println(rectangle.draw());

        for (Circle circle : circles)
            System.out.println(circle.draw());
    }

    /**
     * Print all.
     */
    public void printAll() {
        for (Triangle triangle : triangles)
            System.out.println(triangle.toString());

        for (Rectangle rectangle : rectangles)
            System.out.println(rectangle.toString());

        for (Circle circle : circles)
            System.out.println(circle.toString());
    }

}
