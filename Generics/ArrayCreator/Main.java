package Generics.ArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = ArrayCreator.<Integer>create(10, 0);
        System.out.println(Arrays.toString(nums));
    }
}
