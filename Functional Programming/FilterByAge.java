import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.function.BiPredicate;
import java.util.function.Consumer;


public class FilterByAge {
    private static int age;
    public static void main(String[] args) {


        BiPredicate<Map.Entry<String, Integer>, Integer> youngerThan =
                (person, ageLimit) -> person.getValue() < age;

        BiPredicate<Map.Entry<String, Integer>, Integer> olderThan =
                (person, ageLimit) -> person.getValue() >= age;


        Consumer<Map.Entry<String, Integer>> printName =
                person -> System.out.println(person.getKey());

        Consumer<Map.Entry<String, Integer>> printAge =
                person -> System.out.println(person.getValue());

        Consumer<Map.Entry<String, Integer>> printNameAndAge =
                person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());

        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(", ");

            people.put(input[0], Integer.parseInt(input[1]));
        }

        String comparison = sc.nextLine();
        age = Integer.parseInt(sc.nextLine());
        String[] toPrint = sc.nextLine().split("\\s+");

        people.entrySet().stream()
                .filter(person ->  comparison.equals("younger") ?
                            youngerThan.test(person, age) :
                            olderThan.test(person, age)
                ).forEach(person -> {
                 if (toPrint.length < 2){
                     if (toPrint[0].equals("age")){
                         printAge.accept(person);
                     }else if (toPrint[0].equals("name")){
                         printName.accept(person);
                     }
                 }else{
                     printNameAndAge.accept(person);
                 }
                });
    }
}
