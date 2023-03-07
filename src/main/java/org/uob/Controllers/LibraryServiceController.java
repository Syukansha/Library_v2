package org.uob.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uob.Models.*;
import org.uob.Repositories.BookLoanRepositories;
import org.uob.Repositories.BookRepositories;
import org.uob.Repositories.UsersRepositories;
import org.uob.Services.LibraryServices;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/services")
public class LibraryServiceController {

    @Autowired
    UsersRepositories usersRepositories;

    @Autowired
    LibraryServices libraryServices;

    @Autowired
    BookRepositories bookRepositories;

    @Autowired
    BookLoanRepositories bookLoanRepositories;

//    Book
    @PostMapping("/add/loan/book_ID/{bookID}/student_ID/{id}")
    public ResponseEntity<BookLoan> createLoan(@RequestBody BookLoan bookLoan, @PathVariable int bookID, @PathVariable int id){
        try {
            return ResponseEntity.ok().body(libraryServices.reserveBook(bookLoan,bookID,id));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/bookLoan/bookLoan_id/{id}")
    public ResponseEntity<BookLoan> searchBookLoan(@PathVariable int id){
        try {
            return ResponseEntity.ok().body(libraryServices.searchBookLoan(id));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/search/book/book_title/{title}")
    public ResponseEntity<List<Books>> searchBookByTitle(@PathVariable String title){
        try {
            return ResponseEntity.ok().body(bookRepositories.findByTitleContaining(title));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add/book")
    public ResponseEntity<Books>  addBook(@RequestBody Books books){
        try {
            return ResponseEntity.ok().body(libraryServices.addBook(books));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/book/book_id/{bookID}")
    public ResponseEntity<Books> searchBookById(@PathVariable int id){
        try {
            return ResponseEntity.ok().body(libraryServices.searchBook(id));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/book/book_id/{id}")
    public void deleteBook(@PathVariable int id){libraryServices.deleteBook(id);}

    @DeleteMapping("/delete/bookLoan/student_id/{id}/book_id/{bookID}")
    public void deleteBookLoan(@PathVariable int id, @PathVariable int bookID){libraryServices.deleteBookLoan(id);}

    @PatchMapping("/update/book/book_id/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable int id, @RequestBody Books books){
        try {
            return ResponseEntity.ok().body(libraryServices.updateBook(id,books));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    Student
    @PostMapping("/add/student")
    public ResponseEntity<Users> addStudent(@RequestBody Student student){
        try {
            return ResponseEntity.ok().body(libraryServices.addStudent(student));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/student/student_id/{id}")
    public ResponseEntity<Users> searchStudentById(@PathVariable int id){
        try {
            return ResponseEntity.ok().body(libraryServices.searchStudent(id));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update/student/student_id/{id}")
    public ResponseEntity<Users> updateStudent(@PathVariable int id, @RequestBody Student student){
        try {
            return ResponseEntity.ok().body(libraryServices.updateStudent(id,student));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/student/student_id/{id}")
    public void deleteStudent(@PathVariable int id){
        libraryServices.deleteStudent(id);
    }

    @GetMapping("/search/name/student_name/{username}")
    public ResponseEntity<List<Student>> searchStudentByName(@PathVariable String username){
        try {
            return ResponseEntity.ok().body(usersRepositories.findByUsernameContaining(username));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    Librarian
    @PostMapping("/add/librarian")
    public ResponseEntity<Users> addLibrarian(@RequestBody Librarian librarian){
        try {
            return ResponseEntity.ok().body(libraryServices.addLibrarian(librarian));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/librarian/librarian_id/{id}")
    public ResponseEntity<Users> searchLibrarian(@PathVariable int id){
        try {
            return ResponseEntity.ok().body(libraryServices.searchLibrarian(id));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update/librarian/librarian/{id}")
    public ResponseEntity<Users> updateLibrarian(@PathVariable int id, @RequestBody Librarian librarian){
        try {
            return ResponseEntity.ok().body(libraryServices.updateLibrarian(id,librarian));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/librarian/librarian_id/{id}")
    public void deleteLibrarian(@PathVariable int id){
        libraryServices.deleteLibrarian(id);
    }


    @GetMapping("/search/name/librarian_name/{username}")
    public ResponseEntity<List<Librarian>> searchLibrarianByName(@PathVariable String username){
        try {
            return ResponseEntity.ok().body(libraryServices.findByUsername(username));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
