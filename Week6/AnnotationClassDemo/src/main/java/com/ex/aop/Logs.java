package com.ex.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;









@Component
@Aspect
public class Logs {
	
	static String filename="src/main/java/com/ex/aop/logs.txt";
	
//	@Before("pc()")
//	public void logRepoMethods(){
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println("logging");
//		write(now +": Performing repo method\n");
//	}
	
	@Around("pc()")
	public void doThing(ProceedingJoinPoint pjp){
		System.out.println("starting method");
		MethodSignature sign = (MethodSignature) pjp.getSignature();
		String[] paramNames = sign.getParameterNames();
		String message = "Message with parameters logging ";
		for(String p:paramNames){
			message = message + " " + p;
		}
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("ending method");
	}
	
	@Pointcut("execution(* com.ex..* (..))")
	public void pc(){}
	
	
	
	
	
	
	
	
	static void write(String message){
		try(BufferedWriter bw = 
				new BufferedWriter(new FileWriter(filename, true));){
			bw.write(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
