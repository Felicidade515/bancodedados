package com.dev.exemplo1.school.domains.service;

import com.dev.exemplo1.infrastructure.exceptions.ConflictException;
import com.dev.exemplo1.school.domains.entity.School;
import com.dev.exemplo1.school.domains.repositories.SchoolRepo;
import com.dev.exemplo1.school.dto.resquest.SchoolCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepo schoolRepo;

    public School save(School school){
        return schoolRepo.save(school);
    }

    public School createSchool(SchoolCreateDTO data) throws ConflictException {
        if(schoolRepo.existsByDesignationAndActiveTrue(data.designation())){
            throw new ConflictException("Escola ja existe");
        }
        School school =new School(data);
        return this.save(school);
    }
}
