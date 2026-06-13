package dev.java10x.EventClean.infra.presentation;

import dev.java10x.EventClean.infra.dtos.EventDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    @PostMapping
    public String createEvent(@RequestBody EventDto event) {
        return "CREATE EVENT";
    }

}
