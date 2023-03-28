package org.uob.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.uob.Models.BookLoan;
import org.uob.Models.Books;

import java.util.List;

public interface BookLoanRepositories extends JpaRepository<BookLoan, Integer> {
    @Query("Select b from BookLoan b where Student_id like %?1%")
    public List<BookLoan> getLoanStudent(int id);
}
