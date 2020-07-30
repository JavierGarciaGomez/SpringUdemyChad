package com.JGG.Section35.DAO;

import org.springframework.stereotype.Component;
//321

@Component
public class AccountDAO {
    public void addAccount(){
        System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    //325 to test the @before add*
    public void addSillyAccount(){
        System.out.println(getClass()+ ": ADDING A SILLY ACCOUNT");
    }

    public boolean addAccountBoolean(){
        System.out.println("AN ADD ACCOUNT METHOD THAT RETURNS BOOLEAN");
        return false;
    }


}
