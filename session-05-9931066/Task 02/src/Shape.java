/**
 * The type Shape.
 */
public abstract class Shape {
    /**
     * Calculate perimeter double.
     *
     * @return the double
     */
    public abstract double calculatePerimeter();

    /**
     * Calculate area double.
     *
     * @return the double
     */
    public abstract double calculateArea();

    /**
     * Draw string.
     *
     * @return the string
     */
    public abstract String draw();

    public abstract String toString();

    public abstract boolean equals(Object o);
}
