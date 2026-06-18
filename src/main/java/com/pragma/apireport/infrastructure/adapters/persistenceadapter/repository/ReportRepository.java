package com.pragma.apireport.infrastructure.adapters.persistenceadapter.repository;

import com.pragma.apireport.infrastructure.adapters.persistenceadapter.entity.ReportDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ReportRepository extends ReactiveMongoRepository<ReportDocument, String> {

    Mono<ReportDocument> findByBootcampId(Long bootcampId);

    Mono<ReportDocument> findTopByOrderByEnrolledPersonCountDesc();
}
