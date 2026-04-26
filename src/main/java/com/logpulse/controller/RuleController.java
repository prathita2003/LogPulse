package com.logpulse.controller;

import com.logpulse.service.AlertRuleService;
import com.logpulse.model.AlertRule;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
@CrossOrigin(origins="*")
public class RuleController 
{
    private final AlertRuleService ars;
    public RuleController(AlertRuleService ars)
    {
        this.ars=ars;
    }
    @PostMapping
    public AlertRule createRule(@RequestBody AlertRule rule)
    {
        return ars.saveRule(rule);
    }
    
    @GetMapping
    public List<AlertRule> getRules()
    {
        return ars.getActiveRules();
    }
}
