import java.util.Arrays;
import java.util.Scanner;

public class reverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int row = rows - 1;
        int col = cols - 1;

        while (row >= 0){

            int r = row;
            int c = col;

            while (c < cols && r >= 0){
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();

            col--;

            if (col == -1){
                col = 0;
                row--;
            }
        }
    }
}
