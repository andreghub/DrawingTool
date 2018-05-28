package com.challenge.canvas;

/**
 * The Canvas class represents a character based 2D canvas which uses a zero-based coordinate system.
 * 
 * @author andreoliveira
 *
 */
public class Canvas {

	private char[][] canvas;

	/** Default constructor: Canvas Dimensions is enforced */
	public Canvas() {
		throw new IllegalArgumentException("Please provide Canvas dimensions.");
	}
	
	/** Parameterized constructor: Creates a canvas with provided dimensions (width,height) */
	public Canvas(int width, int height) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Canvas width and height must be greater than 0.");
		}

		canvas = new char[height][width];

		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				canvas[i][j] = ' ';
			}
		}
	}

	/** Validates If coordinates {@code (x,y)} belongs to the zero-based 2D Canvas plan */
	public boolean contains(int x, int y) {
		if (x >= 0 && y >= 0 && x < canvas[0].length && y < canvas.length) {
			return true;
		} else {
			return false;
		}
	}

	/** Gets the character at Canvas position {@code (x,y)} */
	public char get(int x, int y) {
		if (!contains(x, y)) {
			throw new IllegalArgumentException("Coordinates must be positive values within canvas dimensions.");
		}

		return canvas[y][x];
	}

	/** Sets the character {@code (c)} at position {@code (x,y)} */
	public void set(int x, int y, char c) {
		if (!contains(x, y)) {
			throw new IllegalArgumentException("Coordinates must be positive values within canvas dimensions.");
		}

		canvas[y][x] = c;
	}

	/** Generate a string representation of the 2D Character Canvas */
	public String toString() {
		StringBuilder output = new StringBuilder();
		StringBuilder horizontalLine = new StringBuilder();

		for (int i = 0; i < canvas[0].length+2; i++) {
			horizontalLine.append("-");
		}

		output.append(String.format("%s%n", horizontalLine));
		
		for (int i = 0; i < canvas.length; i++) {
			output.append(String.format("%s%s%s%n", "|", String.valueOf(canvas[i]), "|"));
		}
		
		output.append(String.format("%s%n", horizontalLine));
		
		return output.toString();
	}

}
