import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        TreeMap<Character, Integer> order = new TreeMap<>();

        for (int i = 0; i < text.length(); i++){
            char a = text.charAt(i);
            if (!order.containsKey(a)){
                order.put(a, 1);
            }else{
                order.put(a, order.get(a) + 1);
            }
        }
        if (text.length() > 0){
            order.entrySet().forEach(e -> {
                System.out.println(String.format("%s: %d time/s", e.getKey(), e.getValue()));
            });
        }


    }
}
