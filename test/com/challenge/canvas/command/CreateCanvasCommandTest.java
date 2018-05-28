package com.challenge.canvas.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.challenge.canvas.Canvas;

/**
 * @author andreoliveira
 *
 */
public class CreateCanvasCommandTest {

	@Test
	public void testRun() {
		Canvas c = null;
		
		c = new CreateCanvasCommand(5, 5).run(c);
		
		// Test If canvas is successfully created
		assertNotNull(c);
		
		// Test If canvas is successfully initialized
		assertEquals(c.get(0, 0), ' ');
	}

}
