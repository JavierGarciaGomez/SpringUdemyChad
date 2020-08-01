package com.JGG.Section43;

import com.JGG.Section43.DAO.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

//342, 345, 348
public class Main {
    public static void main(String[] args) {
        // Read Spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
        // call the method to find the accounts
        //345 Adding try catch
        List<Account> accounts = null;
        try{
            // add a boolean flag to simulate exceptions
            boolean throwException=false;
            accounts = accountDao.findAccounts(throwException);
        } catch (Exception e){
            System.out.println("Exception caught: "+e);
        }

        // display accounts
        System.out.println(accounts);

        context.close();
    }
}
