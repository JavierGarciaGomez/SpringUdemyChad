package com.JGG.Section40_41;

import com.JGG.Section40_41.DAO.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        // Read Spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
        // call the business method
        accountDao.setName("Javier");
        accountDao.addAccount();

        // close the context
        context.close();
    }
}
