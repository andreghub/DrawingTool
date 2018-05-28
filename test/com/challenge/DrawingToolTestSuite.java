package com.challenge;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.challenge.canvas.CanvasTest;
import com.challenge.canvas.command.BucketFillCommandTest;
import com.challenge.canvas.command.CreateCanvasCommandTest;
import com.challenge.canvas.command.DrawLineCommandTest;
import com.challenge.canvas.command.DrawRectangleCommandTest;
import com.challenge.canvas.command.parser.CanvasCommandParserTest;

@RunWith(Suite.class)
@SuiteClasses({ CanvasTest.class, BucketFillCommandTest.class, CreateCanvasCommandTest.class, DrawLineCommandTest.class,
		DrawRectangleCommandTest.class, CanvasCommandParserTest.class })
public class DrawingToolTestSuite {

}
