package dev.java10x.EventClean.infra.presentation;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.useCases.CreateEventCase;
import dev.java10x.EventClean.core.useCases.SearchEventCase;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.mapper.EventDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final EventDtoMapper eventDtoMapper;
    private final CreateEventCase createEventCase;
    private final SearchEventCase searchEventCase;

    public EventController(EventDtoMapper eventDtoMapper, CreateEventCase createEventCase, SearchEventCase searchEventCase) {
        this.eventDtoMapper = eventDtoMapper;
        this.createEventCase = createEventCase;
        this.searchEventCase = searchEventCase;
    }

    @PostMapping("createevent")
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        Event newEvent = createEventCase.execute(eventDtoMapper.toDomain(eventDto));
        return eventDtoMapper.toDto(newEvent);
    }

    @GetMapping("searchevent")
    public List<EventDto> listEvents() {
        return searchEventCase.execute().stream()
                .map(eventDtoMapper::toDto)
                .toList();

    }



}
