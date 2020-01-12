import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] size = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[size[0]][size[1]];
        for (int rows = 0; rows < size[0]; rows++) {
            String[] row = sc.nextLine().split("\\s+");
            for (int cols = 0; cols < size[1]; cols++) {
                matrix[rows] = row;
            }
        }
        String[] command = sc.nextLine().split("\\s+");

        while (!command[0].equalsIgnoreCase("end")){
            if (command[0].equalsIgnoreCase("swap") && command.length == 5){
                try {
                    String a = matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])];
                    matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])] = matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])];
                    matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])] = a;
                    for (int rows = 0; rows < size[0]; rows++) {
                        for (int cols = 0; cols < size[1]; cols++) {
                            System.out.print(matrix[rows][cols] + " ");
                        }
                        System.out.println();
                    }
                }catch(ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input!");
                }
            }else{
                System.out.println("Invalid input!");
            }
            command = sc.nextLine().split("\\s+");
        }
    }
}
