import java.util.Scanner;
import java.util.function.Predicate;

import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Predicate<Integer> filterEven = x -> x % 2 == 0;
        Predicate<Integer> filterOdd = x -> x % 2 != 0;
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();
        sc.nextLine();
        String type = sc.nextLine();


        Predicate<Integer> byType = filterEven;

        if (type.equals("odd")){
            byType = filterOdd;
        }

        IntStream
                .rangeClosed(start, end)
                .boxed()
                .filter(byType)
                .forEach(e -> System.out.print(e + " "));


    }
}
