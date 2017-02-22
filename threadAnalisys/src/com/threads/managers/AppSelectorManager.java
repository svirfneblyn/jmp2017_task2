package com.threads.managers;

import com.threads.ThreadsMain;
import com.threads.process.ProcessThread;
import com.threads.util.AppModeProps;
import com.threads.util.ObjectsCreatorUtil;
import exceptions.IncorrectChoiseException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.threads.process.IProcessThread.*;
import static com.threads.util.DeadLockModeSelectUtil.modeSelect;

/**
 * Created by Ihar_Rubanovich on 2/17/2017.
 */
public class AppSelectorManager {
    private static Logger logger = Logger.getLogger(ThreadsMain.class);
    private static List<Object> objList;

    public void getApp() {
        try {
            String appMode = modeSelect();
            getAppByChoise(appMode);
        } catch (IncorrectChoiseException e) {
            logger.error("incorrect choise ", e);
        }

    }


    public void getAppByChoise(String appMode) {
        AppModeProps selectedMode = AppModeProps.valueOf(appMode.toUpperCase());
        switch (selectedMode) {
            case ONE:
                System.out.println("Selected " + selectedMode + " ");
                startFirstModeDeadLock();
                break;
            case TWO:
                System.out.println("Selected " + selectedMode + " ");
                startSecondModeDeadLock();
                break;
            case THREE:
                System.out.println("Selected " + selectedMode + " ");
                startThirdModeDeadLock();
                break;
            case FOUR:
                System.out.println("Selected " + selectedMode + " ");
                startFourModeDeadLock();
                break;
            case SIX:
                System.out.println("Selected " + selectedMode + " ");
                startOneBillionModeMode();
                break;
            default:
                System.out.println("Entered mode not found . Please  make correct choise...");
                getApp();
                break;
        }

    }

    private void startFirstModeDeadLock() {
        List<ProcessThread> pullThreads = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            pullThreads.add(new ProcessThread(PROCESS_LOCK_1, PROCESS_LOCK_1));
        }
        for (ProcessThread pr : pullThreads) {
            pr.start();
        }
    }

    private void startSecondModeDeadLock() {
        List<ProcessThread> pullThreads = new ArrayList<>();
        pullThreads.add(new ProcessThread(PROCESS_LOCK_1, PROCESS_LOCK_2));
        pullThreads.add(new ProcessThread(PROCESS_LOCK_2, PROCESS_LOCK_1));

        for (ProcessThread pr : pullThreads) {
            pr.start();
        }
    }

    private void startThirdModeDeadLock() {
        List<ProcessThread> pullThreads = new ArrayList<>();
        pullThreads.add(new ProcessThread(PROCESS_LOCK_1, PROCESS_LOCK_2));
        pullThreads.add(new ProcessThread(PROCESS_LOCK_2, PROCESS_LOCK_3));
        pullThreads.add(new ProcessThread(PROCESS_LOCK_3, PROCESS_LOCK_1));

        for (ProcessThread pr : pullThreads) {
            pr.start();
        }
    }

    private void startFourModeDeadLock() {
        List<ProcessThread> pullThreads = new ArrayList<>();
        pullThreads.add(new ProcessThread(PROCESS_LOCK_1, PROCESS_LOCK_2));
        pullThreads.add(new ProcessThread(PROCESS_LOCK_2, PROCESS_LOCK_3));
        pullThreads.add(new ProcessThread(PROCESS_LOCK_3, PROCESS_LOCK_4));
        pullThreads.add(new ProcessThread(PROCESS_LOCK_4, PROCESS_LOCK_1));

        for (ProcessThread pr : pullThreads) {
            pr.start();
        }
    }

    private void startOneBillionModeMode() {
        ObjectsCreatorUtil objectsCreatorUtil = new ObjectsCreatorUtil();
        logger.info("objects created");
        objList = objectsCreatorUtil.createObjects();
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*public void getAppByChoise(int appMode) {
        if (appMode == 6) {
            ObjectsCreatorUtil objectsCreatorUtil = new ObjectsCreatorUtil();
            logger.info("objects created");
            objList = objectsCreatorUtil.createObjects();
            while (true){

            }
        } else {
            List<ProcessThread> pullThreads = new ThreadsPull().initThreadsPull(appMode);
            ThreadsManager tm = new ThreadsManager();
            tm.doThreadLogic(pullThreads);
        }

    }
*/
}
