package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.enuns.TypeEvent;
import dev.java10x.EventClean.infra.persistense.EventEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventEntityMapper {

   /*     private Long id;
    private String name;
    private String description;
    private String identification;
    private LocalDateTime dataStart;
    private LocalDateTime dataEnd;
    private String venue;
    private int capacity;
    private String organizer;
    private String sponsor;
    @Enumerated(EnumType.STRING)
    private TypeEvent type;*/

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
