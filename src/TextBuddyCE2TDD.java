import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class TextBuddyCE2TDD {
	
	@Test
    public void testEmptySearch() throws IOException{
		assertEquals("You have not add task, nothing found",TextBuddy.executeCommand("search hw"));
	}
	


}
