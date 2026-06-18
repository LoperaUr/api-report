package com.pragma.apireport.infrastructure.config;

import com.pragma.apireport.infrastructure.adapters.persistenceadapter.entity.ReportDocument;
import com.pragma.apireport.infrastructure.adapters.persistenceadapter.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final ReportRepository reportRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        reportRepository.count()
                .filter(count -> count == 0)
                .flatMapMany(count -> reportRepository.saveAll(buildInitialReports()))
                .subscribe(
                        saved -> log.info("Initialized report for bootcamp: {}", saved.getBootcampName()),
                        error -> log.error("Error initializing data: {}", error.getMessage())
                );
    }

    private List<ReportDocument> buildInitialReports() {
        return List.of(
                buildReport(1L, "Fullstack Java", "Full-stack web development with Java and React",
                        LocalDate.of(2026, 7, 1), 12, 2, 12,
                        List.of(cap(1L, "Backend Development"), cap(2L, "Frontend Development")),
                        List.of(tech(1L, "Java"), tech(2L, "Spring Boot"), tech(3L, "PostgreSQL"), tech(25L, "MySQL"), tech(26L, "Git"),
                                tech(4L, "JavaScript"), tech(5L, "React"), tech(6L, "TypeScript"), tech(27L, "HTML"), tech(28L, "CSS"), tech(29L, "Sass"), tech(30L, "Webpack")),
                        List.of(person("Alice Smith", "Alice@smith.com"), person("Bob Johnson", "Bob@Johnson.com"))),

                buildReport(2L, "Cloud Native", "Cloud-native development with backend and DevOps practices",
                        LocalDate.of(2026, 7, 15), 10, 3, 16,
                        List.of(cap(1L, "Backend Development"), cap(3L, "DevOps"), cap(8L, "Cloud Infrastructure")),
                        List.of(tech(1L, "Java"), tech(2L, "Spring Boot"), tech(3L, "PostgreSQL"), tech(25L, "MySQL"), tech(26L, "Git"),
                                tech(7L, "Docker"), tech(8L, "Kubernetes"), tech(9L, "AWS"), tech(18L, "Terraform"), tech(24L, "Jenkins"),
                                tech(33L, "Azure")),
                        List.of()),

                buildReport(3L, "Frontend Specialist", "Advanced frontend with React and Angular",
                        LocalDate.of(2026, 8, 1), 8, 2, 9,
                        List.of(cap(2L, "Frontend Development"), cap(5L, "Frontend Angular")),
                        List.of(tech(4L, "JavaScript"), tech(5L, "React"), tech(6L, "TypeScript"), tech(13L, "Angular"),
                                tech(27L, "HTML"), tech(28L, "CSS"), tech(29L, "Sass"), tech(30L, "Webpack")),
                        List.of()),

                buildReport(4L, "Data Engineering", "Data pipelines and machine learning in production",
                        LocalDate.of(2026, 8, 15), 14, 3, 12,
                        List.of(cap(4L, "Data Science"), cap(1L, "Backend Development"), cap(7L, "Event-Driven Architecture")),
                        List.of(tech(10L, "Python"), tech(11L, "TensorFlow"), tech(12L, "Pandas"), tech(31L, "NumPy"), tech(32L, "Scikit-learn"),
                                tech(3L, "PostgreSQL"), tech(1L, "Java"), tech(2L, "Spring Boot"), tech(17L, "Kafka"), tech(16L, "Redis")),
                        List.of()),

                buildReport(5L, "Mobile Fullstack", "Cross-platform mobile apps with backend integration",
                        LocalDate.of(2026, 9, 1), 10, 3, 7,
                        List.of(cap(9L, "Mobile Cross-Platform"), cap(6L, "Backend Node"), cap(10L, "Mobile Native")),
                        List.of(tech(19L, "Flutter"), tech(20L, "Dart"), tech(26L, "Git"), tech(14L, "Node.js"), tech(4L, "JavaScript"),
                                tech(15L, "MongoDB"), tech(6L, "TypeScript"), tech(21L, "Swift"), tech(22L, "Kotlin"), tech(23L, "GraphQL")),
                        List.of()),

                buildReport(6L, "DevOps Engineer", "Infrastructure automation and delivery pipelines",
                        LocalDate.of(2026, 9, 15), 12, 4, 11,
                        List.of(cap(3L, "DevOps"), cap(8L, "Cloud Infrastructure"), cap(11L, "CI/CD"), cap(12L, "Observability")),
                        List.of(tech(7L, "Docker"), tech(8L, "Kubernetes"), tech(9L, "AWS"), tech(18L, "Terraform"), tech(24L, "Jenkins"),
                                tech(26L, "Git"), tech(33L, "Azure"), tech(34L, "Prometheus"), tech(35L, "Grafana")),
                        List.of()),

                buildReport(7L, "Fullstack Node", "Full-stack JavaScript development with Node.js and React",
                        LocalDate.of(2026, 10, 1), 10, 3, 10,
                        List.of(cap(6L, "Backend Node"), cap(2L, "Frontend Development"), cap(3L, "DevOps")),
                        List.of(tech(14L, "Node.js"), tech(4L, "JavaScript"), tech(15L, "MongoDB"), tech(6L, "TypeScript"),
                                tech(5L, "React"), tech(27L, "HTML"), tech(28L, "CSS"), tech(7L, "Docker"), tech(8L, "Kubernetes"), tech(9L, "AWS")),
                        List.of()),

                buildReport(8L, "Mobile Native", "Native iOS and Android app development",
                        LocalDate.of(2026, 10, 15), 8, 1, 4,
                        List.of(cap(10L, "Mobile Native")),
                        List.of(tech(21L, "Swift"), tech(22L, "Kotlin"), tech(23L, "GraphQL"), tech(26L, "Git")),
                        List.of()),

                buildReport(9L, "AI and Data", "Artificial intelligence and data science at scale",
                        LocalDate.of(2026, 11, 1), 16, 4, 17,
                        List.of(cap(4L, "Data Science"), cap(1L, "Backend Development"), cap(8L, "Cloud Infrastructure"), cap(3L, "DevOps")),
                        List.of(tech(10L, "Python"), tech(11L, "TensorFlow"), tech(12L, "Pandas"), tech(31L, "NumPy"), tech(32L, "Scikit-learn"),
                                tech(3L, "PostgreSQL"), tech(1L, "Java"), tech(2L, "Spring Boot"), tech(9L, "AWS"), tech(18L, "Terraform"),
                                tech(7L, "Docker"), tech(8L, "Kubernetes")),
                        List.of()),

                buildReport(10L, "Enterprise Architect", "Enterprise architecture with event-driven systems",
                        LocalDate.of(2026, 11, 15), 14, 4, 12,
                        List.of(cap(1L, "Backend Development"), cap(7L, "Event-Driven Architecture"), cap(8L, "Cloud Infrastructure"), cap(11L, "CI/CD")),
                        List.of(tech(1L, "Java"), tech(2L, "Spring Boot"), tech(3L, "PostgreSQL"), tech(25L, "MySQL"), tech(26L, "Git"),
                                tech(17L, "Kafka"), tech(16L, "Redis"), tech(18L, "Terraform"), tech(9L, "AWS"), tech(7L, "Docker"),
                                tech(8L, "Kubernetes"), tech(24L, "Jenkins")),
                        List.of())
        );
    }

    private ReportDocument buildReport(Long bootcampId, String name, String description,
                                       LocalDate launchDate, int duration, int capCount, int techCount,
                                       List<ReportDocument.CapabilityInfoDocument> caps,
                                       List<ReportDocument.TechnologyInfoDocument> techs,
                                       List<ReportDocument.PersonInfoDocument> persons) {
        ReportDocument doc = new ReportDocument();
        doc.setBootcampId(bootcampId);
        doc.setBootcampName(name);
        doc.setBootcampDescription(description);
        doc.setBootcampLaunchDate(launchDate);
        doc.setBootcampDuration(duration);
        doc.setCapabilityCount(capCount);
        doc.setTechnologyCount(techCount);
        doc.setEnrolledPersonCount(persons.size());
        doc.setCapabilities(caps);
        doc.setTechnologies(techs);
        doc.setEnrolledPersons(persons);
        doc.setCreatedAt(LocalDateTime.now());
        return doc;
    }

    private ReportDocument.CapabilityInfoDocument cap(Long id, String name) {
        ReportDocument.CapabilityInfoDocument doc = new ReportDocument.CapabilityInfoDocument();
        doc.setId(id);
        doc.setName(name);
        return doc;
    }

    private ReportDocument.TechnologyInfoDocument tech(Long id, String name) {
        ReportDocument.TechnologyInfoDocument doc = new ReportDocument.TechnologyInfoDocument();
        doc.setId(id);
        doc.setName(name);
        return doc;
    }

    private ReportDocument.PersonInfoDocument person(String name, String email) {
        ReportDocument.PersonInfoDocument doc = new ReportDocument.PersonInfoDocument();
        doc.setName(name);
        doc.setEmail(email);
        return doc;
    }
}
