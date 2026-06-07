package com.interview.lld.LogHandler;

import com.interview.lld.Enum.LogLevel;
import com.interview.lld.LogMessage;

public class DebugLogHandler extends LogHandler{
    @Override
    protected boolean canHandle(LogMessage message) {
        return message.getLogLevel().equals(LogLevel.DEBUG);
    }

}
