package com.dev.exemplo1.school.controller;

import com.dev.exemplo1.school.domains.service.SchoolService;
import com.dev.exemplo1.school.dto.response.ResponseAPI;
import com.dev.exemplo1.school.dto.resquest.SchoolCreateDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/escola")
@Tag(name = "Escolas")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseAPI> createSchool(@RequestBody @Valid SchoolCreateDTO data) throws Exception{
        schoolService.createSchool(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseAPI("Escola criada com sucesso", null));
    }

    @GetMapping
    public ResponseEntity<ResponseAPI> getSchools(){
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseAPI("Escolas encontradas", schoolService.findAll()));
    }

}
