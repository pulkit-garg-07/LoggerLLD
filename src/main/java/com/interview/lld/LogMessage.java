package com.interview.lld;

import com.interview.lld.Enum.LogLevel;

import java.time.LocalDateTime;

public class LogMessage {
    private final String message;
    private final LocalDateTime timestamp;
    private final LogLevel logLevel;

    public LogMessage(String message, LocalDateTime timestamp, LogLevel level) {
        this.message = message;
        this.timestamp = timestamp;
        this.logLevel = level;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }
}
