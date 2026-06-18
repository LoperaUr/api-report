package com.pragma.apireport.infrastructure.adapters.persistenceadapter;

import com.pragma.apireport.domain.model.PersonInfo;
import com.pragma.apireport.domain.model.Report;
import com.pragma.apireport.domain.spi.ReportPersistencePort;
import com.pragma.apireport.infrastructure.adapters.persistenceadapter.entity.ReportDocument;
import com.pragma.apireport.infrastructure.adapters.persistenceadapter.mapper.ReportDocumentMapper;
import com.pragma.apireport.infrastructure.adapters.persistenceadapter.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReportPersistenceAdapter implements ReportPersistencePort {

    private final ReportRepository reportRepository;
    private final ReportDocumentMapper reportDocumentMapper;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

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
    public Mono<Report> addPersonToReport(Long bootcampId, PersonInfo personInfo) {
        Query query = Query.query(Criteria.where("bootcampId").is(bootcampId));

        ReportDocument.PersonInfoDocument personDoc = new ReportDocument.PersonInfoDocument();
        personDoc.setName(personInfo.getName());
        personDoc.setEmail(personInfo.getEmail());

        Update update = new Update()
                .addToSet("enrolledPersons", personDoc)
                .inc("enrolledPersonCount", 1);

        return reactiveMongoTemplate.findAndModify(
                query,
                update,
                FindAndModifyOptions.options().returnNew(true),
                ReportDocument.class
        ).map(reportDocumentMapper::toDomain);
    }

    @Override
    public Mono<Report> findTopByOrderByEnrolledPersonCountDesc() {
        return reportRepository.findTopByOrderByEnrolledPersonCountDesc()
                .map(reportDocumentMapper::toDomain);
    }
}
