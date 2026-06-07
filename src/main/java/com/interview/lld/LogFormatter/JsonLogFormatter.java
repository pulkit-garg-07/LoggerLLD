package com.interview.lld.LogFormatter;

import com.interview.lld.LogMessage;

public class JsonLogFormatter implements LogFormatter{

    @Override
    public String format(LogMessage message) {
        return String.format("{\"message\": %s, \"timestamp\": %s, \"level\": %s}",
                message.getMessage(),
                message.getTimestamp(),
                message.getLogLevel()
        );
    }
}
