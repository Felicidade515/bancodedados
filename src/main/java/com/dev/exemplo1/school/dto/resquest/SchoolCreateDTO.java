package com.dev.exemplo1.school.dto.resquest;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

public record SchoolCreateDTO(
        @NotBlank(message = "Insere um code")
        String code,
        @NotBlank(message = "Insere a designacao")
        String designation,
        @NotBlank(message = "Insere o endereco")
        String address
) {

}
