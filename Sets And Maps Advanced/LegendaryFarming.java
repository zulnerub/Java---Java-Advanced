import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Integer> primary = new LinkedHashMap<>();
        primary.put("shards", 0);
        primary.put("motes", 0);
        primary.put("fragments", 0);

        LinkedHashMap<String, Integer> junk = new LinkedHashMap<>();

        String winner = "";

        while (winner.equalsIgnoreCase("")){
            String[] loot = sc.nextLine().toLowerCase().split("\\s+");

            for (int i = 1; i < loot.length; i += 2) {
                switch (loot[i]){
                    case "shards":
                        primary.put("shards",
                                primary.get("shards") + Integer.parseInt(loot[i - 1]));
                        break;
                    case "fragments":
                        primary.put("fragments",
                                primary.get("fragments") + Integer.parseInt(loot[i - 1]));
                        break;
                    case "motes":
                        primary.put("motes",
                                primary.get("motes") + Integer.parseInt(loot[i - 1]));
                        break;
                    default:
                        junk.putIfAbsent(loot[i], 0);
                        junk.put(loot[i], junk.get(loot[i]) + Integer.parseInt(loot[i - 1]));
                        break;
                }
                if (winner.equals("")) {
                    if (primary.containsKey("shards") && primary.get("shards") >= 250) {
                        winner = "Shadowmourne";
                        primary.put(loot[i], primary.get("shards") - 250);
                        i = loot.length;
                    }else if(primary.containsKey("fragments") && primary.get("fragments") >= 250) {
                        winner = "Valanyr";
                        primary.put(loot[i], primary.get("fragments") - 250);
                        i = loot.length;
                    }else if (primary.containsKey("motes") && primary.get("motes") >= 250) {
                        winner = "Dragonwrath";
                        primary.put(loot[i], primary.get("motes") - 250);
                        i = loot.length;
                    }
                }
            }
        }

        System.out.printf("%s obtained!%n", winner);
        String patern = "%s: %d%n";

        primary.entrySet().stream().sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue(), e1.getValue());
            if (sort == 0){
                sort = e1.getKey().compareTo(e2.getKey());
            }
            return sort;
        }).forEach(e -> {
            System.out.printf(patern, e.getKey(), e.getValue());
        });

        junk.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach( e -> {
                    System.out.printf(patern, e.getKey(), e.getValue());
                });

    }
}
