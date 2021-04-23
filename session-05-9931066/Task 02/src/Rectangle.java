import java.util.ArrayList;

public class Rectangle extends Polygon {


    public Rectangle(double a, double b, double c, double d) {
        getSides().add(a);
        getSides().add(b);
        getSides().add(c);
        getSides().add(d);
    }

    @Override
    public double calculatePerimeter() {
        double sum = 0;

        for (Double side : getSides())
            sum += side;

        return sum;
    }

    @Override
    public double calculateArea() {
        return getSides().get(0) * getSides().get(1);
    }

    @Override
    public String draw() {
        return "Type: Rectangle\nPerimeter: " + calculatePerimeter() + "\nArea: " + calculateArea() + "\n";
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sides=" + getSides() +
                ", Square=" + isSquare() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return getSides().equals(rectangle.getSides());
    }

    public boolean isSquare() {
        Double temp = getSides().get(0);

        for (Double side : getSides()) {
            if (!side.equals(temp)) {
                return false;
            }
            temp = side;
        }

        return true;
    }
}
