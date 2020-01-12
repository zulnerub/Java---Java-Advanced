package Generics.GenericCountMethodString;

public class Box<T extends Comparable<T>>  {
    private T element;

    public Box(T element) {
        this.element = element;
    }


    public T getElement() {
        return this.element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.element.getClass().getName())
                .append(": ").append(this.element);
        return sb.toString();
    }


}
