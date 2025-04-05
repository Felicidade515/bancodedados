package com.dev.exemplo1.school.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record SchoolRes(
    Long id,
    String code,
    String designation,
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    LocalDateTime schoolDate,
    String address

) {
}
