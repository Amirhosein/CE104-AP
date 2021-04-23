import java.util.ArrayList;

public class Rectangle {
    private final ArrayList<Double> sides = new ArrayList<>();

    public Rectangle(double a, double b, double c, double d) {
        sides.add(a);
        sides.add(b);
        sides.add(c);
        sides.add(d);
    }

    public ArrayList<Double> getSides() {
        return sides;
    }

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

    public double calculatePerimeter() {
        double sum = 0;

        for (Double side : sides)
            sum += side;

        return sum;
    }

    public double calculateArea() {
        return sides.get(0) * sides.get(1);
    }

    public String draw() {
        return "Type: Rectangle\nPerimeter: " + calculatePerimeter() + "\nArea: " + calculateArea();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sides=" + sides +
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

