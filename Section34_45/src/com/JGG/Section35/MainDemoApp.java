package com.JGG.Section35;

import com.JGG.Section35.DAO.AccountDAO;
import com.JGG.Section35.DAO.MembershipDAO;
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

        // close the context
        context.close();
    }
}
