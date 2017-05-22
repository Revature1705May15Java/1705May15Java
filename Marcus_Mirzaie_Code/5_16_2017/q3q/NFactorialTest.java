package q3q;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NFactorialTest {
	NFactorial nfact;
	@Before
	public void setUp() throws Exception {
		nfact = new NFactorial();
	}

	@After
	public void tearDown() throws Exception {
		nfact = null;
	}

	@Test
	public void test() {
		int input = 5;
		int expected = 120;
		int actual = nfact.nFact(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2(){
		int input = 5;
		boolean actual = (0 == nfact.nFact(input));
		assertFalse(actual);
		
	}
	
	@Test
	public void test3(){
		assertEquals()
	}

}
