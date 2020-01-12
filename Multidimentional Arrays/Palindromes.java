import java.util.Scanner;

public class Palindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        String[][] matrix = new String[row][col];

        for (int rows = 0; rows < row; rows++) {
            for (int cols = 0; cols < col; cols++) {
                char mid = (char) ('a' + cols + rows);
                char firstLast = (char) ('a' + rows);
                String value = "" + firstLast + mid + firstLast;
                matrix[rows][cols] = value;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
