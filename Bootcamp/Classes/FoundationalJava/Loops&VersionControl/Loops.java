package FullStack_IronHack.Bootcamp.Classes.w1.d2;
import java.util.Arrays;

public class Loops {
    public static void main(String[] args) {
        int[] numbers = { 4, 2, 7 };
        Arrays.sort(numbers);
        String result = Arrays.toString(numbers);
        System.out.println(result);

        String[] names = {"Cristina", "Paul", "Maria", "John"};

        System.out.println("==== For ====");

        // FOR LOOP
        for (int i=0; i< names.length; i++) {
            System.out.println(names[i]);
        }

        // FOREACH LOOP
        for (String name : names) {
            System.out.println(name);
        }

        // WHILE LOOP
        int i =0;
        while(i < names.length) {
            System.out.println(names[i++]);
        }

        // DO-WHILE LOOP
        i = 0;
        do {
            System.out.println(names[i++]);
        } while(i < names.length);
    }
}
