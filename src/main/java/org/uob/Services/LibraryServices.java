package org.uob.Services;

import org.springframework.data.jpa.repository.Query;
import org.uob.Models.*;

import java.util.List;

public interface LibraryServices {

//    Books
    Books searchBook(int id);
    Books addBook(Books books);
    Books updateBook(int id, Books books);
    public void deleteBook(int id);
    public void deleteBookLoan(int id);
    BookLoan reserveBook(BookLoan bookLoan, int BookID, int id);
    BookLoan searchBookLoan(int id);
    BookLoan updateBookLoan(int id, BookLoan bookLoan);


//    Users
    Users addStudent(Student student);
    Users searchStudent(int id);
    Users updateStudent(int id, Student student);
    public void deleteStudent(int id);

//    Librarian
    Librarian addLibrarian(Librarian librarian);
    Librarian searchLibrarian( int id);
    Librarian updateLibrarian(int id, Librarian librarian);
    List<Librarian> findByUsername(String name);
    public void deleteLibrarian(int id);

    public void addCategory(CategoriesType categoriesType);




}
