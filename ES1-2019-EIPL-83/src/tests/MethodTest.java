package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.GUI.Method;
import project.GUI.Rule;

class MethodTest {

	private Method m;

	private ArrayList<Object> objects = new ArrayList<Object>();
	private int id;
	private String inPackage;
	private String inClass;
	private String methodName;
	private int LOC;
	private int CYCLO;
	private int ATFD;
	private double LAA;
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
		id = 4;
		inPackage = "project.GUI";
		inClass = "Method";
		methodName = "name";
		LOC = 5;
		CYCLO = 6;
		ATFD = 7;
		LAA = 8;
		is_long_method = true;
		is_feature_envy = false;
		iPlasma = true;
		PMD = true;
		is_feature_envy = false;

		m = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, ATFD, LAA, is_long_method, iPlasma, PMD,
				is_feature_envy);

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
		for (Object o : objects) {
			o = null;
			assertNull(o);
		}
	}

	@Test
	void testMethod() {
		for (Object o : objects) {
			assertNotNull(o);
		}
	}

	@Test
	void testIsiPlasma() {
		assertEquals(true, m.isiPlasma());
	}

	@Test
	void testSetiPlasma() {
		assertEquals(true, m.isiPlasma());
		m.setiPlasma(false);
		assertEquals(false, m.isiPlasma());
	}

	@Test
	void testIsPMD() {
		assertEquals(true, m.isPMD());
	}

	@Test
	void testSetPMD() {
		assertEquals(PMD, m.isPMD());
		m.setPMD(false);
		assertEquals(false, m.isPMD());
	}

	@Test
	void testGetInPackage() {
		assertEquals(inPackage, m.getInPackage());
	}

	@Test
	void testGetInClass() {
		assertEquals(inClass, m.getInClass());
	}

	@Test
	void testGetMethodName() {
		assertEquals(methodName, m.getMethodName());
	}

	@Test
	void testGetLOC() {
		assertEquals(LOC, m.getLOC());
	}

	@Test
	void testGetCYCLO() {
		assertEquals(CYCLO, m.getCYCLO());
	}

	@Test
	void testGetATFD() {
		assertEquals(ATFD, m.getATFD());
	}

	@Test
	void testGetLAA() {
		assertEquals(LAA, m.getLAA());
	}

	@Test
	void testIsIs_long_method() {
		assertEquals(is_long_method, m.isIs_long_method());
	}

	@Test
	void testIsIs_feature_envy() {
		assertEquals(is_feature_envy, m.isIs_feature_envy());
	}

	@Test
	void testDefaultLongMethod() {
		m = new Method(id, inPackage, inClass, methodName, 81, 11, ATFD, LAA, is_long_method, iPlasma, PMD,
				is_feature_envy);
		assertEquals(true, m.defaultLongMethod());

		m = new Method(id, inPackage, inClass, methodName, 81, 9, ATFD, LAA, is_long_method, iPlasma, PMD,
				is_feature_envy);
		assertEquals(false, m.defaultLongMethod());

		m = new Method(id, inPackage, inClass, methodName, 79, 11, ATFD, LAA, is_long_method, iPlasma, PMD,
				is_feature_envy);
		assertEquals(false, m.defaultLongMethod());
	}

	@Test
	void testDefaultFeatureEnvy() {
		m = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, 5, (float) 0.41, is_long_method, iPlasma, PMD,
				is_feature_envy);
		assertEquals(true, m.defaultFeatureEnvy());

		m = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, 4, (float) 0.41, is_long_method, iPlasma, PMD,
				is_feature_envy);
		assertEquals(false, m.defaultFeatureEnvy());

		m = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, 5, (float) 0.43, is_long_method, iPlasma, PMD,
				is_feature_envy);
		assertEquals(false, m.defaultFeatureEnvy());

	}

	@Test
	void testToString() {
		String s = "id=" + id + ", methodName=" + methodName + ", LOC=" + LOC + ", CYCLO=" + CYCLO + ", ATFD=" + ATFD
				+ ", LAA=" + LAA + ", is_long_method=" + is_long_method + ", iPlasma=" + iPlasma + ", PMD=" + PMD
				+ ", is_feature_envy=" + is_feature_envy;
		assertEquals(s, m.toString());
	}

	@Test
	void testGetId() {
		assertEquals(id, m.getId());
	}

	@Test
	void testSetId() {
		assertEquals(id, m.getId());
		m.setId(10);
		assertEquals(10, m.getId());
	}
	
	@Test
	void test_Calculated() {
		id = 4;
		inPackage = "project.GUI";
		inClass = "Method";
		methodName = "name";
		LOC = 5;
		CYCLO = 6;
		ATFD = 7;
		LAA = 8;
		is_long_method = true;
		is_feature_envy = false;
		iPlasma = true;
		PMD = true;
		is_feature_envy = false;

		m = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, ATFD, LAA, is_long_method, iPlasma, PMD,
				is_feature_envy);
		Rule r1 = new Rule("A", "<=", "<=", "<=", "<=", "OR", "OR");
		Rule r2 = new Rule("A", "<=", "<=", "<=", "<=", "OR", "OR");
		Rule r3 = new Rule("A", ">=", ">=", ">=", ">=", "OR", "OR");
		Rule r4 = new Rule("A", ">", ">", ">", ">", "OR", "OR");
		Rule r5 = new Rule("A", ">", ">", ">", ">", "OR", "OR");
		Rule r6 = new Rule("A", "<", "<", "<", "<", "AND", "AND");
		Rule r7 = new Rule("A", "<", "<", "<", "<", "AND", "AND");
		Method m1 = new Method(2, "", "", "m2", 1, 2, 3, 1, false, false, false, false);
		Method m2 = new Method(2, "", "", "m3", 2, 3, 2, 0, false, false, false, false);
		
		
		r1.setAtfd(4);
		r1.setCyclo(5);
		r1.setLaa(5.0);
		r1.setLoc(4);
		r2.setCyclo(0);
		r2.setAtfd(0);
		r2.setLaa(0);
		r2.setLoc(0);
		r3.setAtfd(500);
		r3.setCyclo(500);
		r3.setLaa(500.0);
		r3.setLoc(988);
		r4.setAtfd(500);
		r4.setCyclo(400);
		r4.setLaa(500.0);
		r4.setLoc(600);
		r5.setAtfd(3);
		r5.setCyclo(5);
		r5.setLaa(5.0);
		r5.setLoc(5);
		r6.setCyclo(1);
		r6.setAtfd(1);
		r6.setLaa((1.0));
		r6.setLoc(1);
		r7.setCyclo(100);
		r7.setAtfd(100);
		r7.setLaa((100.0));
		r7.setLoc(200);
		
		
		m.calculate(r1, "Featury Envy");
		m.calculate(r2, "Feature Envy");
		m.calculate(r3, "Feature Envy");
		m.calculate(r4, "Feature Envy");
		m.calculate(r5, "Feature Envy");
		m.calculate(r6, "Long Method");
		m.calculate(r7, "Long Method");
		m.calculate(r1, "Long Method");
		m1.getCalculatedFeatureEnvy(r1);
		m1.calculate(r1, "Feature Envy");
		m2.getCalculatedLongMethod(r2);
		m2.calculate(r2, "Long Method");
		
		assertEquals(false, m.defaultFeatureEnvy());
		assertEquals(false, m.defaultLongMethod());
		assertEquals("Calculated Feature Envy = false", m1.getCalculatedFeatureEnvy(r1));
		assertEquals("Calculated Long Method = true", m2.getCalculatedLongMethod(r2));
	}

}
