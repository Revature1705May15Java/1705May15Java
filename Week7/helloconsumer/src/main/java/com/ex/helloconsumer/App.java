package com.ex.helloconsumer;

import com.ex.helloservice.HelloWorld;
import com.ex.helloservice.HelloWorldImplService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        HelloWorld sei = new HelloWorldImplService().getHelloWorldImplPort();
        sei.sayHi("hey girllllll");
    }
}