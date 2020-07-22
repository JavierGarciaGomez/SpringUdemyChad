package com.JGG;

import java.util.LinkedHashMap;

//
public class Student {
    private String stFirstName;
    private String stLastName;
    //131
    private String country;
    // 132
    private LinkedHashMap<String, String> countryOptions;
    private String countryLoaded;

    public Student() {
        countryOptions=new LinkedHashMap<>();
        countryOptions.put("Germany", "Germany");
        countryOptions.put("France", "France");
        countryOptions.put("Italy", "Italy");
    }

    public String getStFirstName() {
        return stFirstName;
    }

    public void setStFirstName(String stFirstName) {
        this.stFirstName = stFirstName;
    }

    public String getStLastName() {
        return stLastName;
    }

    public void setStLastName(String stLastName) {
        this.stLastName = stLastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public String getCountryLoaded() {
        return countryLoaded;
    }



    public void setCountryLoaded(String countryLoaded) {
        this.countryLoaded = countryLoaded;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stFirstName='" + stFirstName + '\'' +
                ", stLastName='" + stLastName + '\'' +
                ", country='" + country + '\'' +
                ", countryOptions=" + countryOptions +
                ", countryLoaded='" + countryLoaded + '\'' +
                '}';
    }



}

