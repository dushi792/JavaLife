package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Random;

import org.junit.Test;

public class WorldTest {
	/*
	IDENTIFIER: FUN-TEST-toString-SizeZero
	TEST CASE: Ensure print correctly when size is 0
	INPUT VALUES: Set size = 0, seed = 1, percent = 0
	EXECUTION STEPS: create new world(0, 1, 0), then call toString
	OUTPUT VALUES: output should equals to "  \n"
	*/
	@Test
	public void testToStringSizeZero() {
		World world = new World(0, 1, 0);
		String result = world.toString();
		assertEquals(result, "  \n");
	}
	/*
	IDENTIFIER: FUN-TEST-toString-SizeOne-AllDead
	TEST CASE: Ensure print correct result when size is 1 and the cell is dead
	INPUT VALUES: Set size = 1, seed = 1, percent = 0
	EXECUTION STEPS: create new world(1, 1, 0), then call toString
	OUTPUT VALUES: output should equals to "  0\n0 .\n"
	*/
	@Test
	public void testToStringSizeOneDead() {
		World world = new World(1, 1, 0);
		String result = world.toString();
		assertEquals(result, "  0\n0 .\n");
	}
	/*
	IDENTIFIER: FUN-TEST-toString-SizeOne-AllAlive
	TEST CASE: Ensure print correct result when size is 1 and the cell is alive
	INPUT VALUES: Set size = 1, seed = 1, percent = 100
	EXECUTION STEPS: create new world(1, 1, 100), then call toString
	OUTPUT VALUES: output should equals to "  0\n0 X\n"
	*/
	@Test
	public void testToStringSizeOneAlive() {
		World world = new World(1, 1, 100);
		String result = world.toString();
		assertEquals(result, "  0\n0 X\n");
	}
	/*
	IDENTIFIER: FUN-TEST-toString-ColName
	TEST CASE: Ensure print the correct column name
	INPUT VALUES: Set size = 20, seed = 1, percent = 100
	EXECUTION STEPS: create new world(20, 1, 100), then call toString.split("\n")
	OUTPUT VALUES: output should equals to "  01234567890123456789"
	*/
	@Test
	public void testToStringColName() {
		World world = new World(20, 1, 100);
		String[] result = world.toString().split("\n");
		assertEquals(result[0], "  01234567890123456789");
	}
	/*
	IDENTIFIER: FUN-TEST-toString-CallGetStateRep
	TEST CASE: Ensure the method getStateRep is called in toString
	INPUT VALUES: N/A
	EXECUTION STEPS: mock Cell, then create new World(cells, new Random(1))
	OUTPUT VALUES: getStateRep is called one time
	*/
	@Test
	public void testCallGetStateRep() {
		Cell cell = mock(Cell.class);
		Cell[][] cells = new Cell[1][1];
		cells[0][0] = cell;
		World world = new World(cells, new Random(1));
		world.toString();
		verify(cell).getStateRep();
	}

}
