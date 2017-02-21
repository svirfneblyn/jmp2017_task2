package com.threads.mbeans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ihar_Rubanovich on 2/17/2017.
 */
public class JMXDemo implements JMXDemoMBean {
    private List<String> list = new ArrayList<String>();
    private String someName ="SOME NAME IN THE BEAN";

    @Override
    public void add(String str) {
        list.add(str);
    }

    @Override
    public String getName() {

        return someName;
    }

    @Override
    public void setName() {
        someName = "NEW VALUE FOR NAME";
    }

    @Override
    public String show() {
        String listString = new String();
        for (String str : list) {
            listString = listString + " " + str;
        }
        return listString;
    }


}