package com.learningChirag.challangesApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChallangeRepository extends JpaRepository<Challange, Integer> {
    Optional<Challange> findByMonthIgnoreCase(String month);
}
