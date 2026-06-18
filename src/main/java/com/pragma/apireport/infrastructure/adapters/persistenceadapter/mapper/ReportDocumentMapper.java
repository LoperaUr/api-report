package com.pragma.apireport.infrastructure.adapters.persistenceadapter.mapper;

import com.pragma.apireport.domain.model.CapabilityInfo;
import com.pragma.apireport.domain.model.PersonInfo;
import com.pragma.apireport.domain.model.Report;
import com.pragma.apireport.domain.model.TechnologyInfo;
import com.pragma.apireport.infrastructure.adapters.persistenceadapter.entity.ReportDocument;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReportDocumentMapper {

    ReportDocument toDocument(Report report);

    Report toDomain(ReportDocument document);

    ReportDocument.CapabilityInfoDocument toCapabilityDoc(CapabilityInfo info);
    CapabilityInfo toCapabilityDomain(ReportDocument.CapabilityInfoDocument doc);

    ReportDocument.TechnologyInfoDocument toTechnologyDoc(TechnologyInfo info);
    TechnologyInfo toTechnologyDomain(ReportDocument.TechnologyInfoDocument doc);

    ReportDocument.PersonInfoDocument toPersonDoc(PersonInfo info);
    PersonInfo toPersonDomain(ReportDocument.PersonInfoDocument doc);
}
