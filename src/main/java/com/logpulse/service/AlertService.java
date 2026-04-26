package com.logpulse.service;

import com.logpulse.model.Alert;
import com.logpulse.model.LogLevel;
import com.logpulse.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public Alert createAlert(String message, LogLevel level) {
        Alert alert = new Alert();
        alert.setMessage(message);
        alert.setLevel(level);
        alert.setTimestamp(LocalDateTime.now());
        return alertRepository.save(alert);
    }
}