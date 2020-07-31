package com.JGG.Section35_37;

import com.JGG.Section35_37.DAO.AccountDAO;
import com.JGG.Section35_37.DAO.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        // Read Spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
        // call the business method
        accountDao.addAccount();

        //324: it matches the @before too
        System.out.println("*********324**********");
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addAccount();

        //325: testing @before add*
        System.out.println("*********325**********");
        accountDao.addSillyAccount();

        //326: testing with a return type
        System.out.println("*********326**********");
        accountDao.addAccountBoolean();

        //328.
        System.out.println("\n*********Section 37**********");
        System.out.println("\n*********328**********");
        Account account = new Account();
        account.setName("Javier");
        accountDao.addAccount(account);

        //329
        System.out.println("\n*********329**********");
        Account account2 = new Account("Javier", "35");
        accountDao.addAccount(account, true); // it doesnt execute because of multiple parameters

        //329 executing any parameters
        accountDao.doWork();

        // close the context
        context.close();
    }
}
