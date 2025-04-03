package com.dev.exemplo1.school.domains.repositories;

import com.dev.exemplo1.school.domains.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {
    //List<SchoolRepo>findAll();
    boolean existsByDesignationAndActiveTrue(String designation);
}
