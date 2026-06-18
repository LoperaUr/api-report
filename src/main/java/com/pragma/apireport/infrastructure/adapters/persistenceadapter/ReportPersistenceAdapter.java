package com.pragma.apireport.infrastructure.adapters.persistenceadapter;

import com.pragma.apireport.domain.model.Report;
import com.pragma.apireport.domain.spi.ReportPersistencePort;
import com.pragma.apireport.infrastructure.adapters.persistenceadapter.mapper.ReportDocumentMapper;
import com.pragma.apireport.infrastructure.adapters.persistenceadapter.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReportPersistenceAdapter implements ReportPersistencePort {

    private final ReportRepository reportRepository;
    private final ReportDocumentMapper reportDocumentMapper;

    @Override
    public Mono<Report> save(Report report) {
        return reportRepository.save(reportDocumentMapper.toDocument(report))
                .map(reportDocumentMapper::toDomain);
    }

    @Override
    public Mono<Report> findByBootcampId(Long bootcampId) {
        return reportRepository.findByBootcampId(bootcampId)
                .map(reportDocumentMapper::toDomain);
    }

    @Override
    public Mono<Report> findTopByOrderByEnrolledPersonCountDesc() {
        return reportRepository.findTopByOrderByEnrolledPersonCountDesc()
                .map(reportDocumentMapper::toDomain);
    }
}
