package dev.java10x.EventClean.core.entities;

import dev.java10x.EventClean.core.enuns.TypeEvent;

import java.time.LocalDateTime;

public record Event(
                    Long id,
                    String name,
                    String description,
                    String identification,
                    LocalDateTime dataStart,
                    LocalDateTime dataEnd,
                    String venue,
                    int capacity,
                    String organizer,
                    String sponsor,
                    TypeEvent type
) {}
