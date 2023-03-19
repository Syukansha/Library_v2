package org.uob.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uob.Exception.ResourceNotFoundException;
import org.uob.Models.*;
import org.uob.Repositories.BookLoanRepositories;
import org.uob.Repositories.BookRepositories;
import org.uob.Repositories.CategoriesRepositories;
import org.uob.Repositories.UsersRepositories;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryServices{
    @Autowired
    UsersRepositories usersRepositories;

    @Autowired
    BookRepositories bookRepositories;

    @Autowired
    BookLoanRepositories bookLoanRepositories;

    @Autowired
    CategoriesRepositories categoriesRepositories;

//    Book
    @Override
    public Books searchBook(int id) {
        Optional<Books> bookData = this.bookRepositories.findById(id);

        if (bookData.isPresent()){
            return bookData.get();
        }
        else throw new ResourceNotFoundException("Record not found by id: "+id);
    }

    @Override
    public Books addBook(Books books) {
        books = new Books(books.getBookID(),books.getTitle(),books.getAuthor(),books.getCategories(),books.getStatus());

        return bookRepositories.save(books);
    }
    @Override
    public Books updateBook(int id, Books books) {
        Optional<Books> bookData = bookRepositories.findById(id);
        if(bookData.isPresent()){
            Books _book = bookData.get();

            _book.setTitle(books.getTitle());
            _book.setCategories(books.getCategories());
            _book.setAuthor(books.getAuthor());
            _book.setStatus(books.getStatus());

            return bookRepositories.save(_book);
        }
        else throw new ResourceNotFoundException("Record not found with id: "+ id);
    }
    @Override
    public void deleteBook(int id) {
        Optional<Books> bookData = this.bookRepositories.findById(id);
        if (bookData.isPresent()){
            Books _book = (Books) bookData.get();
            bookRepositories.deleteById(id);
        }
    }
    @Override
    public void deleteBookLoan(int id) {
        Optional<BookLoan> bookLoanData = this.bookLoanRepositories.findById(id);

        if (bookLoanData.isPresent()){
            bookLoanRepositories.deleteById(id);
        }
    }
    @Override
    public BookLoan reserveBook(BookLoan bookLoan, int BookID, int id) {
        Optional<Users> userData = usersRepositories.findById(id);
        Optional<Books> bookData = bookRepositories.findById(BookID);

        if(userData.isPresent() && bookData.isPresent()){
            Users _user = (Student) userData.get();
            Books books = bookData.get();

            bookLoan = new BookLoan(bookLoan.getLoanID(),books,(Student) _user,bookLoan.getDateBorrowed(),bookLoan.getDate_due(),bookLoan.getDate_returned(),bookLoan.getStudent_merits());

            bookLoan.setStudent_merits(((Student) _user).getStudent_merits());

            if(bookLoan.getStudent_merits() >= 10){
                return bookLoanRepositories.save(bookLoan);
            }
            else {
                throw new ResourceNotFoundException("You can't reserve the book because you are in demerit list");
            }

        }
        else throw new ResourceNotFoundException("record not found with id: "+id+" or "+BookID );
    }

    @Override
    public BookLoan returnedBook(BookLoan bookLoan,int loanId, int id) {
        Optional<BookLoan> getData = bookLoanRepositories.findById(id);
        Optional<Users> getStudent =  usersRepositories.findById(id);
        if(getData.isPresent() && getStudent.isPresent()){

            BookLoan loan = getData.get();
            Student _student = (Student) getStudent.get();
            loan.setDate_returned(bookLoan.getDate_returned());
            if(loan.getDate_returned().compareTo(loan.getDate_due()) > 0){
                System.out.println("YOU are late");
                _student.setStudent_merits(_student.getStudent_merits() - 5);
                usersRepositories.save(_student);
            }
            return bookLoanRepositories.save(loan);
        }else{
            return null;
        }

    }

    @Override
    public BookLoan searchBookLoan(int id) {
        Optional<BookLoan> bookLoanData = this.bookLoanRepositories.findById(id);

        if (bookLoanData.isPresent()){
            return bookLoanData.get();
        }
        else throw new ResourceNotFoundException("Record not found by id: "+id);
    }

    @Override
    public BookLoan updateBookLoan(int id, BookLoan bookLoan) {
        Optional<BookLoan> bookData = bookLoanRepositories.findById(id);
        if(bookData.isPresent()){
            BookLoan _bookLoan = bookData.get();

            _bookLoan.setDate_due(bookLoan.getDate_due());
            _bookLoan.setDate_returned(bookLoan.getDate_returned());
            _bookLoan.setDateBorrowed(bookLoan.getDateBorrowed());
            return bookLoanRepositories.save(_bookLoan);
        }
        else throw new ResourceNotFoundException("Record not found with id: "+ id);
    }

    public List<Books> searchByTitle(String title) {
        List<Books> bookData = new ArrayList<Books>();

        if (title == null)
            bookRepositories.findAll().forEach(bookData::add);
        else
            searchByTitle(title).forEach(bookData::add);

        return bookData;
    }
//    Student
    @Override
    public Users addStudent(Student student) {
        student = new Student(student.getId(),student.getUsername(),student.getPassword(),student.getEmail(),25);
        return usersRepositories.save(student);
    }

    @Override
    public Users searchStudent(int id) {
        Optional<Users> studentData = this.usersRepositories.findById(id);
        if (studentData.isPresent()){
            return studentData.get();
        }
        else throw new ResourceNotFoundException("Record not found by id: "+id);
    }
    @Override
    public Users updateStudent(int id, Student student) {
        Optional<Users> userData = usersRepositories.findById(id);
        if(userData.isPresent()){
            Student _student = (Student) userData.get();

            _student.setUsername(student.getUsername());
            _student.setPassword(student.getPassword());
            _student.setEmail(student.getEmail());
            _student.setStudent_merits(student.getStudent_merits());

            return usersRepositories.save(_student);

        }
        else throw new ResourceNotFoundException("Record not found with id: "+id);
    }
    @Override
    public void deleteStudent(int id) {
        Optional<Users> studentData = this.usersRepositories.findById(id);
        if (studentData.isPresent()){
            Student _student = (Student) studentData.get();
            usersRepositories.deleteById(id);
        }
    }

    @Override
    public Student demeritStudent(int id,Student student,int demerit) {
        Optional<Users> studentData = usersRepositories.findById(id);

        if(studentData.isPresent()){
            Student _student = (Student) studentData.get();
            _student.setStudent_merits(_student.getStudent_merits() - demerit);
            return _student;
        }
        else throw new ResourceNotFoundException("Record not found with id: "+id);
    }

    public List<Student> findByUsernameContaining(String username) {

        List<Student> userData = new ArrayList<Student>();

            usersRepositories.findByUsernameContaining(username).forEach(userData::add);

        return userData;
    }


//    Librarian
    @Override
    public Librarian addLibrarian(Librarian librarian) {
        librarian = new Librarian(librarian.getId(),librarian.getUsername(),librarian.getPassword(),librarian.getEmail());
        return usersRepositories.save(librarian);
    }
    @Override
    public Librarian searchLibrarian(int id) {
        Optional<Users> librarianData = this.usersRepositories.findById(id);

        if (librarianData.isPresent()){
            return (Librarian) librarianData.get();
        }
        else throw new ResourceNotFoundException("Record not found by id: "+id);
    }
    @Override
    public Librarian updateLibrarian(int id, Librarian librarian) {
        Optional<Users> userData = usersRepositories.findById(id);
        if(userData.isPresent()){
            Librarian _librarian = (Librarian) userData.get();
            _librarian.setUsername(librarian.getUsername());
            _librarian.setPassword(librarian.getPassword());
            _librarian.setEmail(librarian.getEmail());

            return usersRepositories.save(_librarian);
        }
        else throw new ResourceNotFoundException("Record not found with id"+id);
    }

    @Override
    public List<Librarian> findByUsername(String name) {
        List<Librarian> userData = new ArrayList<Librarian>();
        findByUsername(name).forEach(userData::add);
        return userData;
    }

    @Override
    public void deleteLibrarian(int id) {
        Optional<Users> userData = this.usersRepositories.findById(id);
        if (userData.isPresent()){
            Librarian _librarian = (Librarian) userData.get();
            usersRepositories.deleteById(id);
        }
    }

    @Override
    public void addCategory(CategoriesType categoriesType) {
        categoriesRepositories.save(new CategoriesType(categoriesType.getGenreID(),Categories.MYSTERY,20));
        categoriesRepositories.save(new CategoriesType(categoriesType.getGenreID(),Categories.DRAMA,10));
        categoriesRepositories.save(new CategoriesType(categoriesType.getGenreID(),Categories.FICTION,50));
        categoriesRepositories.save(new CategoriesType(categoriesType.getGenreID(),Categories.BIOGRAPHY,15));
        categoriesRepositories.save(new CategoriesType(categoriesType.getGenreID(),Categories.LITERATURE,12));
    }



}
