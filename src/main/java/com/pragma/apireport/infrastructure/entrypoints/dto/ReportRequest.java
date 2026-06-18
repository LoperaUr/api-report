package com.pragma.apireport.infrastructure.entrypoints.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReportRequest {

    private Long bootcampId;
    private String bootcampName;
    private String bootcampDescription;
    private LocalDate bootcampLaunchDate;
    private Integer bootcampDuration;
    private Integer capabilityCount;
    private Integer technologyCount;
    private List<CapabilityInfoDTO> capabilities;
    private List<TechnologyInfoDTO> technologies;

    @Data
    public static class CapabilityInfoDTO {
        private Long id;
        private String name;
    }

    @Data
    public static class TechnologyInfoDTO {
        private Long id;
        private String name;
    }
}
