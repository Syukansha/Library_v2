package org.uob.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.uob.Models.Books;

import java.util.List;

public interface BookRepositories extends JpaRepository<Books, Integer> {
    @Query("select b from Books b where  title like %?1%")
    public List<Books> searchByTitle(String title);
}
