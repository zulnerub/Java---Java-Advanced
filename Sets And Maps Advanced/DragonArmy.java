import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, List<Integer>>> types = new LinkedHashMap<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            types.putIfAbsent(input[0], new TreeMap<>());
            if (!types.get(input[0]).containsKey(input[1])){
                types.get(input[0]).put(input[1], new ArrayList<>());

                if (input[2].equals("null")){
                    types.get(input[0]).get(input[1]).add(45);
                }else {
                    types.get(input[0]).get(input[1]).add(Integer.parseInt(input[2]));
                }

                if (input[3].equals("null")){
                    types.get(input[0]).get(input[1]).add(250);
                }else{
                    types.get(input[0]).get(input[1]).add(Integer.parseInt(input[3]));
                }

                if (input[4].equals("null")){
                    types.get(input[0]).get(input[1]).add(10);
                }else{
                    types.get(input[0]).get(input[1]).add(Integer.parseInt(input[4]));
                }

            }else{
                if (input[2].equals("null")){
                    types.get(input[0]).get(input[1]).remove(0);
                    types.get(input[0]).get(input[1]).add(0, 45);
                }else {
                    types.get(input[0]).get(input[1]).remove(0);
                    types.get(input[0]).get(input[1]).add(0, Integer.parseInt(input[2]));
                }

                if (input[3].equals("null")){
                    types.get(input[0]).get(input[1]).remove(1);
                    types.get(input[0]).get(input[1]).add(1, 250);
                }else{
                    types.get(input[0]).get(input[1]).remove(1);
                    types.get(input[0]).get(input[1]).add(1, Integer.parseInt(input[3]));
                }

                if (input[4].equals("null")){
                    types.get(input[0]).get(input[1]).remove(2);
                    types.get(input[0]).get(input[1]).add(2, 10);
                }else{
                    types.get(input[0]).get(input[1]).remove(2);
                    types.get(input[0]).get(input[1]).add(2, Integer.parseInt(input[4]));
                }
            }

        }

        types.entrySet().forEach((key) -> {
            List<Integer> sumHealth = new ArrayList<>();
            List<Integer> sumArmor = new ArrayList<>();
            List<Integer> sumDmg = new ArrayList<>();

            key.getValue().entrySet().forEach(list -> {
                sumDmg.add(list.getValue().get(0));
                sumHealth.add(list.getValue().get(1));
                sumArmor.add(list.getValue().get(2));
            });

            double sumHealthAv = (double) sumHealth.stream().mapToInt(i -> i).sum() / key.getValue().size();
            double sumArmorAv = (double) sumArmor.stream().mapToInt(i -> i).sum() / key.getValue().size();
            double sumDmgAv = (double) sumDmg.stream().mapToInt(i -> i).sum() / key.getValue().size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",
                    key.getKey(), sumDmgAv, sumHealthAv, sumArmorAv);

            key.getValue().entrySet().stream().forEach(e -> {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        e.getKey(), e.getValue().get(0), e.getValue().get(1), e.getValue().get(2));
            });
        });
    }
}
