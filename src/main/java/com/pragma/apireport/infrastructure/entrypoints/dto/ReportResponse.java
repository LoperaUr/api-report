package com.pragma.apireport.infrastructure.entrypoints.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ReportResponse {

    private String id;
    private Long bootcampId;
    private String bootcampName;
    private String bootcampDescription;
    private LocalDate bootcampLaunchDate;
    private Integer bootcampDuration;
    private Integer capabilityCount;
    private Integer technologyCount;
    private Integer enrolledPersonCount;
    private List<ReportRequest.CapabilityInfoDTO> capabilities;
    private List<ReportRequest.TechnologyInfoDTO> technologies;
    private List<PersonInfoDTO> enrolledPersons;
    private LocalDateTime createdAt;

    @Data
    public static class PersonInfoDTO {
        private String name;
        private String email;
    }
}
