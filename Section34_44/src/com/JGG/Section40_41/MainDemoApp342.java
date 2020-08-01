package com.JGG.Section40_41;

import com.JGG.Section40_41.DAO.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

//342
public class MainDemoApp342 {
    public static void main(String[] args) {
        // Read Spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
        // call the method to find the accounts
        List<Account> accounts = accountDao.findAccounts();
        // display accounts
        System.out.println(accounts);

        context.close();
    }
}
