public class Circle {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double calculatePerimeter() {
        return 2 * radius * 3.14;
    }

    public double calculateArea() {
        return radius * radius * 3.14;
    }

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
