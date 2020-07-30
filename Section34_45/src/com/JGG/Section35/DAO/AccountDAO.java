package com.JGG.Section35.DAO;

import org.springframework.stereotype.Component;
//321

@Component
public class AccountDAO {
    public void addAccount(){
        System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
