import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumInStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] nums = input.split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String num: nums) {
            stack.push(num);
        }
        while(stack.size() > 0){
            System.out.print(stack.pop() + " ");
        }
    }
}
