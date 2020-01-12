import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        String input;

        while (!"joker".equalsIgnoreCase(input = sc.nextLine())) {
            String name = input.substring(0, input.indexOf(":"));

            ArrayList<String> hand = Arrays.stream(
                    input.substring(input.indexOf(":") + 2).split(", "))
                    .collect(Collectors.toCollection(ArrayList::new));

                if (players.containsKey(name)) {
                    players.get(name).addAll(hand);
                } else {
                    players.put(name, new HashSet<>(){{
                        addAll(hand);
                    }});
                }

        }

        players.forEach((key, value) -> {
            result.put(key, 0);

            value.forEach(e -> {
                switch (e.charAt(e.length() - 1)) {
                    case 'S':
                        result.put(key, result.get(key) + (getA(e) * 4));
                        break;
                    case 'H':
                        result.put(key, result.get(key) + (getA(e) * 3));
                        break;
                    case 'D':
                        result.put(key, result.get(key) + (getA(e) * 2));
                        break;
                    case 'C':
                        result.put(key, result.get(key) + getA(e));
                        break;
                }

            });
        });


        result.forEach((key, value) -> System.out.println(String.format("%s: %d",key, value )));


    }

    private static int getA(String e) {
        int a = 0;
        if (Character.isDigit(e.charAt(0)) && e.charAt(0) != '1') {
            a += e.charAt(0) - '0';
        } else {
            switch (e.charAt(0)) {
                case '1':
                    a += 10;
                    break;
                case 'J':
                    a += 11;
                    break;
                case 'Q':
                    a += 12;
                    break;
                case 'K':
                    a += 13;
                    break;
                case 'A':
                    a += 14;
                    break;
            }

        }

        return a;
    }

}
