package com.pragma.apireport.application.config;

import com.pragma.apireport.domain.spi.ReportPersistencePort;
import com.pragma.apireport.domain.usecase.ReportUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UseCaseConfig {

    private final ReportPersistencePort reportPersistencePort;

    @Bean
    public ReportUseCase reportUseCase() {
        return new ReportUseCase(reportPersistencePort);
    }
}
