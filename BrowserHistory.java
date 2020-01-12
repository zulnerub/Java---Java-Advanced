import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String input = "";

        while (!"Home".equalsIgnoreCase(input = scanner.nextLine())){
            if (!"back".equalsIgnoreCase(input) && !"forward".equalsIgnoreCase(input)){
                stack.push(input);
                System.out.println(input);
                forward.clear();
            }else if ("back".equalsIgnoreCase(input)){
                if (stack.size() > 1){
                    forward.addFirst(stack.pop());
                    System.out.println(stack.peek());
                }else {
                    System.out.println("no previous URLs");
                }
            }else if ("forward".equalsIgnoreCase(input)){
                if (forward.size() > 0){
                    stack.push(forward.peek());
                    System.out.println(forward.poll());
                }else{
                    System.out.println("no next URLs");
                }
            }
        }
    }

}
