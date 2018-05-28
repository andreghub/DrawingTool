package com.challenge.canvas.command;

import static org.junit.Assert.*;

import org.junit.Test;

import com.challenge.canvas.Canvas;

/**
 * @author andreoliveira
 *
 */
public class DrawRectangleCommandTest {

	@Test
	public void testRun() {
		Canvas c = new Canvas(10, 10);

		// Test rectangle drawn in the middle of canvas
		DrawRectangleCommand cmd = new DrawRectangleCommand(4, 4, 6, 6);
		cmd.run(c);
		assertEquals(c.get(5, 4), 'x');
		assertEquals(c.get(6, 5), 'x');
		assertEquals(c.get(5, 6), 'x');
		assertEquals(c.get(4, 5), 'x');

		// Test rectangle drawn on canvas bounds
		cmd = new DrawRectangleCommand(0, 0, 9, 9);
		cmd.run(c);
		assertEquals(c.get(5, 0), 'x');
		assertEquals(c.get(9, 5), 'x');
		assertEquals(c.get(5, 9), 'x');
		assertEquals(c.get(0, 5), 'x');
		
		// Test rectangle drawn out of canvas bounds
		cmd = new DrawRectangleCommand(0, 0, 10, 10);
		try {
			cmd.run(c);
			fail("IllegalArgumentException expected");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}

	}

}
