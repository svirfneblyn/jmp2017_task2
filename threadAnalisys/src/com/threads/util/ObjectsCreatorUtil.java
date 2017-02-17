package com.threads.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ihar_Rubanovich on 2/17/2017.
 */
public class ObjectsCreatorUtil {
    public List<Object> createObjects() {
        List<Object> millionObjectsList = new ArrayList<>();
        int count = 0;
        while (count < 1000000) {
            millionObjectsList.add(addToList((int) Math.random()));
            count++;
        }return millionObjectsList;
    }

    private List<Object> addToList(Integer iter) {
        List<Object> objList = new ArrayList<>();
        for (int i = 0; i < iter; i++) {
            String stringObj = new String("somestring");
            objList.add(stringObj);
        }
        return objList;
    }
}
