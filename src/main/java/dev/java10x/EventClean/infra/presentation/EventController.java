package dev.java10x.EventClean.infra.presentation;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.useCases.CreateEventCase;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.mapper.EventDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final CreateEventCase createEventCase;
    private final EventDtoMapper eventDtoMapper;

    public EventController(CreateEventCase createEventCase, EventDtoMapper eventDtoMapper) {
        this.createEventCase = createEventCase;
        this.eventDtoMapper = eventDtoMapper;
    }

    @PostMapping("createevent")
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        Event newEvent = createEventCase.execute(eventDtoMapper.toDomain(eventDto));
        return eventDtoMapper.toDto(newEvent);
    }

    @GetMapping("searchevent")
    public String listEvents() {
        return "Listing all events";
    }



}
