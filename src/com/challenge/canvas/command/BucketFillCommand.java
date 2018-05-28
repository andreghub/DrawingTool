package com.challenge.canvas.command;

import com.challenge.canvas.Canvas;

/**
 * The BucketFillCommand class implements the Bucket Fill command in a character
 *  based 2D canvas which uses a zero-based coordinate system. Should fill the 
 *  entire area connected to (x,y) with "colour" c. The behaviour of this is 
 *  the same as that of the "bucket fill" tool in paint programs.
 *  
 *  Ex: B x y c
 * 
 * @author andreoliveira
 *
 */
public class BucketFillCommand implements CanvasCommand {

	private int x;
	private int y;
	private char c;

	/** 
	 * Initializes the command parameters that will fill the area connected to 
	 * point {@code (x,y)} with "colour" {@code c}.
	*/
	public BucketFillCommand(int x, int y, char c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}

	/** Gets the X coordinate parameter. */
	public int getX() {
		return x;
	}

	/** Sets the {@code x} coordinate parameter. */
	public void setX(int x) {
		this.x = x;
	}

	/** Gets the Y coordinate parameter. */
	public int getY() {
		return y;
	}

	/** Sets the {@code y} coordinate parameter. */
	public void setY(int y) {
		this.y = y;
	}

	/** Gets the filling colour parameter. */
	public char getC() {
		return c;
	}

	/** Sets the {@code 'c'} filling colour parameter. */
	public void setC(char c) {
		this.c = c;
	}

	/** Executes the Bucket Fill command on the provided {@code canvas}. */
	@Override
	public Canvas run(Canvas canvas) {
		if (!canvas.contains(x, y)) {
			throw new IllegalArgumentException("Coordinates are out of canvas bounds.");
		} else {
			return recursiveDraw(canvas, x, y, canvas.get(x, y));
		}
	}

	/** 
	 * Recursively fills the area connected to {@code (x,y)} on the provided 
	 *  {@code canvas}, replacing the {@code oldColor} with the command's 
	 *  {@code 'c'} parameter.  
	*/
	private Canvas recursiveDraw(Canvas canvas, int x, int y, char oldColor) {
		if (canvas.contains(x, y) && canvas.get(x, y) == oldColor) {
			// draw current point
			canvas.set(x, y, c);

			// cover area to the right
			recursiveDraw(canvas, x + 1, y, oldColor);
			// cover area to the left
			recursiveDraw(canvas, x - 1, y, oldColor);
			// cover area up
			recursiveDraw(canvas, x, y + 1, oldColor);
			// cover area down
			recursiveDraw(canvas, x, y - 1, oldColor);
		}

		return canvas;
	}
}
