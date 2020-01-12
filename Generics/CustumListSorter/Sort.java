package Generics.CustumListSorter;

public class Sort{

    public static <T extends Comparable<T>> void sort(CustomList<T> data){
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(i).compareTo(data.get(j)) > 0){
                    data.swap(i, j);
                }
            }

        }
    }
}
