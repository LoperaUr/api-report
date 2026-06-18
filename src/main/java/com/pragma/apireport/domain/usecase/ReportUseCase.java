package com.pragma.apireport.domain.usecase;

import com.pragma.apireport.domain.api.ReportServicePort;
import com.pragma.apireport.domain.model.Report;
import com.pragma.apireport.domain.spi.ReportPersistencePort;
import reactor.core.publisher.Mono;

public class ReportUseCase implements ReportServicePort {

    private final ReportPersistencePort reportPersistencePort;

    public ReportUseCase(ReportPersistencePort reportPersistencePort) {
        this.reportPersistencePort = reportPersistencePort;
    }

    @Override
    public Mono<Report> save(Report report) {
        // TODO: implement save logic
        return Mono.empty();
    }

    @Override
    public Mono<Report> findBootcampWithMostEnrolledPersons() {
        // TODO: implement query logic
        return Mono.empty();
    }
}
