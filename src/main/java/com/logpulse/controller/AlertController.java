package com.logpulse.controller;

import com.logpulse.model.Alert;
import com.logpulse.repository.LogRepository;
import com.logpulse.repository.AlertRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/alerts")
@CrossOrigin(origins="*")
public class AlertController 
{
    private final AlertRepository ar;
    public AlertController(AlertRepository ar)
    {
        this.ar=ar;
    }
    @GetMapping
    public List<Alert> getAlerts()
    {
        return ar.findAll();
    }
}
