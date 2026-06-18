package com.pragma.apireport.infrastructure.entrypoints.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReportRequest {

    private String bootcampName;
    private String bootcampDescription;
    private LocalDate bootcampLaunchDate;
    private Integer bootcampDuration;
    private Integer capabilityCount;
    private Integer technologyCount;
    private Integer enrolledPersonCount;
    private List<String> capabilityNames;
    private List<String> technologyNames;
}
