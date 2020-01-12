import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack data = new Stack();

        int[] values = Arrays.stream(sc.nextLine().split("\\s+|,\\s+"))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .toArray();

        for (Integer num :
                values) {
            data.push(num);
        }

        String input = sc.nextLine();

        while (!input.equalsIgnoreCase("END")){

            if (input.equalsIgnoreCase("Pop")){
                try {
                    data.pop();
                }catch (IllegalAccessException e){
                    System.out.println(e.getMessage());
                }
            }else{
                data.push(Integer.parseInt(input.split("\\s+")[1]));
            }

            input = sc.nextLine();
        }

        for (Integer num :
                data) {
            System.out.println(num);
        }
        for (Integer num :
                data) {
            System.out.println(num);
        }
    }
}
