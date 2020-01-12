import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustumMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> getMin = e -> Arrays.stream(nums).min().getAsInt();

        System.out.println(getMin.apply(nums));
    }
}
