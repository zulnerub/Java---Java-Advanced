import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = "";

        while(!"print".equalsIgnoreCase(input = scanner.nextLine())){
            if (!"cancel".equalsIgnoreCase(input)){
                queue.offer(input);
            }else{
                if(!queue.isEmpty()){
                    System.out.println("Canceled " + queue.poll());
                }else{
                    System.out.println("Printer is on standby");
                }
            }
        }
        if (!queue.isEmpty()){
            System.out.println(String.join(System.lineSeparator(), queue));
        }
    }
}
