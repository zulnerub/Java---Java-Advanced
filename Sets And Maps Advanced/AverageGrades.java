import java.util.*;

public class AverageGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, List<Double>> classBook = new TreeMap<>();
        TreeMap<String, List<Double>> avvGrade = new TreeMap<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            if (!classBook.containsKey(input[0])){
                avvGrade.put(input[0], new ArrayList<>());
                classBook.put(input[0], new ArrayList<>());
                classBook.get(input[0]).add(Double.parseDouble(input[1]));
            }else{
                classBook.get(input[0]).add(Double.parseDouble(input[1]));
            }
        }

        classBook.entrySet().forEach(e -> {
                    double sum = 0.00;
                    int i = 0;
                    for (; i < e.getValue().size(); i++) {
                        sum += e.getValue().get(i);
                    }
                    avvGrade.get(e.getKey()).add(sum / i);
                });

        classBook.entrySet()
                .forEach(e -> {
                    System.out.printf(e.getKey() + " -> ");
                    for (int i = 0; i < e.getValue().size(); i++) {
                        System.out.printf("%.2f ",e.getValue().get(i));
                    }
                    System.out.printf("(avg: %.2f)%n", avvGrade.get(e.getKey()).get(0));
                });



    }
}
