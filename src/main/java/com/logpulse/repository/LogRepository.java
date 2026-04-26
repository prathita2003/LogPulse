package com.logpulse.repository;

import com.logpulse.model.Log;
import com.logpulse.model.LogLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.*;

public interface LogRepository extends JpaRepository<Log,Long>
{
    List<Log> findByLevel(LogLevel level);
    List<Log> findByService(String service);
    List<Log> findByTimestampAfter(LocalDateTime timestamp);
    List<Log> findByLevelAndService(LogLevel level, String service);
    long countByLevelAndTimestampAfter(LogLevel level, LocalDateTime time);
}
