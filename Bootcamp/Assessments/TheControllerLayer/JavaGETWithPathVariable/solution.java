package midterm.JavaGETWithPathVariable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class BooksController {
  
    @Autowired
    private BookRepository bookRepository;
  
  @GetMapping("/books/{isbn}")
  public ResponseEntity<Book> getBookByIsbn(@PathVariable("isbn") int bookIsbn){
    Book book = bookRepository.findByIsbn(bookIsbn);
    if(book != null){
      return ResponseEntity.ok().body(book);
    } else{
      return ResponseEntity.notFound().build();
    }
  }

}