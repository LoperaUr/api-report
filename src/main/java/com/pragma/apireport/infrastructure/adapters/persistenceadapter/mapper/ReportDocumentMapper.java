package com.pragma.apireport.infrastructure.adapters.persistenceadapter.mapper;

import com.pragma.apireport.domain.model.Report;
import com.pragma.apireport.infrastructure.adapters.persistenceadapter.entity.ReportDocument;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReportDocumentMapper {

    ReportDocument toDocument(Report report);

    Report toDomain(ReportDocument document);
}
