package dev.java10x.EventClean.infra.beans;

import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.useCases.CreateEventUsecase;
import dev.java10x.EventClean.core.useCases.CreateEventUsecaseImpl;
import dev.java10x.EventClean.core.useCases.SearchEventUsecase;
import dev.java10x.EventClean.core.useCases.SearchEventUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUsecase createEventUsecase(EventGateway eventGateway) {
        return new CreateEventUsecaseImpl(eventGateway);

    }

    @Bean
    public SearchEventUsecase searchEventUsecase(EventGateway eventGateway) {
        return new SearchEventUsecaseImpl(eventGateway);
    }
}
