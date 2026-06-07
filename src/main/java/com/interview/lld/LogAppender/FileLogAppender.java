package com.interview.lld.LogAppender;

import com.interview.lld.LogFormatter.LogFormatter;
import com.interview.lld.LogMessage;

public class FileLogAppender extends LogAppender{
    public FileLogAppender(LogFormatter logFormatter) {
        super(logFormatter);
    }

    @Override
    public void update(LogMessage message) {
        System.out.printf("Appending to File: %s%n", this.logFormatter.format(message));
    }
}
