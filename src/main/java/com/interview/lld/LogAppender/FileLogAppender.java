package com.interview.lld.LogAppender;

import com.interview.lld.LogFormatter.LogFormatter;
import com.interview.lld.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogAppender extends LogAppender{
    final BufferedWriter writer;
    public FileLogAppender(LogFormatter logFormatter, String filepath)  {
        super(logFormatter);
        try {
            this.writer = new BufferedWriter(new FileWriter(filepath, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(LogMessage message) {

            try {
                synchronized (writer) {
                    writer.write(this.logFormatter.format(message));
                    writer.newLine();
                    writer.flush();
                }

            }
            catch(IOException e){
                System.err.println("Error while writing to log file: "+ e.getMessage());
            }

    }
}
