package com.threads.mbeans;

/**
 * Created by Ihar_Rubanovich on 2/17/2017.
 */
public class MBean implements IMBean {
    private final String name = "Algerd the Great";
    @Override
    public void sayHello() {
        System.out.println(" ----- HELLO fhjm MBEAN");
    }

    @Override
    public int add(int x, int y) {
        return x+y;
    }

    @Override
    public String getName() {
        return name;
    }
}
