package com.nighthawk.spring_portfolio.mvc.tutor;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TutorJPARepository extends JpaRepository<Tutor, Long> {
    // Repository interface for performing CRUD operations on the Tutor entity,
    // including custom queries for specific data retrieval needs.
    List<Tutor> findAll();

    List<Tutor> findAllById(long i);

    @Query(value = "SELECT coalesce(max(id), 0) FROM Tutor")
     Long getMaxId();

    List<Tutor> findTutorByUsernameIgnoreCase(String username);

    List<Tutor> findByUsername(String username);
}