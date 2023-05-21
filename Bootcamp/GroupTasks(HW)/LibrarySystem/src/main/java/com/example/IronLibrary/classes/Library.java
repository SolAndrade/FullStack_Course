package com.example.IronLibrary.classes;

import com.example.IronLibrary.model.Author;
import com.example.IronLibrary.model.Book;
import com.example.IronLibrary.model.Issue;
import com.example.IronLibrary.model.Student;
import com.example.IronLibrary.repository.AuthorRepository;
import com.example.IronLibrary.repository.BookRepository;
import com.example.IronLibrary.repository.IssueRepository;
import com.example.IronLibrary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class Library {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    StudentRepository studentRepository;

    static Scanner scanner = new Scanner(System.in);

    public Library() {
    }

    public void addABook() {
        System.out.println("Insert ISBN");
        String isbn = scanner.nextLine();
        System.out.println("Insert title");
        String title = scanner.nextLine();
        System.out.println("Insert category");
        String category = scanner.nextLine();
        System.out.println("Insert quantity");
        Integer quantity = scanner.nextInt();
        scanner.nextLine();

        Book newBook = new Book(isbn, title, category, quantity);

        System.out.println("Insert author name");
        String authorName = scanner.nextLine();
        System.out.println("Insert author mail");
        String authorMail = validateEmail();

        Author newAuthor = new Author(authorName, authorMail, newBook);

        Optional<Author> myAuthorOptional = authorRepository.findByAuthorName(authorName);
        if(myAuthorOptional.isPresent()){
            newAuthor = myAuthorOptional.get();
            if(newAuthor.getAuthorBook().getTitle().equals(title)){
                newAuthor.getAuthorBook().setQuantity(newAuthor.getAuthorBook().getQuantity() + 1);
                System.out.println("Book added to the library!");
            }else{
                System.out.println("Error: this Author already has a book!");
            }
        }else{

            bookRepository.save(newBook);
            authorRepository.save(newAuthor);

            System.out.println("The following book has been created:");
            System.out.println("Book:" + newBook.getTitle());
            System.out.println("ISBN: " +  newBook.getIsbn());
            System.out.println("Category: " + newBook.getCategory());
            System.out.println("Quantity: " + newBook.getQuantity());
            System.out.println("Author: " + newAuthor.getName() + "; ID: " +  newAuthor.getAuthorId() + "; Email: " + newAuthor.getEmail());
        }

    }


    public void searchBookByTitle(){
        System.out.println("Please write the title");
        String title = scanner.nextLine();

        Optional<Book> findedBook = bookRepository.findByTitle(title);
        if(findedBook.isPresent()) {
            Book myBook = findedBook.get();
            System.out.println(myBook);
        }else{
            System.out.println("No book with this title");
        }
    }

    public void searchBookByCategory(){
        System.out.println("Please write the category");
        String category = scanner.nextLine();

        Optional<Book> findedBook = bookRepository.findByCategory(category);
        if(findedBook.isPresent()) {
            Book myBook = findedBook.get();
            System.out.println(myBook);
        }else{
            System.out.println("No book in this category");
        }
    }

    public void searchBookByAuthor(){
        System.out.println("Please write the Author to find the book");
        String authorName = scanner.nextLine();

        Optional<Author> authorOptional = authorRepository.findByAuthorName(authorName);
        if(authorOptional.isPresent()) {
            Author myAuthor = authorOptional.get();
            System.out.println(myAuthor.getAuthorBook());
        }else{
            System.out.println("No book in this category");
        }
    }

    public void listAllBooksWithAuthor(){
        List<Author> founded = authorRepository.findAll();
        System.out.println(founded);
    }

    public void issueBookToStudent(){
        System.out.println("Insert student USN");
        String usn = scanner.nextLine();

        Student newStudent = null;
        Optional<Student> myStudent = studentRepository.findByUsn(usn);

        if (myStudent.isPresent()){
            newStudent = myStudent.get();
            System.out.println("Hi " + myStudent.get().getStudentName());
        }else {
            System.out.println("Insert student name");
            String studentName = scanner.nextLine();
            newStudent = new Student(usn, studentName);
            studentRepository.save(newStudent);
        }

        System.out.println("Insert Book isbn");
        String isbn = scanner.nextLine();

        Date issueDate = new Date();
        // Calculate the return date
        Calendar returnDate = Calendar.getInstance();
        returnDate.setTime(issueDate);
        returnDate.add(Calendar.DATE, 7);

        Book newBook;
        Optional<Book> myBook = bookRepository.findByIsbn(isbn);

        if(myBook.isPresent()){
            newBook = myBook.get();
            System.out.println(newBook);
            if(newBook.getQuantity() > 0){
                Issue newIssue = new Issue(issueDate, returnDate.getTime(), newStudent, newBook);

                newBook.setQuantity(newBook.getQuantity() - 1);

                bookRepository.save(newBook);
                issueRepository.save(newIssue);

                System.out.println("Book issued. Return date : " + returnDate.getTime());

            }else{
                System.out.println("No quedan más libros");
            }
        }else {
            System.out.println("this book not exists");
        }

    }


    public void listBooksByUsn(){

        System.out.println("Enter student USN:");
        String usn = scanner.nextLine();

        Optional<Student> studentOptional = studentRepository.findByUsn(usn);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            List<Issue> issues = issueRepository.findByIssueStudent(Optional.of(student));
            if (!issues.isEmpty()) {
                System.out.println("Books issued to " + student.getStudentName() + ":");
                for (Issue issue : issues) {
                    System.out.println(issue.getIssueBook().toString());
                }
            } else {
                System.out.println("No books issued to " + student.getStudentName());
            }
        } else {
            System.out.println("Student with USN " + usn + " not found");
        }
    }


    //Helpers
    public String validateEmail() {
        String email = null;
        while (email == null || email.isEmpty() || !isValidEmail(email)) {
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Enter a valid email address.");
            }
        }
        return email;
    }

    private boolean isValidEmail(String email) {
        // Regular expression pattern to validate email addresses
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(pattern);
    }
    }



