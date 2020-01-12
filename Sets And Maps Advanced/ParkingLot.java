import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> parkingLot = new HashSet<>();
        String input;


        while (!"END".equals(input = sc.nextLine())){
            String[] tokens = input.split(",\\s+");

            String command = tokens[0];
            String value = tokens[1];

            switch (command){
                case "IN":
                    parkingLot.add(value);
                    break;
                case "OUT":
                    parkingLot.remove(value);
                    break;
            }
        }

        if (!parkingLot.isEmpty()){
            for (String s : parkingLot) {
                System.out.println(s);
            }

        }else{
            System.out.println("Parking Lot is Empty");
        }



    }
}
