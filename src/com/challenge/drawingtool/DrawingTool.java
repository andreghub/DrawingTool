package com.challenge.drawingtool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.challenge.canvas.Canvas;
import com.challenge.canvas.command.CanvasCommand;
import com.challenge.canvas.command.CreateCanvasCommand;
import com.challenge.canvas.command.parser.CanvasCommandParser;
import com.challenge.canvas.command.parser.CommandParser;

/**
 * The DrawingTool class implements a basic Drawing Tool to a Character 2D
 * Canvas. The tool executes a set of commands from the input file and then
 * produces an output file with the result. The current list of commands
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
public final class DrawingTool {

	private static Canvas canvas = null;

	/**
	 * The program reads the input file, executes a set of commands from the file,
	 * step by step, and then produces an output file.
	 * 
	 * @param args
	 *            [0]: the path to the input text file, 
	 *            [1]: the path to the output text file
	 */
	public static void main(String[] args) {
		File inputFile, outputFile;

		try {
			if (args.length < 2) {
				throw new IllegalArgumentException("Please specify valid input and output file names.");
			} else {
				inputFile = new File(args[0]);
				if (!inputFile.exists() || inputFile.isDirectory()) {
					throw new IllegalArgumentException("Input file not found.");
				}

				outputFile = new File(args[1]);
				if (outputFile.isDirectory()) {
					throw new IllegalArgumentException("Output file not found.");
				} else if (!outputFile.exists()) {
					outputFile.createNewFile();
				}
			}

			FileOutputStream out = new FileOutputStream(outputFile);
			try (CommandParser parser = new CanvasCommandParser(new FileInputStream(inputFile));) {
				CanvasCommand cmd = parser.nextCommand();

				while (cmd != null) {

					if (!(cmd instanceof CreateCanvasCommand) && canvas == null) {
						throw new UnsupportedOperationException("Please first create your canvas before drawing.");
					} else {
						try {
							canvas = cmd.run(canvas);
						} catch (Exception e) {
							System.out.println(String.format("Error: %s", e.getMessage()));
						}
					}

					out.write(canvas.toString().getBytes());
					cmd = parser.nextCommand();
				}

			} catch (Exception e) {
				System.out.println(String.format("Error: %s%n", e.getMessage()));
			} finally {
				out.close();
			}

		} catch (Exception e) {
			System.out.println(String.format("Error: %s%n%n%s%n%s", e.getMessage(),
					"Usage reference: drawingtool [inputFilePath] [outputFilePath]",
					" Ex: drawingtool input.txt output.txt", ""));
		}
	}

}
