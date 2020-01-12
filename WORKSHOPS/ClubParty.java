package WORKSHOPS;

import java.util.*;
import java.util.stream.Collectors;

public class ClubParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> halls = new ArrayDeque<>();
        List<Integer> people = new ArrayList<>();

        for (int i = input.length - 1; i >= 0; i--) {
            String current = input[i];

            if (Character.isDigit(current.charAt(0))) {
                if (halls.isEmpty()) { continue; }

                int currentPeople = Integer.parseInt(current);

                if (currentPeople > capacity) { continue; }

                int sum = people.stream().mapToInt(x -> x).sum();
                if (sum + currentPeople <= capacity) {
                    people.add(currentPeople);
                } else {
                    printHall(halls.poll(), people);
                    people.clear();
                    i++;
                }
            } else {
                halls.offer(current);
            }
        }
    }

    private static void printHall(String poll, List<Integer> people) {
        System.out.print(poll);
        System.out.print(" -> ");
        System.out.println(String.join(", ",people
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList())));
    }
}
