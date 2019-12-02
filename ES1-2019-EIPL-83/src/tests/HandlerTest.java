package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.GUI.Handler;

class HandlerTest {
	
	Handler h;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		h = new Handler();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHandler() {
		h.BuildObjects();
		assertNotNull(h.getMethods());
		assertNotNull(h.methodsName());
	}
}
