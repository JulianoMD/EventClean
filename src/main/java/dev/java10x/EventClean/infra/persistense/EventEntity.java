package dev.java10x.EventClean.infra.persistense;

import dev.java10x.EventClean.core.enuns.TypeEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String identification;
    private LocalDateTime dataStart;
    private LocalDateTime dataEnd;
    private String venue;
    private int capacity;
    private String organizer;
    private String sponsor;
    @Enumerated(EnumType.STRING)
    private TypeEvent type;

}
