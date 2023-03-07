package org.uob.Models;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.Date;

@Entity
@Table(name = "BOOKLOAN")
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int LoanID;

    @OneToOne
    @JoinColumn(name = "BookID", referencedColumnName = "BookId")
    private Books books;

    @OneToOne
    @JoinColumn(name = "Student_id",referencedColumnName = "id")
    private Student student;

    private Date DateBorrowed;
    private Date Date_due;
    private Date Date_returned;

    @JoinColumn(name = "student_merits")
    private int student_merits;

    public BookLoan(){}

    public BookLoan(int loanID, Books books, Student student, Date dateBorrowed, Date date_due, Date date_returned, int student_merits) {
        LoanID = loanID;
        this.books = books;
        this.student = student;
        DateBorrowed = dateBorrowed;
        Date_due = date_due;
        Date_returned = date_returned;
        this.student_merits = student_merits;
    }

    public int getLoanID() {
        return LoanID;
    }

    public void setLoanID(int loanID) {
        LoanID = loanID;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDateBorrowed() {
        return DateBorrowed;
    }

    public void setDateBorrowed(Date dateBorrowed) {
        DateBorrowed = dateBorrowed;
    }

    public Date getDate_due() {
        return Date_due;
    }

    public void setDate_due(Date date_due) {
        Date_due = date_due;
    }

    public Date getDate_returned() {
        return Date_returned;
    }

    public void setDate_returned(Date date_returned) {
        Date_returned = date_returned;
    }

    public int getStudent_merits() {
        return student_merits;
    }

    public void setStudent_merits(int student_merits) {
        this.student_merits = student_merits;
    }

    @Override
    public String toString() {
        return "BookLoanRepositories{" +
                "LoanID=" + LoanID +
                ", books=" + books +
                ", student=" + student +
                ", DateBorrowed=" + DateBorrowed +
                ", Date_due=" + Date_due +
                ", Date_returned=" + Date_returned +
                ", student_merits=" + student_merits +
                '}';
    }
}
