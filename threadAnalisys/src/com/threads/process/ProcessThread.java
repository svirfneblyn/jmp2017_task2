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
            logger.debug(this.getName() + " locked on 1 synchronized block ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.error("somthing wen wrong ",e);
            }
            synchronized (syncObj_2) {
                logger.debug(this.getName() + " locked on locked on 2 synchronized block");
            }
        }
    }
    public void retrievedLOG() throws Exception {
        logger.debug("thread retrievedLOG ");
    }
}
