import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];
        for (int rows = 0; rows < n; rows++) {
            int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int cols = 0; cols < n; cols++) {
                matrix[rows] = input;
            }
        }

        int primary = 0;
        int secondary = 0;

        for (int rows = 0; rows < n; rows++) {
            primary += matrix[rows][rows];
        }
        int cols = 0;
        for (int rows = n - 1; rows >= 0; rows--) {
            secondary += matrix[rows][cols];
            cols++;
        }

        int sum = Math.abs(primary - secondary);
        System.out.println(sum);
    }
}
