package com.pragma.apireport.domain.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Report {

    private String id;
    private Long bootcampId;
    private String bootcampName;
    private String bootcampDescription;
    private LocalDate bootcampLaunchDate;
    private Integer bootcampDuration;
    private Integer capabilityCount;
    private Integer technologyCount;
    private Integer enrolledPersonCount;
    private List<CapabilityInfo> capabilities;
    private List<TechnologyInfo> technologies;
    private List<PersonInfo> enrolledPersons;
    private LocalDateTime createdAt;
}
