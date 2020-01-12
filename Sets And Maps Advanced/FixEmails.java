import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, String> users = new LinkedHashMap<>();
        String input;

        while (!"stop".equalsIgnoreCase(input = sc.nextLine())){
            String email = sc.nextLine();
            if (!email.substring(email.lastIndexOf('.') + 1).equalsIgnoreCase("us")
                && !email.substring(email.lastIndexOf('.') + 1).equalsIgnoreCase("uk")
                && !email.substring(email.lastIndexOf('.') + 1).equalsIgnoreCase("com")){
                    users.put(input, email);
            }
        }

        users.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
