package FullStack_IronHack.Bootcamp.Classes.w1.d3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingPractice {
    public static void main(String[] args) throws IOException {
        // Open file to be written in
        FileWriter writer = new FileWriter("result.txt", true);

        // Open file
        File file = new File("oscar_age_female.csv");

        // Create a scanner object to iterate over the file
        Scanner scanner = new Scanner(file);

        // Skip first line
        String data = scanner.nextLine();

        // Iterate over the file
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            // Split the line to have each  column
            String[] row = data.split(",");

            // Print on the file
            writer.write("Name: " + row[3] + "\n");
            writer.write("Year: " + row[1] + "\n");
            writer.write("Age: " + row[2] + "\n");
            writer.write("Movie: " + row[4] + "\n");
            writer.write("==================" + "\n");
        }

        // Close buffers
        scanner.close();
        writer.close();
    }
}
