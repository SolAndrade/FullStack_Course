package midterm.JavaSpringPOST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;
import javax.validation.Valid;


@RestController
public class BooksController {
  
    @Autowired
    private BookRepository bookRepository;
  
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
      Book savesBook = bookRepository.save(book);
      return ResponseEntity.status(HttpStatus.CREATED).body(savesBook);
    }
  

}