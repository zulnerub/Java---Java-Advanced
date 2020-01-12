package Generics.CustumListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element){
        this.data.add(element);
    }

    public T remove(int index){
        return this.data.remove(index);
    }

    public boolean contains(T element){
        return this.data.contains(element);
    }

    public void swap(int indexOne, int indexTwo){
        Collections.swap(this.data, indexOne, indexTwo);
    }

    public int countGreaterThan(T element){

        return (int) this.data.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T getMax(){
        return Collections.max(this.data);
    }

    public T getMin(){
        return Collections.min(this.data);
    }

    public int size(){
        return this.data.size();
    }

    public void print() {
        this.data.forEach(System.out::println);
    }

    public T get(int index){
        return this.data.get(index);
    }
}
