package org.uob.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uob.Models.CategoriesType;

public interface CategoriesRepositories extends JpaRepository<CategoriesType, Integer> {
}
