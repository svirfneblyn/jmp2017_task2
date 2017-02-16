package com.threads.pull;

import com.threads.process.ProcessThread;

import java.util.ArrayList;
import java.util.List;

import static com.threads.process.IProcessThread.*;

/**
 * Created by Ihar_Rubanovich on 2/15/2017.
 */
public class ThreadsPull {

    public List<ProcessThread> initThreadsPull(int pullsCount) {
        List<Object> syncObjects = new ArrayList<>();
        syncObjects.add(PROCESS_LOCK_1);
        syncObjects.add(PROCESS_LOCK_2);
        syncObjects.add(PROCESS_LOCK_3);
        syncObjects.add(PROCESS_LOCK_4);
        List<ProcessThread> pullThreads = new ArrayList<>();

        // pullThreads.add(new ProcessThread(PROCESS_LOCK_1, PROCESS_LOCK_2));
        // pullThreads.add(new ProcessThread(PROCESS_LOCK_1, PROCESS_LOCK_2));
        if (pullsCount > syncObjects.size()) {
            System.out.println("only 4 threads can be created");
        } else {
            //   int j=0;
            //  int k =3;
            int j = 0;
            int k = 1;
            //   pullThreads.add(new ProcessThread(PROCESS_LOCK_1, PROCESS_LOCK_2));
            //  pullThreads.add(new ProcessThread(PROCESS_LOCK_2, PROCESS_LOCK_1));
            for (int i = 0; i <= pullsCount; i++) {

                pullThreads.add(new ProcessThread(syncObjects.get(j), syncObjects.get(k)));
                j = 1;
                k = 0;
                //j++;
                // --k;
            }


        }
        return getFourThreadsDeadLock(pullThreads);
    }

    public  List<ProcessThread>  getFourThreadsDeadLock(List<ProcessThread> pullThreads) {
        pullThreads.add(new ProcessThread(PROCESS_LOCK_1, PROCESS_LOCK_2));
        pullThreads.add(new ProcessThread(PROCESS_LOCK_2, PROCESS_LOCK_3));
        pullThreads.add(new ProcessThread(PROCESS_LOCK_3, PROCESS_LOCK_4));
        pullThreads.add(new ProcessThread(PROCESS_LOCK_4, PROCESS_LOCK_1));

        return pullThreads;
    }
}
