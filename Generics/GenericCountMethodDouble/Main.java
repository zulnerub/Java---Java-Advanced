package Generics.GenericCountMethodDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(rd.readLine());

        List<Box<Double>> boxes = new ArrayList<>();

        while (n-- > 0){

            String str = rd.readLine();

            Box<Double> box = new Box<>(Double.parseDouble(str));

            boxes.add(box);
        }

        Box<Double> element = new Box<>(Double.parseDouble(rd.readLine()));
        //String element = rd.readLine();

        int count = greaterThan(boxes, element);

        System.out.println(count);

    }

    public static <T extends Comparable<T>> int greaterThan(List<Box<T>> boxes, Box<T> element){

        int count = 0;
        for (Box<T> box : boxes) {
            if (box.compareTo(element) > 0 ){
                count++;
            }
        }

        return  count;
    }
}
