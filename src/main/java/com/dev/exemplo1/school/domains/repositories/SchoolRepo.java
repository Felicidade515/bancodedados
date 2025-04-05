package com.dev.exemplo1.school.domains.repositories;

import com.dev.exemplo1.school.domains.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {
    //List<SchoolRepo>findAll();
    boolean existsByDesignationAndActiveTrue(String designation);
    Optional<School> findByCode(String code);
}
