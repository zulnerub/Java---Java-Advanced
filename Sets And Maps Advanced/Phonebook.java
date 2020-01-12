import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        String input;

        while (!"search".equalsIgnoreCase(input = sc.nextLine())){
            String[] entry = input.split("-");
            phonebook.put(entry[0], entry[1]);
        }
        while (!"stop".equalsIgnoreCase(input = sc.nextLine())){
            if (phonebook.containsKey(input)){
                System.out.println(input + " -> " + phonebook.get(input));
            }else{
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}
