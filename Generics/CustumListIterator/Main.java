package Generics.CustumListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String input = rd.readLine();

        CustomList<String> list = new CustomList<>();

        while (!input.equals("END")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Add":
                    list.add(tokens[1]);
                    break;

                case "Remove":
                    list.remove(Integer.parseInt(tokens[1]));
                    break;

                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;

                case "Swap":
                    list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;

                case "Greater":
                    System.out.println(list.countGreaterThan(tokens[1]));
                    break;

                case "Max":
                    System.out.println(list.getMax());
                    break;

                case "Min":
                    System.out.println(list.getMin());
                    break;

                case "Sort":
                    Sort.sort(list);
                    break;

                case "Print":
                   // list.print();

                    for (String element : list) {
                        System.out.println(element);
                    }
                    break;



            }

            input = rd.readLine();
        }

    }
}
