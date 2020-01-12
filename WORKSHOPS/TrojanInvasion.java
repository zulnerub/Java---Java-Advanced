package WORKSHOPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(rd.readLine());

        ArrayDeque<Integer> plates = new ArrayDeque<>();
        ArrayDeque<Integer> warriors = new ArrayDeque<>();

        Arrays.stream(rd.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(plates::offer);


        for (int i = 1; i <= n; i++) {
            Arrays.stream(rd.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .forEach(warriors::push);
            if (i % 3 == 0){
                plates.offer(Integer.parseInt(rd.readLine()));
            }
            while (!warriors.isEmpty() && !plates.isEmpty()){

                    if (warriors.peek() < plates.peekFirst()){
                        plates.offerFirst(plates.poll() - warriors.pop());
                    }else if (warriors.peek() > plates.peekFirst()){
                        warriors.push(warriors.pop() - plates.poll());
                    }else if (warriors.peek() == plates.peekFirst()){
                        warriors.pop();
                        plates.poll();
                    }
            }
            if (plates.isEmpty()){
                break;
            }
        }

        if (plates.isEmpty()){
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.print("Warriors left: ");
            System.out.print(String.join(", ", Arrays.toString(warriors.toArray()).replaceAll("[\\[\\]]", "")));

        }else if (warriors.isEmpty()){
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.print("Plates left: ");
            System.out.print(String.join(", ", Arrays.toString(plates.toArray()).replaceAll("[\\[\\]]", "")));

        }
    }
}