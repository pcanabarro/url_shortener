package com.pcanabarro.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {
    private int counter = 0;
    @Scheduled(cron = "0 0/1 * 1/1 * ?")
    public void redirectsReport() {
        counter++;
        System.out.println(counter);
    }
}
