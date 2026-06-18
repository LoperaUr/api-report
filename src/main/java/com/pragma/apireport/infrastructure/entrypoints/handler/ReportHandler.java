package com.pragma.apireport.infrastructure.entrypoints.handler;

import com.pragma.apireport.domain.api.ReportServicePort;
import com.pragma.apireport.infrastructure.entrypoints.dto.EnrollRequest;
import com.pragma.apireport.infrastructure.entrypoints.dto.ReportRequest;
import com.pragma.apireport.infrastructure.entrypoints.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReportHandler {

    private final ReportMapper reportMapper;
    private final ReportServicePort reportServicePort;

    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(ReportRequest.class)
                .map(reportMapper::toDomain)
                .flatMap(reportServicePort::save)
                .map(reportMapper::toResponse)
                .flatMap(dto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(dto));
    }

    public Mono<ServerResponse> enrollPerson(ServerRequest request) {
        Long bootcampId = Long.valueOf(request.pathVariable("bootcampId"));
        return request.bodyToMono(EnrollRequest.class)
                .map(reportMapper::toPersonInfo)
                .flatMap(personInfo -> reportServicePort.enrollPerson(bootcampId, personInfo))
                .map(reportMapper::toResponse)
                .flatMap(dto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(dto));
    }

    public Mono<ServerResponse> findBootcampWithMostEnrolledPersons(ServerRequest request) {
        return reportServicePort.findBootcampWithMostEnrolledPersons()
                .map(reportMapper::toResponse)
                .flatMap(dto -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(dto));
    }
}
