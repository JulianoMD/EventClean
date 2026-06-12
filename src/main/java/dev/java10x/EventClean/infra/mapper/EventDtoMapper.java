package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.persistense.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper implements EventMapper{

    @Override
    public EventDto map(EventEntity entity) {
        return new EventDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getIdentification(),
                entity.getDataStart(),
                entity.getDataEnd(),
                entity.getVenue(),
                entity.getCapacity(),
                entity.getOrganizer(),
                entity.getSponsor(),
                entity.getType()
        );
    }

    @Override
    public EventEntity map(EventDto dto) {
        return new EventEntity(
                dto.id(),
                dto.name(),
                dto.description(),
                dto.identification(),
                dto.dataStart(),
                dto.dataEnd(),
                dto.venue(),
                dto.capacity(),
                dto.organizer(),
                dto.sponsor(),
                dto.type()
        );
    }
}
