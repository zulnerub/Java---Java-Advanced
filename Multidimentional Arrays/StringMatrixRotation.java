import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] rotation = sc.nextLine().split("[()]");
        List<String> input = new ArrayList<>();
        String entry;

        while (!"end".equalsIgnoreCase(entry = sc.nextLine())){
            input.add(entry);
        }

        int cols = 0;

        for (String word : input) {
            if (word.length() > cols){
                cols = word.length();
            }
        }

        for (int i = 0; i < input.size(); i++) {
            String word = input.get(i);
            if (word.length() < cols){
                for (int j = 0; j < (cols - word.length()); j++) {
                    String a = input.remove(i) + " ";
                    input.add(i, a);
                }
            }
        }

        int rows = input.size();
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] value = input.get(row).toCharArray();
            matrix[row] = value;
        }
        int type = Integer.parseInt(rotation[1]) / 90;
        type = type % 4;

        switch(type){
            case 1:
                char[][] result = new char[cols][rows];

                for (int col = 0; col < rows; col++) {
                    char[] rotated = matrix[rows - col - 1];
                    for (int row = 0; row < cols; row++) {
                        result[row][col] = rotated[row];
                    }
                }

                for (int i = 0; i < cols; i++) {
                    for (int j = 0; j < rows; j++) {
                        System.out.print(result[i][j]);
                    }
                    System.out.println();
                }
                break;

            case 2:
                char[][] result1 = new char[rows][cols];

                for (int row = 0; row < rows; row++) {
                    char[] reversed = matrix[rows - row - 1];
                    char[] rotated = new char[reversed.length];
                    int index = 0;
                    for (int i = reversed.length - 1; i >= 0 ; i--) {
                        rotated[index] = reversed[i];
                        index++;
                    }
                    result1[row] = rotated;
                }

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print(result1[i][j]);
                    }
                    System.out.println();
                }
                break;

            case 3:
                char[][] result2 = new char[cols][rows];

                for (int col = 0; col < rows; col++) {
                    char[] reversed = matrix[col];
                    char[] rotated = new char[reversed.length];
                    int index = 0;
                    for (int i = reversed.length - 1; i >= 0 ; i--) {
                        rotated[index] = reversed[i];
                        index++;
                    }
                    for (int row = 0; row < cols; row++) {
                        result2[row][col] = rotated[row];
                    }
                }

                for (int i = 0; i < cols; i++) {
                    for (int j = 0; j < rows; j++) {
                        System.out.print(result2[i][j]);
                    }
                    System.out.println();
                }
                break;

            case 4:
            default:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print(matrix[i][j]);
                    }
                    System.out.println();
                }
                break;

        }
    }
}
