import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dim = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[dim[0]][dim[1]];

        for (int row = 0; row < matrix.length; row++){
            String[] line = sc.nextLine().split("\\s+");

            for (int col = 0; col < line.length; col++){
                int value = Integer.parseInt(line[col]);

                matrix[row][col] = value;
            }
        }

        int searchNumber = Integer.parseInt(sc.nextLine());
        boolean hasNoMatch = true;
        for (int row = 0; row < matrix.length; row++) {
            int[] ints = matrix[row];
            for (int col = 0; col < ints.length; col++) {
                int value = ints[col];
                if (value == searchNumber){
                    hasNoMatch = false;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (hasNoMatch){
            System.out.println("not found");
        }
    }
}