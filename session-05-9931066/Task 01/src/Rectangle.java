import java.util.ArrayList;

/**
 * The type Rectangle.
 */
public class Rectangle {
    private final ArrayList<Double> sides = new ArrayList<>();

    /**
     * Instantiates a new Rectangle.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     * @param d the d
     */
    public Rectangle(double a, double b, double c, double d) {
        sides.add(a);
        sides.add(b);
        sides.add(c);
        sides.add(d);
    }

    /**
     * Gets sides.
     *
     * @return the sides
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     * Is square boolean.
     *
     * @return the boolean
     */
    public boolean isSquare() {
        Double temp = sides.get(0);

        for (Double side : sides) {
            if (!side.equals(temp)) {
                return false;
            }
            temp = side;
        }

        return true;
    }

    /**
     * Calculate perimeter double.
     *
     * @return the double
     */
    public double calculatePerimeter() {
        double sum = 0;

        for (Double side : sides)
            sum += side;

        return sum;
    }

    /**
     * Calculate area double.
     *
     * @return the double
     */
    public double calculateArea() {
        return sides.get(0) * sides.get(1);
    }

    /**
     * Draw string.
     *
     * @return the string
     */
    public String draw() {
        return "Type: Rectangle\nPerimeter: " + calculatePerimeter() + "\nArea: " + calculateArea() + "\n";
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sides=" + sides +
                ", Square=" + isSquare() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return sides.equals(rectangle.sides);
    }

}

