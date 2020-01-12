import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> biggest = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String[] com = sc.nextLine().split("\\s+");
            switch (Integer.parseInt(com[0])){
                case 1:
                    stack.push(Integer.parseInt(com[1]));
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    for (Integer e:
                         stack) {
                        biggest.push(e);
                    }
                    while(biggest.size() > 1){
                        int a = biggest.pop();
                        int b = biggest.peek();
                        if (a > b){
                            biggest.pop();
                            biggest.push(a);
                        }
                    }
                    System.out.println(biggest.pop());
                    break;
            }
        }
    }
}
