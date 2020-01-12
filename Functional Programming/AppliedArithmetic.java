import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        String command = sc.nextLine().toLowerCase();

        Consumer<ArrayList<Integer>> printer = e ->
                e.forEach(num -> System.out.print(num + " "));

        Function<ArrayList<Integer>, ArrayList<Integer>> increment =
                list -> list.stream().map(e -> ++e)
                        .collect(Collectors.toCollection(ArrayList::new));

        Function<ArrayList<Integer>, ArrayList<Integer>> subtract =
                list -> list.stream().map(e -> --e)
                        .collect(Collectors.toCollection(ArrayList::new));

        UnaryOperator<ArrayList<Integer>> byTwo =
                list -> list.stream().map(e -> e * 2)
                        .collect(Collectors.toCollection(ArrayList::new));



        while (!command.equals("end")){
            if (nums.isEmpty()){
                break;
            }
            switch (command){
                case "add":
                    nums = increment.apply(nums);
                    break;
                case "multiply":
                    nums = byTwo.apply(nums);
                    break;
                case "subtract":
                    nums = subtract.apply(nums);
                    break;
                case "print":
                    printer.accept(nums);
                    System.out.println();
                    break;
            }
            command = sc.nextLine().toLowerCase();
        }
    }
}
