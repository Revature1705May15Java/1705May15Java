package com.ex.p1;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class FibonacciTest {
	Fibonacci f;
	
	@Before
	public void setUp() throws Exception {
		f=new Fibonacci();
		System.out.println("in setUp()");
	}

	@After
	public void tearDown() throws Exception {
		f=null;
		System.out.println("in tearDown()");
	}

	@Test
	public void test() {
		
		int inputf1=5;
		int[] expectedf1={0,1,1,2,3};
		int[] actualf1=f.Fibonaccis(inputf1);
		assertArrayEquals(expectedf1,actualf1);
		
		int inputf2=9;
		int[] expectedf2={0,1,1,2,3,5,8,13,21};
		int[] actualf2=f.Fibonaccis(inputf2);
		assertArrayEquals(expectedf2,actualf2);

	}

}