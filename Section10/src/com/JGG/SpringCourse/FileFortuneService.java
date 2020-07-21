package com.JGG.SpringCourse;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    private String fileName = "res\\fortuneStrings.txt";
    private List<String> theFortunes;

    // create a random number generator
    private Random myRandom = new Random();

    //83
    @PostConstruct
    private void readFortune() {
        System.out.println("83 IM in the init method of FileFortune Service");
        File file = new File(fileName);
        theFortunes = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(file))) {
            String tempLine;
            while ((tempLine = br.readLine()) != null) {
                theFortunes.add(tempLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileFortuneService() {
    }

    @Override
    public String getFortune() {
        // pick a random string from the array
        int index = myRandom.nextInt(theFortunes.size());
        String tempFortune = theFortunes.get(index);
        return tempFortune;
    }

}
