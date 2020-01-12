import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> first = new LinkedHashSet<>();
        LinkedHashSet<String> second = new LinkedHashSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String input;

        for (int i = 0; i < n; i++) {
            input = sc.nextLine();
            first.add(input);
        }
        for (int i = 0; i < m; i++) {
            input = sc.nextLine();
            second.add(input);
        }
        
        first.retainAll(second);
        
        first.forEach(e -> System.out.print(e + " "));
    }
}