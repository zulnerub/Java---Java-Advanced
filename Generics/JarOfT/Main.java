package Generics.JarOfT;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();

        jar.add("Pesho");
        System.out.println(jar.remove());

        Jar<Integer> jar1 = new Jar<>();
        jar1.add(2);
        System.out.println(jar1.remove());

    }
}
