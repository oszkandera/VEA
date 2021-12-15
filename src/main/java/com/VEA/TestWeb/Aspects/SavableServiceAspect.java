package com.VEA.TestWeb.Aspects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SavableServiceAspect
{
    private static final Logger logger = LogManager.getLogger(SavableServiceAspect.class);

    @After(value = "within(com.VEA.TestWeb.Interface.Service.SavableService+) && execution(* save(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Object argument = joinPoint.getArgs()[0];

            String json = mapper.writeValueAsString(argument);
            logger.log(Level.INFO, json);
        }catch (JsonProcessingException e){
            logger.log(Level.INFO, "Error");
        }
    }
}