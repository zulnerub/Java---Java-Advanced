package Generics.IntegerBox;
public class IntegerBox<T> {
    private T element;

    public IntegerBox(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.element.getClass().getName())
                .append(": ").append(this.element);
        return sb.toString();
    }
}
