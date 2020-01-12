import java.util.ArrayDeque;
import java.util.Scanner;

public class IsPrimeHotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.valueOf(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child: children) {
            queue.offer(child);
        }
        int cycle = 1;
        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            }else{
                System.out.println("Removed " + queue.poll());
            }

            cycle++;
        }

        System.out.println("Last is " + queue.poll());

    }

    private static boolean isPrime(int cycle){
        boolean flag = true;
        if (cycle == 1){
            flag = false;
        }else{
            for (int j = 2; j <= cycle/2 ; j++) {
                if (cycle % j == 0){
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }
}
