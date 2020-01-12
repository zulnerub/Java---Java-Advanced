import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<String> users = new LinkedHashSet<>();
        int n = sc.nextInt();
        sc.nextLine();
        String input;

        for (int i = 0; i < n; i++) {
            users.add(input = sc.nextLine());
        }
        for (String user :
                users) {
            System.out.println(user);
        }
    }
}
