package com.interview.lld;

import com.interview.lld.Enum.LogLevel;
import com.interview.lld.LogAppender.ConsoleLogAppender;
import com.interview.lld.LogAppender.FileLogAppender;
import com.interview.lld.LogFormatter.JsonLogFormatter;
import com.interview.lld.LogFormatter.SimpleTextLogFormatter;
import com.interview.lld.LogHandler.*;

import java.time.LocalDateTime;

public class MyLogger {
    private static MyLogger INSTANCE;
    private final LogHandler logHandlerChain;
    private MyLogger(){
        LogHandler debugLogHandler = new DebugLogHandler();
        LogHandler infoLogHandler = new InfoLogHandler();
        LogHandler warnLogHandler = new WarnLogHandler();
        LogHandler errorLogHandler = new ErrorLogHandler();
        debugLogHandler.setNextLogHandler(infoLogHandler);
        infoLogHandler.setNextLogHandler(warnLogHandler);
        warnLogHandler.setNextLogHandler(errorLogHandler);
        logHandlerChain = debugLogHandler;
        debugLogHandler.addObserver(new ConsoleLogAppender(new SimpleTextLogFormatter()));
        infoLogHandler.addObserver(new ConsoleLogAppender(new SimpleTextLogFormatter()));
        warnLogHandler.addObserver(new ConsoleLogAppender(new SimpleTextLogFormatter()));
        warnLogHandler.addObserver(new FileLogAppender(new SimpleTextLogFormatter()));
        errorLogHandler.addObserver(new ConsoleLogAppender(new SimpleTextLogFormatter()));
        errorLogHandler.addObserver(new FileLogAppender(new JsonLogFormatter()));
    }
    public static MyLogger getInstance(){
        if (INSTANCE==null){
            synchronized (MyLogger.class){
                if(INSTANCE==null){
                    INSTANCE = new MyLogger();
                }
            }
        }
        return INSTANCE;
    }
    public void debug(String message){
        LogMessage logMessage = new LogMessage(message, LocalDateTime.now(), LogLevel.DEBUG);
        this.logHandlerChain.handle(logMessage);
    }
    public void info(String message){
        LogMessage logMessage = new LogMessage(message, LocalDateTime.now(), LogLevel.INFO);
        this.logHandlerChain.handle(logMessage);
    }
    public void warn(String message){
        LogMessage logMessage = new LogMessage(message, LocalDateTime.now(), LogLevel.WARN);
        this.logHandlerChain.handle(logMessage);
    }
    public void error(String message){
        LogMessage logMessage = new LogMessage(message, LocalDateTime.now(), LogLevel.ERROR);
        this.logHandlerChain.handle(logMessage);
    }
}
