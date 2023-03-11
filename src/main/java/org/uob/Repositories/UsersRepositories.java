package org.uob.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uob.Models.Student;
import org.uob.Models.Users;

import java.util.List;

public interface UsersRepositories extends JpaRepository<Users, Integer> {
    List<Student> findByUsernameContaining(String username);

}
