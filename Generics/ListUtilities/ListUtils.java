package Generics.ListUtilities;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> elements){

        if (elements == null || elements.size() == 0){
            throw new IllegalArgumentException();
        }
        return elements.stream().min(Comparable::compareTo)
                .get();
    }

    public static <T extends Comparable<T>> T getMax(List<T> elements){
        if (elements == null || elements.size() == 0){
            throw new IllegalArgumentException();
        }
        return elements.stream().max(Comparable::compareTo)
                .get();
    }
}
