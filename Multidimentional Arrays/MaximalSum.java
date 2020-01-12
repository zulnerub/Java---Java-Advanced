import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] size = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];

        for (int rows = 0; rows < size[0]; rows++) {
            int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int cols = 0; cols < size[1]; cols++) {

                matrix[rows] = input;
            }
        }
        int sum = Integer.MIN_VALUE;
        int[][] result = new int[3][3];

        for (int i = 0; i < size[0] - 2; i++) {
            for (int j = 0; j < size[1] - 2; j++) {
                int win = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (win > sum){
                    sum = win;
                    result[0][0] = matrix[i][j];
                    result[0][1] = matrix[i][j + 1];
                    result[0][2] = matrix[i][j + 2];

                    result[1][0] = matrix[i + 1][j];
                    result[1][1] = matrix[i + 1][j + 1];
                    result[1][2] = matrix[i + 1][j + 2];

                    result[2][0] = matrix[i + 2][j];
                    result[2][1] = matrix[i + 2][j + 1];
                    result[2][2] = matrix[i + 2][j + 2];
                }
            }
        }

        System.out.println("Sum = " + sum);

        for (int rows = 0; rows < 3; rows++) {
            for (int cols = 0; cols < 3; cols++) {
                System.out.print(result[rows][cols] + " ");
            }
            System.out.println();
        }
        
    }
}
