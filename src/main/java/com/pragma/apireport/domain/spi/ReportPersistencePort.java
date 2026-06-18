package com.pragma.apireport.domain.spi;

import com.pragma.apireport.domain.model.Report;
import reactor.core.publisher.Mono;

public interface ReportPersistencePort {

    Mono<Report> save(Report report);

    Mono<Report> findTopByOrderByEnrolledPersonCountDesc();
}
