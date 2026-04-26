package com.logpulse.service;

import com.logpulse.model.AlertRule;
import com.logpulse.repository.AlertRuleRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlertRuleService 
{
    private final AlertRuleRepository arr;
    public AlertRuleService(AlertRuleRepository arr)
    {
        this.arr=arr;
    }
    public List<AlertRule> getActiveRules()
    {
        return arr.findByActiveTrue();
    }
    public AlertRule saveRule(AlertRule rule)
    {
       return arr.save(rule);
    }
}
