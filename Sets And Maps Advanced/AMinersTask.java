import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class AMinersTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> minedRes = new LinkedHashMap<>();
        String input;

        while (!"stop".equalsIgnoreCase(input = sc.nextLine())){
            int qty = Integer.parseInt(sc.nextLine());
            if (!minedRes.containsKey(input)){
                minedRes.put(input, qty);
            }else{
                minedRes.put(input, minedRes.get(input) + qty);
            }
        }
        minedRes.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " -> " + e.getValue());
        });
    }
}
