package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Random;

import org.junit.Test;

public class WorldTest {

	@Test
	public void testToStringSizeZero() {
		World world = new World(0, 1, 0);
		String result = world.toString();
		assertEquals(result, "  \n");
	}
	
	@Test
	public void testToStringSizeOneDead() {
		World world = new World(1, 1, 0);
		String result = world.toString();
		assertEquals(result, "  0\n0 .\n");
	}
	
	@Test
	public void testToStringSizeOneAlive() {
		World world = new World(1, 1, 100);
		String result = world.toString();
		assertEquals(result, "  0\n0 X\n");
	}
	
	@Test
	public void testToStringColName() {
		World world = new World(20, 1, 100);
		String[] result = world.toString().split("\n");
		assertEquals(result[0], "  01234567890123456789");
	}
	
	@Test
	public void testGetStateRepCalled() {
		Cell cell = mock(Cell.class);
		Cell[][] cells = new Cell[1][1];
		cells[0][0] = cell;
		World world = new World(cells, new Random(1));
		world.toString();
		verify(cell).getStateRep();
	}

}
