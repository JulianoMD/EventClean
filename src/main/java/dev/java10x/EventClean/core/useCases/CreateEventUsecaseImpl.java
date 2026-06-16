package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.exceptions.DuplicateEventException;

public class CreateEventUsecaseImpl implements CreateEventUsecase {

    private final EventGateway eventGateway;

    public CreateEventUsecaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        if(eventGateway.existsByIdentification(event.identification())){
            throw new DuplicateEventException("Event with identifier " + event.identification() + " already in use in another event called: " + event.name());
        }
        return eventGateway.createEvent(event);
    }

}
