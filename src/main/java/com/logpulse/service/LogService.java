package com.logpulse.service;

import com.logpulse.model.*;
import com.logpulse.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {

    private final LogRepository lr;
    private final AlertService as;
    private final AlertRepository ar;
    private final AlertRuleService ars;

    public LogService(LogRepository lr,
                      AlertService as,
                      AlertRepository ar,
                      AlertRuleService ars) {
        this.lr = lr;
        this.as = as;
        this.ar = ar;
        this.ars = ars;
    }

    public Log saveLog(Log log) {
        log.setTimestamp(LocalDateTime.now());
        Log savedLog = lr.save(log);
        checkForAlert(savedLog);
        return savedLog;
    }

    private void checkForAlert(Log log) {

        List<AlertRule> rules = ars.getActiveRules();

        for (AlertRule rule : rules) {

            if (rule.getLevel() != log.getLevel()) {
                continue;
            }

            LocalDateTime timeLimit =
                    LocalDateTime.now().minusMinutes(rule.getTimeWindow());

            long count = lr.countByLevelAndTimestampAfter(
                    rule.getLevel(), timeLimit
            );

            if (count >= rule.getThreshold()) {

                List<Alert> recentAlerts =
                        ar.findByLevelAndTimestampAfter(
                                rule.getLevel(), timeLimit
                        );

                if (!recentAlerts.isEmpty()) {
                    continue;
                }

                as.createAlert(
                        "Rule triggered: " + count + " " + rule.getLevel()
                                + " logs in last " + rule.getTimeWindow() + " minute(s)",
                        rule.getLevel()
                );
            }
        }
    }

    public List<Log> getAllLogs() {
        return lr.findAll();
    }

    public List<Log> getLogsByLevel(LogLevel level) {
        return lr.findByLevel(level);
    }

    public List<Log> getLogsByService(String service) {
        return lr.findByService(service);
    }

    public List<Log> getRecentLogs(LocalDateTime time) {
        return lr.findByTimestampAfter(time);
    }
}