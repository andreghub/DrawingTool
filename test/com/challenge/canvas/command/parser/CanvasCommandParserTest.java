/**
 * 
 */
package com.challenge.canvas.command.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import com.challenge.canvas.command.BucketFillCommand;
import com.challenge.canvas.command.CanvasCommand;
import com.challenge.canvas.command.CreateCanvasCommand;
import com.challenge.canvas.command.DrawLineCommand;
import com.challenge.canvas.command.DrawRectangleCommand;

/**
 * @author andreoliveira
 *
 */
public class CanvasCommandParserTest {

	@Test
	public void test() {
		String input = "C 20 4\r\n\r\n" + "L 1 2 6 2\r\n" + "R 16 1 20 3\r\n" + "B 10 3 o\r\n" + "H 1 1 2" + "\r\n\r\n";
		InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

		try (CanvasCommandParser parser = new CanvasCommandParser(stream)) {

			// Test Parsing of Create Canvas Command
			CanvasCommand cmd = parser.nextCommand();
			assertTrue(cmd instanceof CreateCanvasCommand);
			assertEquals(((CreateCanvasCommand) cmd).getWidth(), 20);
			assertEquals(((CreateCanvasCommand) cmd).getHeight(), 4);

			// Test Parsing of Draw Line Canvas Command after blank line
			cmd = parser.nextCommand();
			assertTrue(cmd instanceof DrawLineCommand);
			assertEquals(((DrawLineCommand) cmd).getX1() + 1, 1);
			assertEquals(((DrawLineCommand) cmd).getY1() + 1, 2);
			assertEquals(((DrawLineCommand) cmd).getX2() + 1, 6);
			assertEquals(((DrawLineCommand) cmd).getY2() + 1, 2);

			// Test Parsing of Draw Rectangle Canvas Command
			cmd = parser.nextCommand();
			assertTrue(cmd instanceof DrawRectangleCommand);
			assertEquals(((DrawRectangleCommand) cmd).getX1() + 1, 16);
			assertEquals(((DrawRectangleCommand) cmd).getY1() + 1, 1);
			assertEquals(((DrawRectangleCommand) cmd).getX2() + 1, 20);
			assertEquals(((DrawRectangleCommand) cmd).getY2() + 1, 3);

			// Test Parsing of Bucket Fill Canvas Command
			cmd = parser.nextCommand();
			assertTrue(cmd instanceof BucketFillCommand);
			assertEquals(((BucketFillCommand) cmd).getX() + 1, 10);
			assertEquals(((BucketFillCommand) cmd).getY() + 1, 3);
			assertEquals(((BucketFillCommand) cmd).getC(), 'o');

			// Test Parsing of Invalid Canvas Command
			try {
				cmd = parser.nextCommand();
				fail("UnsupportedOperationException expected");
			} catch (Exception e) {
				assertTrue(e instanceof UnsupportedOperationException);
			}

			// Test End of File behaviour
			cmd = parser.nextCommand();
			assertNull(cmd);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
