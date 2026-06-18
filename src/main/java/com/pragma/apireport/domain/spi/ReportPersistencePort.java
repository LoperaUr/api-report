package com.pragma.apireport.domain.spi;

import com.pragma.apireport.domain.model.PersonInfo;
import com.pragma.apireport.domain.model.Report;
import reactor.core.publisher.Mono;

public interface ReportPersistencePort {

    Mono<Report> save(Report report);

    Mono<Report> findByBootcampId(Long bootcampId);

    Mono<Report> findTopByOrderByEnrolledPersonCountDesc();
}
