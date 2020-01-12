import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(System.in)
        );

        List<String> list = Arrays.stream(rd.readLine().split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());

        ListyIterator iterator = new ListyIterator(list);

        String line = rd.readLine();

        while (!line.equalsIgnoreCase("END")){
            switch (line){
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(iterator.print());
                    }catch (IllegalAccessException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "PrintAll":
                    iterator.printAll();
                    break;
            }

            line = rd.readLine();
        }


    }
}
