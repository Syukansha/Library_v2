package org.uob.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uob.Models.Books;

import java.util.List;

public interface BookRepositories extends JpaRepository<Books, Integer> {
    List<Books> findByTitleContaining(String title);
}
