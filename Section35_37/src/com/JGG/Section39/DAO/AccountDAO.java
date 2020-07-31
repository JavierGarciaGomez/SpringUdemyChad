package com.JGG.Section39.DAO;

import com.JGG.Section39.Account;
import org.springframework.stereotype.Component;
//321, 333

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    public void addAccount(){
        System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public String getName() {
        System.out.println(getClass()+": in getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": in setName");
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
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
