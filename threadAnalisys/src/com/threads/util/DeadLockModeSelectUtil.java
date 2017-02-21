package com.threads.util;

import exceptions.IncorrectChoiseException;

import java.util.Scanner;

/**
 * Created by Ihar_Rubanovich on 2/17/2017.
 */
public class DeadLockModeSelectUtil {

    public static String modeSelect() throws IncorrectChoiseException {

        System.out.println("Please make choise : \n type ONE for mode with 2 threads; \n " +
                "type TWO for mode with 3 threads; \n" +
                "type THREE for mode with 4 threads; \n" +
                "type FOUR for mode with 5 threads; \n" +
                "type SIX for create ONE BILLION OBJECTS; \n"
        );
        Scanner sc = null;

        String choiseString = null;
        try {
            sc = new Scanner(System.in);
            choiseString = sc.next();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        return choiseString;
    }

}
