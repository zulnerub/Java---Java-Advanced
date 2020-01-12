import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrybskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> singers = new LinkedHashMap<>();
        String input;

        while (!"end".equalsIgnoreCase(input = sc.nextLine())){
            Pattern pattern = Pattern.compile("^([a-zA-z]+\\s){1,3}[@]([a-zA-z]+\\s){1,3}(\\d+\\s)\\d+$");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                String singer = input.substring(0, input.indexOf("@") - 1);
                String[] splited = input.substring(input.indexOf("@")).split("\\s+");
                String venue = "";
                int price = Integer.parseInt(splited[splited.length - 2]);
                int qty = Integer.parseInt(splited[splited.length - 1]);

                for (int i = 0; i < splited.length - 2; i++) {
                    if (!Character.isDigit(splited[i].charAt(0))){
                        venue += splited[i] + " ";
                    }
                }
                venue = venue.substring(1);




                singers.putIfAbsent(venue, new LinkedHashMap<>());
                singers.get(venue).putIfAbsent(singer, 0);
                singers.get(venue).put(singer,
                        singers.get(venue).get(singer) + (price * qty));
            }

        }

        singers.entrySet().stream()
            .forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().entrySet().stream()
                    .sorted((singer1, singer2) -> Integer.compare(singer2.getValue(), singer1.getValue()))
                    .forEach(singer -> {
                        System.out.print(String.format(
                                "#  %s -> %d%n", singer.getKey(), singer.getValue()
                        ));
                    });
        });
    }
}
