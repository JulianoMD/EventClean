package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;

import java.util.List;

public final class SearchEventCaseImpl implements SearchEventCase {

    private final EventGateway eventGateway;

    public SearchEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.searchEvents();
    }

}
