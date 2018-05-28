/**
 * 
 */
package com.challenge.canvas.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.challenge.canvas.Canvas;

/**
 * @author andreoliveira
 *
 */
public class DrawLineCommandTest {

	@Test
	public void testRun() {
		Canvas c = new Canvas(10, 10);

		// Test vertical line
		DrawLineCommand cmd = new DrawLineCommand(0, 0, 0, 5);
		assertEquals(c.get(0, 0), ' ');
		cmd.run(c);
		assertEquals(c.get(0, 0), 'x');
		assertEquals(c.get(0, 2), 'x');
		assertEquals(c.get(0, 5), 'x');
		assertEquals(c.get(0, 6), ' ');

		// Test horizontal line
		cmd = new DrawLineCommand(5, 5, 8, 5);
		assertEquals(c.get(5, 5), ' ');
		cmd.run(c);
		assertEquals(c.get(5, 5), 'x');
		assertEquals(c.get(7, 5), 'x');
		assertEquals(c.get(8, 5), 'x');
		assertEquals(c.get(9, 5), ' ');

		// Test diagonal line (not supported)
		try {
			cmd = new DrawLineCommand(0, 0, 5, 5);
			cmd.run(c);
			fail("IllegalArgumentException expected");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}

	}

}
