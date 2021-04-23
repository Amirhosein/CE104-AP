import java.util.ArrayList;

public class Triangle {
    private final ArrayList<Double> sides = new ArrayList<>();

    public Triangle(double a, double b, double c) {
        sides.add(a);
        sides.add(b);
        sides.add(c);
    }

    public ArrayList<Double> getSides() {
        return sides;
    }

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

    public double calculatePerimeter() {
        double sum = 0;

        for (Double side : sides)
            sum += side;

        return sum;
    }

    public double calculateArea() {
        double sum = 0;

        for (Double side : sides)
            sum += side;

        sum /= 2;
        return java.lang.Math.sqrt(sum * (sum - sides.get(0)) * (sum - sides.get(2)) * (sum - sides.get(1)));
    }

    public String draw() {
        return "Type: Triangle\nPerimeter: " + calculatePerimeter() + "\nArea: " + calculateArea();
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
                '}';
    }
}
