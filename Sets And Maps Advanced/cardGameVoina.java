import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class cardGameVoina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<Integer> playerOne = new LinkedHashSet<>();
        LinkedHashSet<Integer> playerTwo = new LinkedHashSet<>();

        int[] firstRow = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] secondRow = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int a :
                firstRow) {
            if (!playerOne.contains(a)){
                playerOne.add(a);
            }
        }
        for (int b :
                secondRow) {
            if (!playerTwo.contains(b)){
                playerTwo.add(b);
            }
        }

        for (int i = 0; i < 50; i++) {
            if (playerOne.isEmpty() || playerTwo.isEmpty()) break;
            Iterator<Integer> playerOneIterator = playerOne.iterator();
            Iterator<Integer> playerTwoIterator = playerTwo.iterator();

            int playerOneValue = playerOneIterator.next();
            playerOne.remove(playerOneValue);
            int playerTwoValue = playerTwoIterator.next();
            playerTwo.remove(playerTwoValue);

            if (playerOneValue > playerTwoValue){
                playerOne.add(playerOneValue);
                playerOne.add(playerTwoValue);
            }else if (playerOneValue < playerTwoValue){
                playerTwo.add(playerOneValue);
                playerTwo.add(playerTwoValue);
            }
        }

        if (playerOne.size() > playerTwo.size()){
            System.out.println("First player win!");
        }else if (playerOne.size() < playerTwo.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw");
        }
    }
}
