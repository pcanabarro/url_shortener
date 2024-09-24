package com.pcanabarro.configs;

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

    @Before(value = "execution(* com.pcanabarro.controller.UrlController.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        log.debug("Logging that you're before method " + joinPoint.getSignature().getName());
    }

    // Set here a prefix on errors log using APP_NAME
}
