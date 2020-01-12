import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcadamyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Double[]> graduation = new TreeMap<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double[] input = Arrays
                    .stream(sc.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            Double[] grades = new Double[input.length];
            for (int j = 0; j < input.length; j++) {
                grades[j] = input[j];
            }
            graduation.put(name, grades);
        }
        graduation.entrySet().forEach(e -> {
            double avv = 0;
            int i = 0;
            for (; i < e.getValue().length; i++) {
                avv += e.getValue()[i];
            }
            avv = avv / i;

            System.out.println(String.format(
                    "%s is graduated with %s",
                    e.getKey(),
                    new DecimalFormat("#.################").format(avv)));

        });
    }
}
