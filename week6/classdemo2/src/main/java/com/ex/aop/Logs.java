package com.ex.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logs {
	static String filename="src/main/java/com/ex/aop/logs.txt";
	
	@After("execution(String com.ex.repository.CustomerRepositoryImpl.* (..))")
	public void logRepoMethods(){
		LocalDateTime now = LocalDateTime.now();
		write("\nPerforming method!!strings");
	}
	
	@Around("pc()")
	public void doThings(ProceedingJoinPoint pjp){
		LocalDateTime now1=LocalDateTime.now();
		System.out.println("starting method at"+now1);
		
		try {
			pjp.proceed();
			MethodSignature sign = (MethodSignature) pjp.getSignature();
			String paramName= ""+sign.getReturnType();
			String message = "Message with parameter logging";
			write(paramName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		LocalDateTime now2=LocalDateTime.now();
		System.out.println("starting method at"+now2);
		long nano=ChronoUnit.MILLIS.between(now1,now2);
		System.out.println("time between is "+nano);
	}
	
	@Pointcut("execution(String com.ex.repository.CustomerRepositoryImpl.* (..))")
	public void pc(){}
	static void write(String message){
		try(BufferedWriter bw = 
				new BufferedWriter(new FileWriter(filename,true));){
			bw.write(message);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}