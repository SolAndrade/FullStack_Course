package midterm.JavaSpringGETWithParams;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Collections;


@RestController
public class BooksController {
  
    @Autowired
    private BookRepository bookRepository;
  
  @GetMapping("/books")
  public ResponseEntity<List<Book>> getBooks(@RequestParam(value="title", required = false) String optionalTitle, @RequestParam(value = "author", required=false) String optionalAuthor) {
    List<Book> books;
    
    if (optionalTitle != null && optionalAuthor != null) {
      Book book = bookRepository.findByTitleAndAuthor(optionalTitle, optionalAuthor);
      if(book != null) {
        books = Collections.singletonList(book);
      } else {
        books = Collections.emptyList();
      }
    } else if (optionalTitle != null) {
      books = bookRepository.findByTitleContaining(optionalTitle);
    } else if (optionalAuthor != null) {
      books = bookRepository.findByAuthor(optionalAuthor);
    } else {
      books = bookRepository.findAll();
    }
    if (!books.isEmpty()) {
      return ResponseEntity.ok().body(books);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  

}