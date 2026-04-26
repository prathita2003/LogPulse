package com.logpulse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String service;

    @Enumerated(EnumType.STRING)
    @NotNull
    private LogLevel level;

    @Column(columnDefinition = "TEXT")
    @NotNull
    private String message;

    private LocalDateTime timestamp;
}