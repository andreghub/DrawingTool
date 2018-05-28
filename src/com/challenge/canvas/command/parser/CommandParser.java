package com.challenge.canvas.command.parser;

import com.challenge.canvas.command.CanvasCommand;

/**
 * The CommandParser interface represents a simple command parser for the
 * Drawing Tool.
 * 
 * @author andreoliveira
 *
 */
public interface CommandParser extends AutoCloseable {

	/**
	 * Reads the input stream and should return an instance of a CanvasCommand or
	 * null If it reached the end of the input stream.
	 */
	public CanvasCommand nextCommand();
}
