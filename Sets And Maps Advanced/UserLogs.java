import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        String input;
        while (!"end".equalsIgnoreCase(input = sc.nextLine())){
            String user = input.substring(input.lastIndexOf("=") + 1);
            String ipAdress = input.substring(input.indexOf("=") + 1, input.indexOf(" "));

            users.putIfAbsent(user, new LinkedHashMap<>());
            if (!users.get(user).containsKey(ipAdress)){
                users.get(user).put(ipAdress, 1);
            }else{
                users.get(user).put(ipAdress, users.get(user).get(ipAdress) + 1);
            }
        }

        users.forEach((key, value) -> {
            System.out.println(key + ":");
            List<String> result = new ArrayList<>();
            value.forEach((ip, count) -> {
               result.add(String.format("%s => %d", ip, count));
            });
            System.out.print(String.join(", ", result));
            System.out.print(".");
            System.out.println();
        });
    }
}
