/**
 * The type Circle.
 */
public class Circle extends Shape {
    private double radius;

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

    @Override
    public double calculatePerimeter() {
        return radius * 2 * 3.14;
    }

    @Override
    public double calculateArea() {
        return radius * radius * 3.14;
    }

    @Override
    public String draw() {
        return "Type: Circle\n" + "Perimeter: " + calculatePerimeter() + "\nArea: " + calculateArea() + "\n";
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }


}
