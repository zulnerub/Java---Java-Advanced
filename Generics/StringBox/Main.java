package Generics.StringBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(rd.readLine());

        for (int i = 0; i < n; i++) {
            StringBox<String> box = new StringBox<>(rd.readLine());
            System.out.println(box.toString());
        }

    }
}
