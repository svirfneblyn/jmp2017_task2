package com.threads.util;

import exceptions.IncorrectChoiseException;

import java.util.Scanner;

/**
 * Created by Ihar_Rubanovich on 2/17/2017.
 */
public class DeadLockModeSelectUtil {
    public static int modeSelect() throws IncorrectChoiseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please make choise : \n press 1 for mode with 2 threads; \n " +
                "press 2 for mode with 3 threads; \n" +
                "press 3 for mode with 4 threads; \n" +
                "press 4 for mode with 5 threads; \n" +
                "press 6 for create ONE BILLION OBJECTS; \n"
        );
        int choise = sc.nextInt();
        sc.close();
        return choise;
    }

}
