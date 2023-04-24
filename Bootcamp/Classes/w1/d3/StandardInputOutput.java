package FullStack_IronHack.Bootcamp.Classes.w1.d3;
// Libraries for standard input/output
import java.util.Scanner;

public class StandardInputOutput {
    // STANDARD INPUT/OUTPUT
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please introduce your name");

        String name = scanner.nextLine();
        System.out.println("Hello " + name);

        System.out.println("Now introduce your age");
        int age = scanner.nextInt();

        while (age < 0) {
            System.err.println("Your age cannot be negative");
            age = scanner.nextInt();
        }

        if(age > 18) {
            System.out.println("Welcome this app");
        } else {
            System.out.println("Access forbidden");
        }

        scanner.close();

    }
}
