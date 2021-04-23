import java.util.ArrayList;

/**
 * The type Polygon.
 */
public abstract class Polygon extends Shape {
    private ArrayList<Double> sides = new ArrayList<>();

    /**
     * Gets sides.
     *
     * @return the sides
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     * Instantiates a new Polygon.
     *
     * @param sides the sides
     */
    public Polygon(double... sides) {
        for (double side : sides){
            this.sides.add(side);
        }
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    public abstract String draw();

    public abstract String toString();

    public abstract boolean equals(Object o);
}
