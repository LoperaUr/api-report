package com.pragma.apireport.infrastructure.entrypoints.mapper;

import com.pragma.apireport.domain.model.Report;
import com.pragma.apireport.infrastructure.entrypoints.dto.ReportRequest;
import com.pragma.apireport.infrastructure.entrypoints.dto.ReportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReportMapper {

    Report toDomain(ReportRequest request);

    ReportResponse toResponse(Report report);
}
