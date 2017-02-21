package com.threads.mbeans;

/**
 * Created by Ihar_Rubanovich on 2/17/2017.
 */
public interface JMXDemoMBean {
    public void add(String str);
    public String show();
    public String getName();
    public void setName();
}
