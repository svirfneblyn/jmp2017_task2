package com.threads.pull;

import com.threads.process.ProcessThread;

import java.util.ArrayList;
import java.util.List;

import static com.threads.process.IProcessThread.*;

/**
 * Created by Ihar_Rubanovich on 2/15/2017.
 */
public class ThreadsPull {

    public List<ProcessThread> initThreadsPull(int countOfThreads) {
        List<Object> syncObjects = new ArrayList<>();
        syncObjects.add(PROCESS_LOCK_1);
        syncObjects.add(PROCESS_LOCK_2);
        syncObjects.add(PROCESS_LOCK_3);
        syncObjects.add(PROCESS_LOCK_4);
        List<ProcessThread> pullThreads = new ArrayList<>();
        if (countOfThreads > syncObjects.size()) {
            System.out.println("only" + syncObjects.size() + " threads can be created");
        } else {
            for (int i = 0; i <= countOfThreads; i++) {
                pullThreads.add(new ProcessThread(syncObjects.get(i), syncObjects.get(getIndexForThread(countOfThreads, i))));
            }
        }
        return pullThreads;
    }

    /*get index for second synchronized block*/
    public int getIndexForThread(int threadCount, int index) {
        index = ++index;
        if (index > threadCount) {
            index = index - threadCount;
            if (threadCount == 1) {
                index = 0;
            }
        }
        return index;
    }
}
