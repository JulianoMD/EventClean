package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entities.Event;

import java.util.List;

public interface EventGateway {

    Event createEvent(Event event);

    List<Event> searchEvents();
}
