package dev.java10x.EventClean.infra.presentation;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.useCases.CreateEventUsecase;
import dev.java10x.EventClean.core.useCases.SearchEventUsecase;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.mapper.EventDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto eventDto) {
        Event newEvent = createEventUsecase.execute(mapper.toDomain(eventDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Event created successfully in our database");
        response.put("Event Data: ", mapper.toDto(newEvent));
        return ResponseEntity.ok(response);
    }

    @GetMapping("searchevent")
    public List<EventDto> listEvents() {
        return searchEventUsecase.execute().stream()
                .map(mapper::toDto)
                .toList();

    }



}
