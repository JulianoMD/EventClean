package dev.java10x.EventClean.infra.gateway;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.infra.persistense.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}
