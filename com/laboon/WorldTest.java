package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
	public void testToStringColNum() {
		World world = new World(10, 1, 100);
		String[] result = world.toString().split("\n");
		assertEquals(result[0], "  0123456789");
	}

}
