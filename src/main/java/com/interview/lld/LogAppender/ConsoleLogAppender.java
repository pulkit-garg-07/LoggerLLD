package com.interview.lld.LogAppender;

import com.interview.lld.LogFormatter.LogFormatter;
import com.interview.lld.LogMessage;

public class ConsoleLogAppender extends LogAppender{
    public ConsoleLogAppender(LogFormatter logFormatter) {
        super(logFormatter);
    }

    @Override
    public void update(LogMessage message) {
        System.out.println(this.logFormatter.format(message));
    }
}
