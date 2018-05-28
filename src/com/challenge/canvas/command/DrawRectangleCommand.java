package com.challenge.canvas.command;

import com.challenge.canvas.Canvas;

/**
 * The DrawRectangleCommand class implements the Draw Rectangle command in a
 * character based 2D canvas which uses a zero-based coordinate system. It
 * creates a new rectangle, whose upper left corner is (x1,y1) and lower right
 * corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x'
 * character.
 * 
 * Ex: R x1 y1 x2 y2
 * 
 * @author andreoliveira
 *
 */
public class DrawRectangleCommand implements CanvasCommand {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	/**
	 * Initializes the command parameters that will create a new rectangle whose
	 * upper left corner is {@code (x1,y1)} and lower right corner is
	 * {@code (x2,y2)}.
	 */
	public DrawRectangleCommand(int x1, int y1, int x2, int y2) {
		this.x1 = x1 <= x2 ? x1 : x2;
		this.y1 = y1 <= y2 ? y1 : y2;
		this.x2 = x1 <= x2 ? x2 : x1;
		this.y2 = y1 <= y2 ? y2 : y1;
	}

	/** Gets the X1 coordinate parameter. */
	public int getX1() {
		return x1;
	}

	/** Sets the {@code x1} coordinate parameter. */
	public void setX1(int x1) {
		this.x1 = x1;
	}

	/** Gets the Y1 coordinate parameter. */
	public int getY1() {
		return y1;
	}

	/** Sets the {@code y1} coordinate parameter. */
	public void setY1(int y1) {
		this.y1 = y1;
	}

	/** Gets the X2 coordinate parameter. */
	public int getX2() {
		return x2;
	}

	/** Sets the {@code x2} coordinate parameter. */
	public void setX2(int x2) {
		this.x2 = x2;
	}

	/** Gets the Y2 coordinate parameter. */
	public int getY2() {
		return y2;
	}

	/** Sets the {@code y2} coordinate parameter. */
	public void setY2(int y2) {
		this.y2 = y2;
	}

	/**
	 * Executes the Draw Rectangle command on the provided canvas {@code c}. It
	 * creates a new rectangle whose upper left corner is (x1,y1) and lower right
	 * corner is (x2,y2) using the 'x' character.
	 */
	@Override
	public Canvas run(Canvas c) {
		if (!c.contains(x1, y1) || !c.contains(x2, y2)) {
			throw new IllegalArgumentException("Line is out of canvas bounds.");
		} else {
			DrawLineCommand topLine = new DrawLineCommand(x1, y1, x2, y1);
			DrawLineCommand leftLine = new DrawLineCommand(x1, y1, x1, y2);
			DrawLineCommand rightLine = new DrawLineCommand(x2, y1, x2, y2);
			DrawLineCommand bottomLine = new DrawLineCommand(x1, y2, x2, y2);

			topLine.run(c);
			leftLine.run(c);
			rightLine.run(c);
			bottomLine.run(c);

			return c;
		}

	}

}
