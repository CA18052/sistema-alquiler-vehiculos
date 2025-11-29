package org.proyecto.sav.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DateRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
