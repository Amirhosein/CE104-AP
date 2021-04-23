/**
 * The type Circle.
 */
public class Circle {
    private final double radius;

    /**
     * Instantiates a new Circle.
     *
     * @param radius the radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Gets radius.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Calculate perimeter double.
     *
     * @return the double
     */
    public double calculatePerimeter() {
        return 2 * radius * 3.14;
    }

    /**
     * Calculate area double.
     *
     * @return the double
     */
    public double calculateArea() {
        return radius * radius * 3.14;
    }

    /**
     * Draw string.
     *
     * @return the string
     */
    public String draw() {
        return "Type: Circle\n" + "Perimeter: " + calculatePerimeter() + "\nArea: " + calculateArea() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
