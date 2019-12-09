package tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.GUI.MyActionListener;
import project.GUI.Window;

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
	
	@Test
	void testactionPerfomed() {
		type = "longMethod";
		listener = new MyActionListener(type, window);
	    ActionEvent e = new ActionEvent(new Object(),20,"alinhar");
	    ActionEvent e1 = new ActionEvent(new Object(),20,"Open Excel");
	    ActionEvent e2 = new ActionEvent(new Object(),20,"Featury Envy");
		listener.actionPerformed(e);
		listener.actionPerformed(e1);
		listener.actionPerformed(e2);

	}

}
