import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Party {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> party = new TreeSet<>();

        String input;

        while (!"PARTY".equals(input = sc.nextLine())) {
            if (input.length() == 8){
                party.add(input);
            }

        }


        while (!"END".equals(input = sc.nextLine())) {
            if (party.contains(input)){
                party.remove(input);
            }
        }

        System.out.println(party.size());
        for (String s :
                party) {
            if (Character.isDigit(s.charAt(0))) {
                System.out.println(s);
            }
        }
        for (String s :
                party) {
            if (!Character.isDigit(s.charAt(0))) {
                System.out.println(s);
            }
        }

    }
}
