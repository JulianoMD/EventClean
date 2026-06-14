package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.infra.persistense.EventEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventEntityMapper {

    public EventEntity toEntity(Event event) {
        return new EventEntity(
            event.id(),
            event.name(),
            event.description(),
            event.identification(),
            event.dataStart(),
            event.dataEnd(),
            event.venue(),
            event.capacity(),
            event.organizer(),
            event.sponsor(),
            event.type()
        );
    }

    public Event toDomain(EventEntity eventEntity) {
        return new Event(
            eventEntity.getId(),
            eventEntity.getName(),
            eventEntity.getDescription(),
            eventEntity.getIdentification(),
            eventEntity.getDataStart(),
            eventEntity.getDataEnd(),
            eventEntity.getVenue(),
            eventEntity.getCapacity(),
            eventEntity.getOrganizer(),
            eventEntity.getSponsor(),
            eventEntity.getType()
        );
    }
}
