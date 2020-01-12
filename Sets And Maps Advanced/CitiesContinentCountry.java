import java.util.*;

public class CitiesContinentCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> world = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            if (!world.containsKey(input[0])){
                world.put(input[0], new LinkedHashMap<>());
                world.get(input[0]).put(input[1], new ArrayList<>());
                world.get(input[0]).get(input[1]).add(input[2]);
            }else{
                if (!world.get(input[0]).containsKey(input[1])){
                    world.get(input[0]).put(input[1], new ArrayList<>());
                    world.get(input[0]).get(input[1]).add(input[2]);
                }else{
                    world.get(input[0]).get(input[1]).add(input[2]);
                }
            }
        }

        world.entrySet().forEach(continent -> {
            System.out.println(continent.getKey() + ":");
            world.get(continent.getKey()).entrySet().forEach( country -> {
                System.out.print(country.getKey() + " -> ");
                System.out.print(country.getValue().toString().replaceAll("[\\[\\]]", ""));


                System.out.println();
            });
        });
    }


}
