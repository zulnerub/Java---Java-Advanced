import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOpps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] comms = scanner.nextLine().split("\\s+");
        int size = Integer.parseInt(comms[0]);
        int toPop = Integer.parseInt(comms[1]);
        int isPresent = Integer.parseInt(comms[2]);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] nums = scanner.nextLine().split("\\s+");

        if (size - toPop > 0){
            for (int i = 0; i < size; i++) {
                queue.add(Integer.parseInt(nums[i]));
            }
            for (int i = 0; i < toPop; i++) {
                queue.poll();
            }

            if (queue.contains(isPresent)){
                System.out.println("true");
            }else{
                while(queue.size() > 1) {
                    int a = queue.poll();
                    int b = queue.poll();
                    if (b < a){
                        queue.add(b);
                    }else{
                        queue.add(a);
                    }
                }
                System.out.println(queue.pop());
            }
        }else{
            System.out.println(0);
        }
    }
}
