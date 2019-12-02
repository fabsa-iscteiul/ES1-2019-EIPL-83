package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.GUI.Method;
import project.GUI.ReadExcel;

class ReadExcelTest {
	
	ReadExcel reader;
	String path = "/home/tomas/git/ES1-2019-EIPL-83/ES1-2019-EIPL-83/src/DataEs1.csv";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		reader = new ReadExcel(path);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		reader = null;
	}

	@Test
	void testReadExcel() {
		
	
	}


	@Test
	void testGetPath() {
		assertNotNull(reader.getPathExcel());
		assertEquals(path, reader.getPathExcel());
	}
	

	@Test
	void testSetMethods() {
		ArrayList<Method> m = new ArrayList<Method>();
		Method method = new Method(2, "stuff", "that", "method", 3, 4, 5, 3, true, true, false, false);
		m.add(method);
		assertNotNull(reader.getMethods());
	}
//
//	@Test
//	void testVectorToMethod() {
//		fail("Not yet implemented");
//	}

}
