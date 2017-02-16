package com.threads;

import com.threads.managers.ThreadsManager;
import com.threads.process.ProcessThread;
import com.threads.pull.ThreadsPull;

import java.util.List;

/**
 * Created by Ihar_Rubanovich on 2/15/2017.
 */
public class ThreadsMain {
    public static void main(String[] args) {
        List<ProcessThread> pullThreads = new ThreadsPull().initThreadsPull(3);
        ThreadsManager tm = new ThreadsManager();
      /*  Thread1 t1 = new Thread1(PROCESS_LOCK_1, PROCESS_LOCK_2);
        Thread2 t2 = new Thread2(PROCESS_LOCK_1, PROCESS_LOCK_2);
        t1.start();
        t2.start();*/
        tm.doThreadLogic(pullThreads);
    }
}
