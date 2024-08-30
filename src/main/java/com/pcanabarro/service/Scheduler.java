package com.pcanabarro.service;

import com.pcanabarro.controller.RedirectController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {
    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(cron = "0 0/1 * 1/1 * ?")
    public void redirectsReport() {
        // TODO: Check if it is safe and best option
        log.info("Redirect report {}", RedirectController.redirectList);
        RedirectController.redirectList.clear();
    }
}
