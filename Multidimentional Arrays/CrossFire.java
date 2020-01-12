import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CrossFire {
    private static final int killed = Integer.MAX_VALUE;
    private static List<List<Integer>> matrix = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] size = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int value = 1;
        for (int i = 0; i < size[0]; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < size[1]; j++) {
                matrix.get(i).add(value++);
            }
        }

        String input;

        while (!"Nuke it from orbit".equalsIgnoreCase(input = sc.nextLine())){
            int[] command = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int row = command[0];
            int col = command[1];
            int range = command[2];

            for (int i = 0; i <= range ; i++) {
                kill(row, col + i);
                kill(row, col - i);
                kill(row + i, col);
                kill(row - i, col);
            }

            for (List<Integer> list: matrix) {
                list.removeIf(e -> e == killed);
            }

            matrix.removeIf(List::isEmpty);
        }

        for (List<Integer> list: matrix) {
            StringBuilder print = new StringBuilder();
            list.forEach(e -> print.append(e).append(" "));
            System.out.println(print);
        }
    }

    private static void kill(int row, int col) {

        if (matrix.size() > row && row >= 0){
            if (matrix.get(row).size() > col && col >= 0){
                matrix.get(row).set(col, killed);
            }
        }
    }
}
