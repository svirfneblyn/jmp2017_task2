package com.threads;

import com.threads.managers.AppSelectorManager;
import com.threads.mbeans.JMXDemo;
import com.threads.mbeans.JMXDemoMBean;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.management.*;
import java.lang.management.ManagementFactory;


/**
 * Created by Ihar_Rubanovich on 2/15/2017.
 */
public class ThreadsMain {
    public static final String LOG4J_PATH = "D:/JMP2017]/jmp2017_task2/threadAnalisys/props/log4jprops/threads_log4j.xml";
    private static Logger logger = Logger.getLogger(ThreadsMain.class);

    public static void main(String[] args) {
        initLog4j();
       // initMbean();
        AppSelectorManager appsel = new AppSelectorManager();
        appsel.getApp();


    }

    private static void initLog4j() {
        BasicConfigurator.configure();
        DOMConfigurator.configure(LOG4J_PATH);
        logger.info("-------------application running-----------------");
    }

    private static void initMbean() {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        JMXDemoMBean mbean = new JMXDemo();
        mbean.add("1");
        mbean.add("some text");
        try {
            ObjectName name = new ObjectName("com.threads.mbeans:type=JMXDemo");
            System.out.println("name is " + name.getCanonicalName());
            System.out.println(mbean.getClass().getName());
            mbs.registerMBean(mbean, name);
        } catch (InstanceAlreadyExistsException | MalformedObjectNameException | NotCompliantMBeanException | MBeanRegistrationException e) {
            logger.error(" MBEAN exception");
            e.getMessage();
            e.printStackTrace();

        }
    }
}