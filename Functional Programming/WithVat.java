import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class WithVat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] prices = sc.nextLine().split(", ");

        UnaryOperator<Double> addVat = d -> d * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(d -> System.out.printf("%.2f%n", d));
    }
}
