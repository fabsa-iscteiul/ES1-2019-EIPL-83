package project.GUI;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyActionListenerTest {

	MyActionListener listener;
	String type;
	Window window;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		window = new Window();
	}

	@AfterEach
	void tearDown() throws Exception {
		listener = null;
		assertNull(listener);
		}


	@Test
	void testMyActionListener() {
		type = "longMethod";
		listener = new MyActionListener(type, window);
		assertNotNull(listener);
	}

	@Test
	void testActionPerformed() {
		type = "longMethod";
		listener = new MyActionListener(type, window);
		assertNotNull(listener);
		
		type = "feature_envy";
		listener = new MyActionListener(type, window);
		assertNotNull(listener);
		
		type = "open_excel";
		listener = new MyActionListener(type, window);
		assertNotNull(listener);
		
		type = "newRule";
		listener = new MyActionListener(type, window);
//		assertNotNull(listener.actionPerformed())
		
		
	}

}
