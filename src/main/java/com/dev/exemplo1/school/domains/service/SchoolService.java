package com.dev.exemplo1.school.domains.service;

import com.dev.exemplo1.infrastructure.exceptions.ConflictException;
import com.dev.exemplo1.infrastructure.exceptions.NotFoundException;
import com.dev.exemplo1.school.domains.entity.School;
import com.dev.exemplo1.school.domains.repositories.SchoolRepo;
import com.dev.exemplo1.school.dto.response.SchoolRes;
import com.dev.exemplo1.school.dto.resquest.SchoolCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepo schoolRepo;

public SchoolService(SchoolRepo schoolRepo){
this.schoolRepo =schoolRepo;
}

    public School save(School school){
        return schoolRepo.save(school);
    }

//    public List<SchoolRes> findAll(){
//       List<School> schools = schoolRepo.findAll();
//
//       return schools.stream().map(school -> new SchoolRes(
//            school.getId(),
//            school.getCode(),
//            school.getDesignation(),
//            school.getAddress(),
//            school.getSchoolDate()
//       ))
//               .collect(Collectors.toList());
//    }

    public List<School> findAll(){
        return schoolRepo.findAll();
    }

    public School findByCode(String code) throws NotFoundException {
        return schoolRepo.findByCode(code).orElseThrow(() -> new NotFoundException("Escola nao foi encontrada"));
    }

    public School createSchool(SchoolCreateDTO data) throws ConflictException {
        if(schoolRepo.existsByDesignationAndActiveTrue(data.designation())){
            throw new ConflictException("Escola ja existe");
        }
        School school =new School(data);
        return this.save(school);
    }
}
