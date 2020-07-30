package com.JGG.Section35.DAO;

import com.JGG.Section35.Account;
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

    //328 Parameters
    public void addAccount(Account account){
        System.out.println(account);
    }

    //329 Parameters
    public void addAccount(Account account, boolean vipFlag){
        System.out.println(account);
    }

    //329
    public void doWork(){
        System.out.println(getClass()+"329. Executing doWork");
    }


}
