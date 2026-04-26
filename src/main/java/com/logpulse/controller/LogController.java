package com.logpulse.controller;

import com.logpulse.model.Log;
import com.logpulse.model.LogLevel;
import com.logpulse.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logs")
@CrossOrigin(origins = "*")
public class LogController {

    private final LogService ls;

    public LogController(LogService ls) {
        this.ls = ls;
    }

    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return ls.saveLog(log);
    }

    @GetMapping
    public List<Log> getLogs(
            @RequestParam(required = false) LogLevel level,
            @RequestParam(required = false) String service
    ) {

        if (level != null && service != null) {
            return ls.getLogsByLevel(level)
                    .stream()
                    .filter(log -> log.getService().equalsIgnoreCase(service))
                    .toList();
        }

        if (level != null) {
            return ls.getLogsByLevel(level);
        }

        if (service != null) {
            return ls.getLogsByService(service);
        }

        return ls.getAllLogs();
    }

    @GetMapping("/recent")
    public List<Log> getRecentLogs(@RequestParam String time) {
        LocalDateTime timestamp = LocalDateTime.parse(time);
        return ls.getRecentLogs(timestamp);
    }
    @DeleteMapping("/{id}")
        public String deleteLog(@PathVariable Long id) {
        ls.deleteLog(id);
        return "Log deleted successfully!";
    }
}