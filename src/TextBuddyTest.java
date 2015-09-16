import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;


public class TextBuddyTest {
	
	
	@Before
	public void setUp(){
		TextBuddy.inputfile= "mytextfile.txt";
		
	}
	
	@Test
	public void testAdd(){
		assertEquals("added to mytextfile.txt: \"little brown fox\"",TextBuddy.executeAdd("little brown fox"));
	}
	
	public void testDisplay(){
		assertEquals("add jumped over the moon",TextBuddy.executeDisplay(""));
	}
	
	@Test
	public void testClear(){
		assertEquals("all content deleted from mytextfile.txt",TextBuddy.executeClear());
	}
	
	@Test
	public void testDelete(){
		//TextBuddy.add("add hundreds of ways", file);
		assertEquals("The item you are trying to delete does not exist",TextBuddy.executeDelete("1"));
	}


}
