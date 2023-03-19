package org.uob.Services;

import org.uob.Models.*;

import java.awt.print.Book;
import java.util.List;

public interface LibraryServices {

//    Books
    Books searchBook(int id);
    Books addBook(Books books);
    Books updateBook(int id, Books books);
    public void deleteBook(int id);
    public void deleteBookLoan(int id);
    BookLoan reserveBook(BookLoan bookLoan, int BookID, int id);
    BookLoan returnedBook(BookLoan bookLoan, int loanId, int id);
    BookLoan searchBookLoan(int id);
    BookLoan updateBookLoan(int id, BookLoan bookLoan);


//    Users
    Users addStudent(Student student);
    Users searchStudent(int id);
    Users updateStudent(int id, Student student);
    public void deleteStudent(int id);
    Student demeritStudent(int id,Student student, int demerit);

//    Librarian
    Librarian addLibrarian(Librarian librarian);
    Librarian searchLibrarian( int id);
    Librarian updateLibrarian(int id, Librarian librarian);
    List<Librarian> findByUsername(String name);
    public void deleteLibrarian(int id);

    public void addCategory(CategoriesType categoriesType);
}
