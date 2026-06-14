package dev.java10x.EventClean.infra.presentation;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.useCases.CreateEventUsecase;
import dev.java10x.EventClean.core.useCases.SearchEventUsecase;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.mapper.EventDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final EventDtoMapper mapper;
    private final CreateEventUsecase createEventUsecase;
    private final SearchEventUsecase searchEventUsecase;

    public EventController(EventDtoMapper mapper, CreateEventUsecase createEventUsecase, SearchEventUsecase searchEventUsecase) {
        this.mapper = mapper;
        this.createEventUsecase = createEventUsecase;
        this.searchEventUsecase = searchEventUsecase;
    }

    @PostMapping("createevent")
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        Event newEvent = createEventUsecase.execute(mapper.toDomain(eventDto));
        return mapper.toDto(newEvent);
    }

    @GetMapping("searchevent")
    public List<EventDto> listEvents() {
        return searchEventUsecase.execute().stream()
                .map(mapper::toDto)
                .toList();

    }



}
