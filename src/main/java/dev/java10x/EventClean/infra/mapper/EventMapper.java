package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.persistense.EventEntity;

public interface EventMapper {

    public EventEntity map(EventDto dto);
    public EventDto map(EventEntity entity);
}
