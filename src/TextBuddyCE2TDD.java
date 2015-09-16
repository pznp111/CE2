import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TextBuddyCE2TDD {
	
	@Before
	public void setUp(){
		TextBuddy.inputfile= "mytextfile.txt";
		
	}
	
	@Test
    public void testEmptySearch() throws IOException{
		assertEquals("You have not add task, nothing found",TextBuddy.executeSearch("hw"));
	}
	


}
