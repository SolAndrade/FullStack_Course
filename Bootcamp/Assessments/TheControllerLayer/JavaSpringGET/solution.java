package midterm.JavaSpringGET;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
public class BooksController {
  
    @Autowired
    private BookRepository bookRepository;
  
  @GetMapping("/books")
  public ResponseEntity<List<Book>>getAllBooks(){
    List<Book> books = bookRepository.findAll();
    return ResponseEntity.ok().body(books);
  }

}