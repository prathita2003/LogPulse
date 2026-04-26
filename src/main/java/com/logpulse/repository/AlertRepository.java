package com.logpulse.repository;

import com.logpulse.model.Alert;
import com.logpulse.model.LogLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.*;

public interface AlertRepository extends JpaRepository<Alert,Long> {
    List<Alert> findByLevelAndTimestampAfter(LogLevel level, LocalDateTime time);

}
