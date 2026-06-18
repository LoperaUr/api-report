package com.pragma.apireport.domain.api;

import com.pragma.apireport.domain.model.Report;
import reactor.core.publisher.Mono;

public interface ReportServicePort {

    Mono<Report> save(Report report);

    Mono<Report> findBootcampWithMostEnrolledPersons();
}
