package com.pragma.apireport.infrastructure.entrypoints.mapper;

import com.pragma.apireport.domain.model.CapabilityInfo;
import com.pragma.apireport.domain.model.PersonInfo;
import com.pragma.apireport.domain.model.Report;
import com.pragma.apireport.domain.model.TechnologyInfo;
import com.pragma.apireport.infrastructure.entrypoints.dto.EnrollRequest;
import com.pragma.apireport.infrastructure.entrypoints.dto.ReportRequest;
import com.pragma.apireport.infrastructure.entrypoints.dto.ReportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReportMapper {

    Report toDomain(ReportRequest request);

    ReportResponse toResponse(Report report);

    @Mapping(target = "name", source = "personName")
    @Mapping(target = "email", source = "personEmail")
    PersonInfo toPersonInfo(EnrollRequest request);

    CapabilityInfo toCapabilityInfo(ReportRequest.CapabilityInfoDTO dto);
    TechnologyInfo toTechnologyInfo(ReportRequest.TechnologyInfoDTO dto);

    ReportRequest.CapabilityInfoDTO toCapabilityDTO(CapabilityInfo info);
    ReportRequest.TechnologyInfoDTO toTechnologyDTO(TechnologyInfo info);
    ReportResponse.PersonInfoDTO toPersonDTO(PersonInfo info);
}
