import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd =
                new BufferedReader(
                        new InputStreamReader(
                                System.in)
                );

        int count = Integer.parseInt(rd.readLine());
        List<Car> cars = new ArrayList<>();
        while (count-- > 0){
            String line = rd.readLine();
            String[] tokens = line.split("\\s+");
            String make = tokens[0];
            if (tokens.length > 1){
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);

                Car car = new Car(make, model, horsePower);
                cars.add(car);
            }else{
                Car car = new Car(make);
                cars.add(car);
            }
        }
        cars.forEach(c -> System.out.println(c.carInfo()));
    }
}
