import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[n][n];
        int value = 1;

        if (pattern.equalsIgnoreCase("a")){
            for (int cols = 0; cols < n ; cols++) {
                for (int rows = 0; rows < n; rows++) {
                    matrix[rows][cols] = value;
                    value++;
                }
            }
        }else if (pattern.equalsIgnoreCase("b")){
            for (int cols = 0; cols < n; cols++) {
                if (cols % 2 == 0){
                    for (int rows = 0; rows < n; rows++) {
                        matrix[rows][cols] = value;
                        value++;
                    }
                }else{
                    for (int rows = n - 1; rows >= 0 ; rows--) {
                        matrix[rows][cols] = value;
                        value++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }



    }
}
