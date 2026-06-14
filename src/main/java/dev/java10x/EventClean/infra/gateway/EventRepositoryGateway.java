package dev.java10x.EventClean.infra.gateway;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.infra.mapper.EventEntityMapper;
import dev.java10x.EventClean.infra.persistense.EventEntity;
import dev.java10x.EventClean.infra.persistense.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    @Override
    public Event createEvent(Event event) {
        EventEntity entity = eventRepository.save(eventEntityMapper.toEntity(event));
        return eventEntityMapper.toDomain(entity);
    }

    @Override
    public List<Event> searchEvents() {
        List<Event> listEvent = eventRepository.findAll().stream()
                .map(eventEntityMapper::toDomain)
                .toList();
        return listEvent;
    }
}
