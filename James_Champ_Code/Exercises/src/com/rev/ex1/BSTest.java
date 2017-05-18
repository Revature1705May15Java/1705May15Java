package com.rev.ex1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BSTest {

	BubbleSort b;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("in setUpBeforeClass()");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("in tearDownAfterClass()");
	}

	@Before
	public void setUp() throws Exception {
		b = new BubbleSort();
		System.out.println("In setuUp()");
	}

	@After
	public void tearDown() throws Exception {
		b = null;
		System.out.println("in tearDown()");
	}

	@Test
	public void test() {
		int[] input = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		int[] actual = BubbleSort.sort(input);
		
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[] input = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] actual = BubbleSort.sort(input);
		
		boolean n = actual == null;
		
		assertFalse(n);
	}
}
