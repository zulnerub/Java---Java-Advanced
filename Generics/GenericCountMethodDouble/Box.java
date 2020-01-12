package Generics.GenericCountMethodDouble;

public class Box<T extends Comparable<T>> implements Comparable <Box<T>> {
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


    @Override
    public int compareTo(Box<T> other) {
        return this.element.compareTo(other.element);
    }
}
