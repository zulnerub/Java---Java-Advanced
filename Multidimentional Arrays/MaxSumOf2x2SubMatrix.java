import java.util.Scanner;

public class MaxSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = Integer.MIN_VALUE;
        String[] size = sc.nextLine().split(", ");

        int[][] matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
        int[][] result = new int[2][2];

        for (int rows = 0; rows < Integer.parseInt(size[0]); rows++) {
            String[] row = sc.nextLine().split(", ");
            for (int cols = 0; cols < Integer.parseInt(size[1]); cols++) {
                matrix[rows][cols] = Integer.parseInt(row[cols]);
            }
        }

        for (int i = 0; i < Integer.parseInt(size[0]) - 1; i++) {
            for (int j = 0; j < Integer.parseInt(size[1]) - 1; j++) {
                int win = matrix[i][j]
                        + matrix[i][j+1]
                        + matrix[i + 1][j]
                        + matrix[i + 1][j + 1];
                if (win > sum){
                    sum = win;
                    result[0][0] = matrix[i][j];
                    result[0][1] = matrix[i][j + 1];
                    result[1][0] = matrix[i + 1][j];
                    result[1][1] = matrix[i + 1][j + 1];
                }
            }
        }





        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(sum);
    }
}
