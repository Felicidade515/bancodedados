package com.dev.exemplo1.school.domains.entity;


import com.dev.exemplo1.school.dto.resquest.SchoolCreateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String designation;
    private String address;
    private LocalDateTime schoolDate;
    private boolean active = true;

    public School(SchoolCreateDTO data){
        this.id = getId();
        this.code = data.code();
        this.designation = data.designation();
        this.address = data.address();
        this.schoolDate = getSchoolDate();
        this.active = true;
    }

}
