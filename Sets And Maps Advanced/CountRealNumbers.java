import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> counted = new LinkedHashMap<>();

        for (double a :
                input) {
            if (!counted.containsKey(a)){
                counted.put(a, 1);
            }else{
                counted.put(a, counted.get(a) + 1);
            }
        }

        for (Double key :
                counted.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, counted.get(key)));
        }
    }
}
