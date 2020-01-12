package Generics.ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1425);
        list.add(12121);
        list.add(12123322);
        list.add(112);
        list.add(-1);




        System.out.println(ListUtils.getMin(list));
        System.out.println(ListUtils.getMax(list));


    }
}
