import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

public class LetterGradeTest {
	private LetterGrade lgrade;
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		lgrade = new LetterGrade();
		// for testing console output
        System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void tearDown() throws Exception {
	    System.setOut(null);
	}
		
	@Test
	public void testLetterGrade(){
		assertEquals(lgrade.letterGrade(100,100),'A');
		assertEquals(lgrade.letterGrade(0,0),'F');
		assertEquals(lgrade.letterGrade(95,95),'A');
		assertEquals(lgrade.letterGrade(80,80),'B');
		assertEquals(lgrade.letterGrade(70,70),'C');
		assertEquals(lgrade.letterGrade(60,60),'D');
		assertEquals(lgrade.letterGrade(59,59),'F');
	}
	
	@Test(expected = InvalidParameterException.class)
	public void testInvalidInput() {
		assertEquals(lgrade.letterGrade(120, 90),'X');	
		assertEquals(lgrade.letterGrade(1,-50),'X');	
		assertEquals(lgrade.letterGrade(-10,50),'X');	
		assertEquals(lgrade.letterGrade(10,500),'X');	
	}
}
