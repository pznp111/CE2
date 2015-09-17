import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TextBuddyCE2TDD {
	
	@Before
	public void setUp(){
		TextBuddy.inputfile= "mytextfile.txt";
		
	}
	/*
	@Test
    public void testEmptySearch() throws IOException{
		assertEquals("You have not add task, nothing found",TextBuddy.executeSearch("hw"));
	}
	*/
   /* 
	@Test
	public void testEmptySort(){
		assertEquals("you have not add any task, nothing to sort",TextBuddy.executeSort());
	}
	*/
	
	@Test
	public void testAdd(){
		assertEquals("added to mytextfile.txt: \"little brown fox\"",TextBuddy.executeAdd("little brown fox"));
	}
	
	@Test
	public void testDisplay(){
		assertEquals(true,TextBuddy.executeDisplay(""));
	}
	
	@Test
	public void testNotFoundSearch(){
		assertEquals("nothing found",TextBuddy.executeSearch("hw"));
	}
	
	@Test
	public void testSearch(){
		assertEquals("found, the task is little brown fox",TextBuddy.executeSearch("fox"));
	}
	
	@Test
	public void testSort(){
		assertEquals("task sorted successfully",TextBuddy.executeSort());
	}


}
