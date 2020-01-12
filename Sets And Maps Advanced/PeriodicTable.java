import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> elements = new TreeSet<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            Collections.addAll(stack, input);
            for (int j = 0; j < stack.size(); j++) {
                elements.add(stack.pop());
            }
        }


        for (String el :
                elements) {
            System.out.print(el + " ");
        }


    }
}
