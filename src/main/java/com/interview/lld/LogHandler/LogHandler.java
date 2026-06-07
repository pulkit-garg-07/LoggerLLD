package com.interview.lld.LogHandler;

import com.interview.lld.LogAppender.LogAppender;
import com.interview.lld.LogMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class LogHandler {
    protected LogHandler nextLogHandler;
    protected List<LogAppender> observers;
    public LogHandler(){
        this.observers = new ArrayList<>();
    }
    abstract protected boolean canHandle(LogMessage message);
    public void handle(LogMessage message){
        if (this.canHandle(message))
            this.notifyObservers(message);
        else this.nextLogHandler.handle(message);
    }
    public void addObserver(LogAppender appender){
        this.observers.add(appender);
    }
    protected void notifyObservers(LogMessage message){
        for(LogAppender appender: observers){
            appender.update(message);
        }
    }
    public void setNextLogHandler(LogHandler logHandler){
        this.nextLogHandler = logHandler;
    }

    public LogHandler getNextLogHandler() {
        return nextLogHandler;
    }

    public List<LogAppender> getObservers() {
        return observers;
    }
}
