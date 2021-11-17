package com.hotmail.kalebmarc.textfighter.player;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SettingsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDifficulty() {
		Settings.setDif("Easy", true, true);
		
		assertEquals("Easy", Settings.getDif());
		
		Settings.setDif("Hard", false, false);
		
		assertEquals("Hard", Settings.getDif());
	}

}
