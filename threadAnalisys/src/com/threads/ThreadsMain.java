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
        List<ProcessThread> pullThreads = new ThreadsPull().initThreadsPull(1);
        ThreadsManager tm = new ThreadsManager();
        tm.doThreadLogic(pullThreads);
    }

}
