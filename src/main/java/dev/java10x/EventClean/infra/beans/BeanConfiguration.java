package dev.java10x.EventClean.infra.beans;

import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.useCases.CreateEventCase;
import dev.java10x.EventClean.core.useCases.CreateEventCaseImpl;
import dev.java10x.EventClean.core.useCases.SearchEventCase;
import dev.java10x.EventClean.core.useCases.SearchEventCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventCase createEventCase(EventGateway eventGateway) {
        return new CreateEventCaseImpl(eventGateway);

    }

    @Bean
    public SearchEventCase searchEventCase(EventGateway eventGateway) {
        return new SearchEventCaseImpl(eventGateway);
    }
}
