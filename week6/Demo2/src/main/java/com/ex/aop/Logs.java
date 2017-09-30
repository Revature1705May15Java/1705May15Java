package com.ex.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logs {
	
	static String filename ="src/main/java/com/ex/aop/logs.txt";
	
//	@Before("execution(* com.ex.repository.CustomerRepositoryImpl.* (..))")
//	public void logRepoMethods(){
//		write("Performing Method\n");
//	}
	
	
	static void write(String message){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){
			bw.write(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Pointcut("execution(* com.ex..* (..))")
	public void pc (){
		
	}
	
	@Around("pc()")
	public void doThings(ProceedingJoinPoint pjp){
		System.out.println("starting method");
		
//		MethodSignature sign = (MethodSignature) pjp.getSignature();
//		
//		String[] paramNames = sign.getParameterNames();
//		String message = "Message with parameters logging";
//		for(String p:paramNames){
//			message = message + ": " + p;
//		}
		long startTime = System.nanoTime();
		
		try{
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ending Method");
		
		long endTime = System.nanoTime();
		System.out.println("That took " + (endTime - startTime) + " nanoseconds");
		
	}
}
