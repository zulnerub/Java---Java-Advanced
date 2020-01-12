import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );
        int n = Integer.parseInt(rd.readLine());
        List<Person> persons = new ArrayList<>();

        while (n-- > 0){
            String[] input = rd.readLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            persons.add(person);
        }

        persons.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(e ->
                        System.out.printf("%s - %d%n", e.getName(), e.getAge()));


    }
}
