package com.pragma.apireport.domain.usecase;

import com.pragma.apireport.domain.api.ReportServicePort;
import com.pragma.apireport.domain.exceptions.BusinessException;
import com.pragma.apireport.domain.exceptions.ErrorMessages;
import com.pragma.apireport.domain.model.PersonInfo;
import com.pragma.apireport.domain.model.Report;
import com.pragma.apireport.domain.spi.ReportPersistencePort;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReportUseCase implements ReportServicePort {

    private final ReportPersistencePort reportPersistencePort;

    public ReportUseCase(ReportPersistencePort reportPersistencePort) {
        this.reportPersistencePort = reportPersistencePort;
    }

    @Override
    public Mono<Report> save(Report report) {
        report.setEnrolledPersonCount(0);
        report.setEnrolledPersons(new ArrayList<>());
        report.setCreatedAt(LocalDateTime.now());
        return reportPersistencePort.save(report);
    }

    @Override
    public Mono<Report> enrollPerson(Long bootcampId, PersonInfo personInfo) {
        return reportPersistencePort.addPersonToReport(bootcampId, personInfo)
                .switchIfEmpty(Mono.error(new BusinessException(ErrorMessages.REPORT_NOT_FOUND)));
    }

    @Override
    public Mono<Report> findBootcampWithMostEnrolledPersons() {
        return reportPersistencePort.findTopByOrderByEnrolledPersonCountDesc()
                .switchIfEmpty(Mono.error(new BusinessException(ErrorMessages.REPORT_NOT_FOUND)));
    }
}
