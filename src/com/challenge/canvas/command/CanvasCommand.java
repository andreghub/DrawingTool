package com.challenge.canvas.command;

import com.challenge.canvas.Canvas;

/**
 * The CanvasCommand interface represents a command to be executed on a
 * character based 2D Canvas.
 * 
 * @author andreoliveira
 *
 */
public interface CanvasCommand {

	/** Method that will execute the operation on the provided Canvas ({@code c}) */
	public Canvas run(Canvas c);
}
