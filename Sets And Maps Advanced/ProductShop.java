import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        String input;

        while (!"revision".equalsIgnoreCase(input = sc.nextLine())){
            String[] shop = input.split(",\\s+");
            if (!shops.containsKey(shop[0])){
                shops.put(shop[0], new LinkedHashMap<>());
                shops.get(shop[0]).put(shop[1], Double.parseDouble(shop[2]));

            }else{
                    shops.get(shop[0]).put(shop[1], Double.parseDouble(shop[2]));
            }
        }

        shops.entrySet().forEach(e -> {
            System.out.println(e.getKey() + "->");
                 shops.get(e.getKey()).entrySet().forEach( f -> {
                     System.out.printf("Product: %s, Price: %.1f%n", f.getKey(), f.getValue());
                 });
        });
    }

}
