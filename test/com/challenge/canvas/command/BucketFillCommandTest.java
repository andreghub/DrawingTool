/**
 * 
 */
package com.challenge.canvas.command;

import static org.junit.Assert.*;

import org.junit.Test;

import com.challenge.canvas.Canvas;

/**
 * @author andreoliveira
 *
 */
public class BucketFillCommandTest {

	@Test
	public void testRun() {
		Canvas c = new Canvas(10, 10);

		// Draw rectangle in the middle of canvas to test bucket fill
		CanvasCommand cmd = new DrawRectangleCommand(4, 4, 6, 6);
		cmd.run(c);

		// Test Bucket Fill only inside rectangle
		cmd = new BucketFillCommand(5, 5, 'u');
		cmd.run(c);
		assertEquals(c.get(5, 5), 'u');
		assertEquals(c.get(4, 4), 'x');
		assertEquals(c.get(3, 4), ' ');
		
		// Test Bucket Fill only outside rectangle
		cmd = new BucketFillCommand(0, 0, 'h');
		cmd.run(c);
		assertEquals(c.get(4, 4), 'x');
		assertEquals(c.get(0, 0), 'h');
		assertEquals(c.get(9, 9), 'h');
		
		// Test BucketFill out of canvas bounds
		cmd = new DrawRectangleCommand(0, 0, 10, 10);
		try {
			cmd.run(c);
			fail("IllegalArgumentException expected");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

}
