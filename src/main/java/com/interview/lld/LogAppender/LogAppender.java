package com.interview.lld.LogAppender;

import com.interview.lld.LogFormatter.LogFormatter;
import com.interview.lld.LogMessage;

public abstract class LogAppender {
    protected LogFormatter logFormatter;

    public LogAppender(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    abstract public void update(LogMessage message);

    public void setLogFormatter(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    public LogFormatter getLogFormatter() {
        return logFormatter;
    }
}
