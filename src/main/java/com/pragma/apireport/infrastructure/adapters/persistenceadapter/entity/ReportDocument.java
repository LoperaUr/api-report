package com.pragma.apireport.infrastructure.adapters.persistenceadapter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "reports")
public class ReportDocument {

    @Id
    private String id;
    @Indexed(unique = true)
    private Long bootcampId;
    private String bootcampName;
    private String bootcampDescription;
    private LocalDate bootcampLaunchDate;
    private Integer bootcampDuration;
    private Integer capabilityCount;
    private Integer technologyCount;
    private Integer enrolledPersonCount;
    private List<CapabilityInfoDocument> capabilities;
    private List<TechnologyInfoDocument> technologies;
    private List<PersonInfoDocument> enrolledPersons;
    private LocalDateTime createdAt;

    @Data
    @NoArgsConstructor
    public static class CapabilityInfoDocument {
        private Long id;
        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class TechnologyInfoDocument {
        private Long id;
        private String name;
    }

    @Data
    @NoArgsConstructor
    public static class PersonInfoDocument {
        private String name;
        private String email;
    }
}
