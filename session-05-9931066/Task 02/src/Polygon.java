import java.util.ArrayList;

public abstract class Polygon extends Shape {
    private ArrayList<Double> sides = new ArrayList<>();

    public ArrayList<Double> getSides() {
        return sides;
    }

    public Polygon(Double... sides) {
        for (Double side : sides){
            this.sides.add(side);
        }
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    public abstract String draw();

    public abstract String toString();

    public abstract boolean equals(Object o);
}
