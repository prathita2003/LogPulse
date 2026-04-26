package com.logpulse.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="alert_rules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertRule 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private LogLevel level;
    private int threshold;
    private int timeWindow;
    private boolean active;
}
