package com.logpulse.repository;

import com.logpulse.model.AlertRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;
public interface AlertRuleRepository extends JpaRepository<AlertRule, Long>
{
    List<AlertRule> findByActiveTrue();
}
