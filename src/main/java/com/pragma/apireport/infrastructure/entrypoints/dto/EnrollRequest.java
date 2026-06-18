package com.pragma.apireport.infrastructure.entrypoints.dto;

import lombok.Data;

@Data
public class EnrollRequest {

    private String personName;
    private String personEmail;
}
