package com.example.IronLibrary.tests;
import com.example.IronLibrary.model.Book;
import com.example.IronLibrary.repository.AuthorRepository;
import com.example.IronLibrary.repository.BookRepository;
import com.example.IronLibrary.repository.IssueRepository;
import com.example.IronLibrary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class BookTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    StudentRepository studentRepository;


    @Test
    public void testGetBookData() {
        Book testBook = new Book("A7", "Harry Potter", "Ficcion", 4);
        String expectedISBN = "A7";
        assertEquals(expectedISBN, testBook.getIsbn());
        String expectedTitle = "Harry Potter";
        assertEquals(expectedTitle, testBook.getTitle());
        String expectedCategory = "Ficcion";
        assertEquals(expectedTitle, testBook.getCategory());
        Integer expectedQuantity = 4;
        assertEquals(expectedTitle, testBook.getQuantity());
    }

}
