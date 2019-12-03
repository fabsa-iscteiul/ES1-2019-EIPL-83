package project.GUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		assertNotNull(reader);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		reader = null;
		assertNull(reader);
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
		reader.setMethods(m);
		assertEquals(m, reader.getMethods());
		
	}
	

	@Test
	void testPrintMethods() {
		
		ArrayList<Method> m = new ArrayList<Method>();
		Method method = new Method(2, "stuff", "that", "method", 3, 4, 5, 3, true, true, false, false);
		m.add(method);
		reader.setMethods(m);
		
		assertNotNull(reader.getPathExcel());
		assertEquals(path, reader.getPathExcel());
	
	
//	"Method [id=" + id + ", inPackage=" + inPackage + ", inClass=" + inClass + ", methodName=" + methodName
//	+ ", LOC=" + LOC + ", CYCLO=" + CYCLO + ", ATFD=" + ATFD + ", LAA=" + LAA + ", is_long_method="
//	+ is_long_method + ", iPlasma=" + iPlasma + ", PMD=" + PMD + ", is_feature_envy=" + is_feature_envy
//	+ "]"
	
	}
//
//	@Test
//	void testVectorToMethod() {
//		fail("Not yet implemented");
//	}

}
