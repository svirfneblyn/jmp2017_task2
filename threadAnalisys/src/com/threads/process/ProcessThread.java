package com.threads.process;

import org.apache.log4j.Logger;


/**
 * Created by Ihar_Rubanovich on 2/15/2017.
 */
public class ProcessThread extends Thread {
    private Object syncObj_1;
    private Object syncObj_2;

    private static Logger logger = Logger.getLogger(ProcessThread.class);

    public ProcessThread(Object sinchObj_1,Object sinchObj_2) {
        this.syncObj_1=sinchObj_1;
        this.syncObj_2 =sinchObj_2;
    }
    public void run() {
        synchronized (syncObj_1) {
            System.out.println(this.getName() + " locked on sinchObj_1" );
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Error catched");
            }
            synchronized (syncObj_2) {

            }
        }
    }
    public void retrievedLOG() throws Exception {
        logger.debug("thread retrievedLOG ");
    }
}
