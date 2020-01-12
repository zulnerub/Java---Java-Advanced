package Generics.GenericSwap;


public class Box<T> {
    private T element;

    public Box(T element) {
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
