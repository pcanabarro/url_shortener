package com.pcanabarro.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {
    Logger log = LoggerFactory.getLogger(getClass());

    @Before(value = "execution(* com.pcanabarro.controller.RedirectController.getShortcut(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Logging that you're been redirected");
    }

    // Set here a prefix on errors log using APP_NAME
}
