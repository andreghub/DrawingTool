package com.challenge.canvas.command.parser;

import java.io.InputStream;
import java.util.Scanner;

import com.challenge.canvas.command.CanvasCommand;
import com.challenge.canvas.command.CreateCanvasCommand;
import com.challenge.canvas.command.BucketFillCommand;
import com.challenge.canvas.command.DrawLineCommand;
import com.challenge.canvas.command.DrawRectangleCommand;

/**
 * The CanvasCommandParser class implements a command parser for the Drawing
 * Tool which uses a string stream as input. The current list of commands
 * supported are:
 * 
 * {@code
 * 		C w h					Create Canvas: Should create a new canvas of 
 * 								width w and height h.
 * 
 * 		L x1 y1 x2 y2 			Create Line: Should create a new line from 
 * 								(x1,y1) to (x2,y2). Currently only horizontal
 * 								or vertical lines are supported. Horizontal 
 * 								and vertical lines will be drawn using the 'x'
 * 								character. 
 * 
 * 		R x1 y1 x2 y2 			Create Rectangle: Should create a new 
 * 								rectangle, whose upper left corner is (x1,y1)
 * 								and lower right corner is (x2,y2). Horizontal
 * 								and vertical lines will be drawn using the 'x'
 * 								character. 
 * 
 * 		B x y c 				Bucket Fill: Should fill the entire area 
 * 								connected to (x,y) with "colour" c. The 
 * 								behaviour of this is the same as that of the "bucket fill" tool in paint programs.
 * }
 * 
 * @author andreoliveira
 *
 */
public class CanvasCommandParser implements CommandParser {

	Scanner input = null;

	/**
	 * Initializes the Canvas Command parser with the provided string input stream
	 * {@code in}
	 */
	public CanvasCommandParser(InputStream in) {
		input = new Scanner(in);
	}

	/**
	 * Reads the string input stream until the next non-blank line, then parses the
	 * command based on the definitions. If a command is not valid, it throws an
	 * UnsupportedOperationException. Otherwise, it returns an instance of a
	 * CanvasCommand or null If it reached the end of the input stream.
	 */
	public CanvasCommand nextCommand() {
		if (input != null) {
			String line = "";

			while (line.isEmpty() && input.hasNextLine())
				line = input.nextLine();

			return parseCommand(line);
		} else {
			return null;
		}
	}

	/**
	 * Parses the command based on the definitions. If a command is not valid, it
	 * throws an UnsupportedOperationException. Otherwise, it returns an instance of
	 * a CanvasCommand.
	 */
	private static CanvasCommand parseCommand(String cmd) {
		if (!cmd.isEmpty()) {

			try (Scanner scanner = new Scanner(cmd)) {
				switch (scanner.next()) {
				case "C":
					return new CreateCanvasCommand(scanner.nextInt(), scanner.nextInt());
				case "L":
					return new DrawLineCommand(scanner.nextInt() - 1, scanner.nextInt() - 1, scanner.nextInt() - 1,
							scanner.nextInt() - 1);
				case "R":
					return new DrawRectangleCommand(scanner.nextInt() - 1, scanner.nextInt() - 1, scanner.nextInt() - 1,
							scanner.nextInt() - 1);
				case "B":
					return new BucketFillCommand(scanner.nextInt() - 1, scanner.nextInt() - 1,
							scanner.next(".").charAt(0));
				default:
					throw new UnsupportedOperationException("Command not valid: " + cmd);
				}
			}
		}
		return null;
	}

	/**
	 * Executes stream's resources release and other necessary closing operations.
	 */
	@Override
	public void close() throws Exception {
		if (input != null)
			input.close();
	}
}
