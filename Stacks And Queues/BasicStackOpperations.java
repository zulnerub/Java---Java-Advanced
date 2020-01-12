import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOpperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commands = scanner.nextLine().split("\\s+");
        int size = Integer.parseInt(commands[0]);
        int toPop = Integer.parseInt(commands[1]);
        int isPresent = Integer.parseInt(commands[2]);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] nums = scanner.nextLine().split("\\s+");

        if (size - toPop > 0){
            for (int i = 0; i < (size - toPop); i++) {
                stack.push(Integer.parseInt(nums[i]));
            }

            if (stack.contains(isPresent)){
                System.out.println("true");
            }else{
                while (stack.size() > 1){
                    int a = stack.pop();
                    int b = stack.peek();
                    if (a < b){
                        stack.pop();
                        stack.push(a);
                    }
                }
                System.out.println(stack.pop());
            }
        }else{
            System.out.println(0);
        }



    }
}
