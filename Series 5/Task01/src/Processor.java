public interface Processor {
    private String modelName = null;
    private int numberOfCores = 0;

    public void add();
    public void subtract();
    public void multiply();
    public void divide();

}
