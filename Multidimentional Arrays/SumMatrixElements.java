import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[input[0]][input[1]];
        int sum = 0;
        for (int i = 0; i < input[0]; i++) {
            int line[] = Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int cols = 0; cols < line.length; cols++){
                matrix[i][cols] = line[cols];
                sum += matrix[i][cols];
            }
        }
        System.out.println(input[0]);
        System.out.println(input[1]);
        System.out.println(sum);
    }
}
