package org.uob.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uob.Models.BookLoan;

public interface BookLoanRepositories extends JpaRepository<BookLoan, Integer> {
}
