package com.challenge.canvas;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author andreoliveira
 *
 */
public class CanvasTest {

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorGivenNoDimensions() {
		new Canvas();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorGivenZeroDimension() {
		new Canvas(0, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorGivenNegativeDimension() {
		new Canvas(-1, 10);
	}

	@Test
	public void testContains() {
		Canvas c = new Canvas(10, 10);

		// Test negative coordinates
		assertFalse(c.contains(-1, 1));
		assertFalse(c.contains(1, -1));

		// Test within bounds coordinates
		assertTrue(c.contains(1, 1));
		assertTrue(c.contains(5, 5));
		assertTrue(c.contains(9, 9));

		// Test out of bounds coordinates
		assertFalse(c.contains(10, 10));
	}

	@Test
	public void testGet() {
		Canvas c = new Canvas(10, 10);

		// Test canvas initialization with blank spaces
		assertEquals(c.get(1, 1), ' ');
		assertEquals(c.get(5, 5), ' ');
		assertEquals(c.get(9, 9), ' ');

		// Test a drawn point
		c.set(1, 1, 'x');
		assertEquals(c.get(1, 1), 'x');

		// Test get an invalid position
		try {
			c.get(10, 10);
			fail("IllegalArgumentException expected");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testSet() {
		Canvas c = new Canvas(10, 10);

		// Test draw an 'x' on a specific point
		assertEquals(c.get(1, 1), ' ');
		c.set(1, 1, 'x');
		assertEquals(c.get(1, 1), 'x');

		// Test draw in an invalid position
		try {
			c.set(10, 10, 'x');
			fail("IllegalArgumentException expected");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testToString() {
		int canvasSize = 10;
		Canvas c = new Canvas(canvasSize, canvasSize);

		c.set(0, 0, 'x');
		c.set(1, 0, 'x');
		c.set(9, 9, 'x');

		String output = c.toString();
		// Test output on (0,0)
		assertEquals(output.charAt(canvasSize + 5), 'x');
		
		// Test output on (1,0)
		assertEquals(output.charAt(canvasSize + 6), 'x');
		
		// Test output on (2,0)
		assertEquals(output.charAt(canvasSize + 7), ' ');
		
		// Test output on (9,9)
		assertEquals(output.charAt((canvasSize + 4) * 10 + canvasSize), 'x');
	}

}
