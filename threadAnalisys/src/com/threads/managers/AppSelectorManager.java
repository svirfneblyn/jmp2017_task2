package com.threads.managers;

import com.threads.ThreadsMain;
import com.threads.process.ProcessThread;
import com.threads.pull.ThreadsPull;
import com.threads.util.ObjectsCreatorUtil;
import exceptions.IncorrectChoiseException;
import org.apache.log4j.Logger;

import java.util.List;

import static com.threads.util.DeadLockModeSelectUtil.modeSelect;

/**
 * Created by Ihar_Rubanovich on 2/17/2017.
 */
public class AppSelectorManager {
    private static Logger logger = Logger.getLogger(ThreadsMain.class);
    private static List<Object> objList;
    public void getApp() {
        try {
            int appMode = modeSelect();
            getAppByChoise(appMode);
        } catch (IncorrectChoiseException e)
        {
            logger.error("incorrect choise ", e);
        }

    }
    public void getAppByChoise(int appMode) {
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
}
