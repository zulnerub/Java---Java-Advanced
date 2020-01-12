import java.util.Arrays;
import java.util.Scanner;

public class SumNumbers {
    private static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");
        System.out.println("Count = " + input.length);

        Arrays.stream(input)
                .map(Integer::parseInt)
                .forEach(e -> {
                    sum += e;
                });
        System.out.println("Sum = " + sum);
    }
}
