import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String data = rd.readLine();

        HashMap<String, Cat> cats = new HashMap<>();


        while (!data.equals("End")){
            String[] tokens = data.split("\\s+");

            String breed = tokens[0];
            String name = tokens[1];
            double specialSkil = Double.parseDouble(tokens[2]);
            Cat cat = null;

            switch (breed){
                case "Siamese":
                    cat = new Siamese(name, specialSkil);
                    break;
                case "Cymric":
                    cat = new Cymric(name, specialSkil);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, specialSkil);
                    break;

            }



            cats.putIfAbsent(name, cat);


            data = rd.readLine();
        }

        String catName = rd.readLine();

        Cat cat = cats.get(catName);
        System.out.println(cat.toString());
    }
}
