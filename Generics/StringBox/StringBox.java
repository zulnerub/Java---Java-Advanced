package Generics.StringBox;

public class StringBox<T> {
    private T element;

    public StringBox(T element) {
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
