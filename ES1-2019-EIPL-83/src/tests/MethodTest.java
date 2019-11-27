package tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.GUI.Method;

class MethodTest {
	
	private Method m;
	
	ArrayList<Object> objects = new ArrayList<Object>();
	private double id;
	private String inPackage;
	private String inClass;
	private String methodName;
	private double LOC;
	private double CYCLO;
	private double ATFD;
	private float LAA;
	private boolean is_long_method;
	private boolean iPlasma;
	private boolean PMD;
	private boolean is_feature_envy;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		m = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, ATFD, LAA, is_long_method, iPlasma, PMD, is_feature_envy);
		objects.add(id);
		objects.add(inPackage);
		objects.add(inClass);
		objects.add(methodName);
		objects.add(LOC);
		objects.add(CYCLO);
		objects.add(ATFD);
		objects.add(LAA);
		objects.add(is_long_method);
		objects.add(iPlasma);
		objects.add(PMD);
		objects.add(is_feature_envy);
	}

	@AfterEach
	void tearDown() throws Exception {
		m = null;
	}

	@Test
	void testMethod() {
		for(Object o: objects) { 
			assertNotNull(o);
		}
	}

	@Test
	void testIsiPlasma() {
		
	}

	@Test
	void testSetiPlasma() {
		fail("Not yet implemented");
	}

	@Test
	void testIsPMD() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPMD() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInPackage() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInClass() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMethodName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLOC() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCYCLO() {
		fail("Not yet implemented");
	}

	@Test
	void testGetATFD() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLAA() {
		fail("Not yet implemented");
	}

	@Test
	void testIsIs_long_method() {
		fail("Not yet implemented");
	}

	@Test
	void testIsIs_feature_envy() {
		fail("Not yet implemented");
	}

	@Test
	void testDefaultLongMethod() {
		fail("Not yet implemented");
	}

	@Test
	void testDefaultFeatureEnvy() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testGetId() {
		fail("Not yet implemented");
	}

	@Test
	void testSetId() {
		fail("Not yet implemented");
	}

	@Test
	void testObject() {
		fail("Not yet implemented");
	}

	@Test
	void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	void testClone() {
		fail("Not yet implemented");
	}

	@Test
	void testToString1() {
		fail("Not yet implemented");
	}

	@Test
	void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	void testWait() {
		fail("Not yet implemented");
	}

	@Test
	void testFinalize() {
		fail("Not yet implemented");
	}

}
