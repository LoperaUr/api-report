package com.pragma.apireport.infrastructure.entrypoints;

import com.pragma.apireport.infrastructure.entrypoints.handler.ReportHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterRest {

    @Bean
    public RouterFunction<ServerResponse> reportRoutes(ReportHandler handler) {
        return RouterFunctions.route()
                .path("/api/reports", builder -> builder
                        .POST("", handler::save)
                        .GET("/top-bootcamp", handler::findBootcampWithMostEnrolledPersons))
                .build();
    }
}
