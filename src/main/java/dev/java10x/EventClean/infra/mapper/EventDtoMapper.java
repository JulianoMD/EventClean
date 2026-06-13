package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.persistense.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper{

    public EventDto toDto(Event event) {
        return new EventDto(
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

    public Event toDomain(EventDto eventDto) {
        return new Event(
                eventDto.id(),
                eventDto.name(),
                eventDto.description(),
                eventDto.identification(),
                eventDto.dataStart(),
                eventDto.dataEnd(),
                eventDto.venue(),
                eventDto.capacity(),
                eventDto.organizer(),
                eventDto.sponsor(),
                eventDto.type()
        );
    }
}
