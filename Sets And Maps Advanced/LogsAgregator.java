import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAgregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            users.putIfAbsent(input[1], new TreeMap<>());
            users.get(input[1]).putIfAbsent(input[0], 0);
            users.get(input[1])
                    .put(input[0],
                            users.get(input[1]).get(input[0]) + Integer.parseInt(input[2]));
        }
        users.forEach((user, ipAdr) -> {

            int sum = ipAdr.values().stream()
                    .mapToInt(i -> i)
                    .sum();

            System.out.print(user + ": " + sum + " ");

            System.out.println("[" + String.join(", ", ipAdr.keySet()) + "]");
        });
    }
}
