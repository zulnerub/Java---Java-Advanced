package Generics.Swap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(rd.readLine());

        List<Box<String>> boxes = new ArrayList<>();

        while (n-- > 0){

            String str = rd.readLine();

            Box<String> box = new Box<>(str);

            boxes.add(box);
        }

        int[] index = Arrays.stream(rd.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        swapElements(boxes, index[0], index[1]);
        for (Box<String> box : boxes) {
            System.out.println(box.toString());
        }
    }

    private static <T> void swapElements(List<Box<T>> boxes,
                                     int firstIndex,
                                     int secondIndex) {
        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);

    }
}
