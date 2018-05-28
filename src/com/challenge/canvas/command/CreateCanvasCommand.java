package com.challenge.canvas.command;

import com.challenge.canvas.Canvas;

/**
 * The CreateCanvasCommand class implements the Create Canvas command in a
 * character based 2D canvas which uses a zero-based coordinate system. It
 * creates a new canvas of width w and height h.
 * 
 * Ex: C w h
 * 
 * @author andreoliveira
 *
 */
public class CreateCanvasCommand implements CanvasCommand {

	private int width;
	private int height;

	/**
	 * Initializes the command parameters that will create a new canvas with width
	 * {@code w} and height {@code h}.
	 */
	public CreateCanvasCommand(int w, int h) {
		this.width = w;
		this.height = h;
	}

	/** Gets the Width command's parameter. */
	public int getWidth() {
		return width;
	}

	/** Sets the {@code width} command's parameter. */
	public void setWidth(int width) {
		this.width = width;
	}

	/** Gets the Height command's parameter. */
	public int getHeight() {
		return height;
	}

	/** Sets the {@code height} command's parameter. */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Executes the Create Canvas command and returns a new instance of a Canvas
	 * with provided width and height.
	 */
	@Override
	public Canvas run(Canvas c) {
		return new Canvas(width, height);
	}

}
