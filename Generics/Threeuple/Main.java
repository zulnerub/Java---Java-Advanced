package Generics.Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = rd.readLine();

        String town = firstLine.substring(firstLine.lastIndexOf(" ") + 1);
        firstLine = firstLine.substring(0, firstLine.lastIndexOf(" "));
        String livingQuarter = firstLine.substring(firstLine.lastIndexOf(" ") + 1);
        String name = firstLine.substring(0, firstLine.lastIndexOf(" "));

        String secondLine = rd.readLine();
        String person = secondLine.substring(0, secondLine.indexOf(" "));
        int liters = Integer.parseInt(secondLine.substring(secondLine.indexOf(" ") + 1,
                secondLine.lastIndexOf(" ")));
        boolean checker = secondLine
                .substring(secondLine.lastIndexOf(" ") + 1)
                .equalsIgnoreCase("drunk");

        String thirdLine = rd.readLine();
        String accName = thirdLine.substring(0, thirdLine.indexOf(" "));
        double balance = Double.parseDouble(thirdLine.substring(
                thirdLine.indexOf(" ") + 1,
                thirdLine.lastIndexOf(" ")
        ));
        String bankName = thirdLine.substring(thirdLine.lastIndexOf(" ") + 1);

        Tuple<String, String, String> first = new Tuple<>(name, livingQuarter, town);
        Tuple<String, Integer, Boolean> second = new Tuple<>(person, liters, checker);
        Tuple<String, Double, String> third = new Tuple<>(accName, balance, bankName);

        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());

    }
}
