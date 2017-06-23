package com.ex.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect 
public class Log 
{
	static String filename = "src/com/ex/aop/log.txt"; 
	
	static void write(String message)
	{
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true)))
		{
			writer.write(message);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Before("execution(* com.ex.repository.CustomerRepoImpl.* (..))")
//	@After("execution (* com.ex.repository.CustomerRepoImpl.* (..))")
	public void logRepoMethods()
	{
		write("performing method"); 
	}
}
