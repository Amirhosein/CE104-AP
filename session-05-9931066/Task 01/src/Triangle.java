import java.util.ArrayList;

/**
 * The type Triangle.
 */
public class Triangle {
    private final ArrayList<Double> sides = new ArrayList<>();

    /**
     * Instantiates a new Triangle.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     */
    public Triangle(double a, double b, double c) {
        sides.add(a);
        sides.add(b);
        sides.add(c);
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
     * Is equilateral boolean.
     *
     * @return the boolean
     */
    public boolean isEquilateral() {
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
        double sum = 0;

        for (Double side : sides)
            sum += side;

        sum /= 2;
        return java.lang.Math.sqrt(sum * (sum - sides.get(0)) * (sum - sides.get(2)) * (sum - sides.get(1)));
    }

    /**
     * Draw string.
     *
     * @return the string
     */
    public String draw() {
        return "Type: Triangle\nPerimeter: " + calculatePerimeter() + "\nArea: " + calculateArea() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return sides.equals(triangle.sides);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sides=" + sides +
                ", Equilateral=" + isEquilateral() +
                '}';
    }
}
