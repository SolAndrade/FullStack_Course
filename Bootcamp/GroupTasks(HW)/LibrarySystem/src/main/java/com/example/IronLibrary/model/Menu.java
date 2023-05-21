package com.example.IronLibrary.model;

import com.example.IronLibrary.classes.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {
    @Autowired
    Library library;


    static Scanner scanner = new Scanner(System.in);
    public void optionInput(){
        boolean flagCommand = false;
        System.out.println("Enter an option\n" +
                            "Option 1: Add a new Book\n"+
                            "Option 2: Search a book by title\n"+
                            "Option 3: Search a book by category\n"+
                            "Option 4: Search a book by author\n"+
                            "Option 5: See a list of all books with their author\n"+
                            "Option 6: Issue a book\n"+
                            "Option 7: Check an issued book\n"+
                            "Option 8: See menu or EXIT");
        while (!flagCommand) {
            Integer option = scanner.nextInt();
            switch (option) {
                case 1:
                    library.addABook();
                    break;
                case 2:
                    library.searchBookByTitle();
                    break;
                case 3:
                    library.searchBookByCategory();
                    break;
                case 4:
                    library.searchBookByAuthor();
                    break;
                case 5:
                    library.listAllBooksWithAuthor();
                    break;
                case 6:
                    library.issueBookToStudent();
                    break;
                case 7:
                    library.listBooksByUsn();
                    break;
                case 8:
                    flagCommand = true;
                    break;
            }
            scanner.nextLine(); // consume leftover newline character
            System.out.println("Do you want to continue? (Y/N)");
            String continueOption = scanner.nextLine();
            if (continueOption.equalsIgnoreCase("y")) {
                optionInput();
            } else {
                System.out.println("Goodbye!");
            }

        }

    }
}