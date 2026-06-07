package com.interview.lld;




public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyLogger logger = MyLogger.getInstance();
        Thread t1 = new Thread(()->{
            for(int i=0;i<100;i++)
                logger.info("this is t1 message");
        });
        Thread t2 = new Thread(()->{
            for(int i=0;i<100;i++)
                logger.info("this is t2 message");

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
