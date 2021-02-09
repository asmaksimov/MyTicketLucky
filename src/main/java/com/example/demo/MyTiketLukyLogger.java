package com.example.demo;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.JoinPoint;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
@Aspect
public class MyTiketLukyLogger {
	
	File file;
	FileWriter fr;
	
	MyTiketLukyLogger() throws IOException{
		file = new File(".//isMyTicketLucky.csv");
		fr = new FileWriter(file, true);
	}
	
	
	@AfterReturning(pointcut = "execution(public boolean com.example.demo.MyTicketLuckyController.isMyTicketLucky(String))",
			returning="result")
	 public void logMethodExecution(JoinPoint jp, Object result) throws IOException { 
		String tiketNumber = (String) jp.getArgs()[0];
        fr.write(String.format("%s,%s\n",tiketNumber,result.toString()));
        fr.flush();
	 }  
}
