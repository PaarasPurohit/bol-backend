package com.nighthawk.spring_portfolio.mvc.session;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionJPARepository extends JpaRepository<Session, Long> {
    // Repository interface for performing CRUD operations on the Session entity,
    // including custom queries for specific data retrieval needs.
    List<Session> findAll();

    List<Session> findAllById(long i);

    @Query(value = "SELECT coalesce(max(id), 0) FROM Session")
     Long getMaxId();

    List<Session> findSessionByDateIgnoreCase(String date);

    List<Session> findByDate(String date);
}