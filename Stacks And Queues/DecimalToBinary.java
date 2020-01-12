import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int input = Integer.parseInt(scanner.nextLine());

        if (input == 0){
            System.out.print(input);
        }else{
            while (input != 0){
                stack.push(input % 2);
                input = input / 2;
            }
            while(stack.size() > 0) {
                System.out.print(stack.pop());
            }
        }
    }
}
