import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();

        String input;

        while (!"report".equalsIgnoreCase(input = sc.nextLine())){
            String[] data = input.split("\\|+");

            countries.putIfAbsent(data[1], new LinkedHashMap<>());
            countries.get(data[1]).putIfAbsent(data[0], 0L);
            countries.get(data[1]).put(data[0],
                    countries.get(data[1]).get(data[0]) + Long.parseLong(data[2]));
        }

        countries.entrySet().stream().sorted((f, s) -> {
            Long firstPopulation = countries.get(f.getKey())
                    .entrySet()
                    .stream()
                    .mapToLong(Map.Entry::getValue)
                    .sum();

            Long secondPopulation = countries.get(s.getKey())
                    .entrySet()
                    .stream()
                    .mapToLong(Map.Entry::getValue)
                    .sum();

            return secondPopulation.compareTo(firstPopulation);
        }).forEach(entry -> {

            Long totalPop = entry.getValue().values()
                    .stream()
                    .mapToLong(i -> i)
                    .sum();

            System.out.println(String.format(
                    "%s (total population: %d)",
                    entry.getKey(), totalPop));

            entry.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach( e -> {
                        System.out.println(String.format("=>%s: %d", e.getKey(), e.getValue()));
                    });
        });
    }
}
