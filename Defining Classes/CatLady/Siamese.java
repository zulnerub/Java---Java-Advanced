public class Siamese extends Cat{
    private String name;
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name, earSize);
    }

    @Override
    public String toString() {
        return "Siamese " + super.toString();
    }
}
