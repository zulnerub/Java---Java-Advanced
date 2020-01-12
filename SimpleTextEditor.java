import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> current = new ArrayDeque<>();
        String text = "";

        current.push(text);

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            if (Integer.parseInt(input[0]) == 1){
                text += input[1];
                current.push(text);
            }else if (Integer.parseInt(input[0]) == 2){
                if (text.length() == Integer.parseInt(input[1])){
                    text = "";
                }else{
                    text = text.substring(0, text.length() - Integer.parseInt(input[1]));
                }
                current.push(text);
            }else if (Integer.parseInt(input[0]) == 3){
                if (text.length() > 0){
                    System.out.println(text.charAt(Integer.parseInt(input[1]) - 1));
                }
            }else if (Integer.parseInt(input[0]) == 4){
                current.pop();
                text = current.peek();
            }
        }
    }
}
