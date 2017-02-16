package com.threads.process;

/**
 * Created by Ihar_Rubanovich on 2/14/2017.
 */
public interface IProcessThread {

    public static final Object PROCESS_LOCK_1 = new Object();
    public static final Object PROCESS_LOCK_2 = new Object();
    public static final Object PROCESS_LOCK_3 = new Object();
    public static final Object PROCESS_LOCK_4 = new Object();
    public abstract void setName(String name);
    public abstract String getName();
    public  abstract void start();
    public abstract void doThreadLogic();
}
