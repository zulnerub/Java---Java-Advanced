package Generics.JarOfT;
public class Jar<T> {

    private T element;

    public void add(T element){
        this.element = element;
    }

    public T remove() {
        return this.element;
    }


}
