import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");

        Predicate<String> isStartingWithCapital = word ->
                Character.isUpperCase(word.charAt(0));


        List<String> capitalWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isStartingWithCapital.test(words[i])){
                capitalWords.add(words[i]);
            }
        }

        System.out.println(capitalWords.size());
        capitalWords.forEach(System.out::println);
    }
}
