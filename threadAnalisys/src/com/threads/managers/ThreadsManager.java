package com.threads.managers;

import com.threads.process.ProcessThread;

import java.util.List;

/**
 * Created by Ihar_Rubanovich on 2/15/2017.
 */
public class ThreadsManager {

    public void doThreadLogic(List<ProcessThread> pullThreads) {
        int i=0;
        for (ProcessThread thread : pullThreads) {
            thread.setName("THREAD_" + i);
            thread.start();
            i++;
        }
    }
}
