package project.GUI;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandlerTest {

	Handler h1, h2, h3;

	protected void setUp() {
		h1 = new Handler();
		h2 = new Handler();
		h3 = new Handler();

	}

	@Test
	void test_BuildObjects() {
		setUp();
		h1.BuildObjects();
		h2.BuildObjects();
		h3.BuildObjects();

	}

	public Method auxiliar() {
		String[] vMethod = new String[] { "2", "Package", "Rule", "Save", "4", "3", "2", "0.12", "true", "true", "true",
				"true" };

		int id = Integer.parseInt(vMethod[0]);
		String inPackage = vMethod[1];
		String inClass = vMethod[2];
		String methodName = vMethod[3];
		int LOC = Integer.parseInt(vMethod[4]);
		int CYCLO = Integer.parseInt(vMethod[5]);
		int ATFD = Integer.parseInt(vMethod[6]);
		float LAA = Float.parseFloat(vMethod[7]);
		boolean is_long_method = Boolean.parseBoolean(vMethod[8]);
		boolean iPlasma = Boolean.parseBoolean(vMethod[9]);
		boolean PMD = Boolean.parseBoolean(vMethod[10]);
		boolean is_feature_envy = Boolean.parseBoolean(vMethod[11]);
		Method method = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, ATFD, LAA, is_long_method, iPlasma,
				PMD, is_feature_envy);
		return method;
	}

	@Test
	void test_getMethods() {
		setUp();
		String[] vMethod = new String[] { "2", "Package", "Rule", "Save", "4", "3", "2", "0.12", "true", "true", "true",
				"true" };
		h1.vectorToMethod(vMethod);
		h2.vectorToMethod(vMethod);
		ArrayList<Method> list1 = h1.getMethods();
		ArrayList<Method> list2 = h2.getMethods();
		ArrayList<Method> list3 = new ArrayList<>();
		list3.add(auxiliar());

	   assertEquals(421, list2.size());
	   assertEquals(421, list1.size());
	

	}

	@Test
	void test_VectorToMecthod() {
		setUp();
		String[] vMethod = new String[] { "2", "Package", "Rule", "Save", "4", "3", "2", "0.12", "true", "true", "true",
				"true" };
		h1.vectorToMethod(vMethod);
		h2.vectorToMethod(vMethod);
		h3.vectorToMethod(vMethod);

	}
	
	public Method auxiliar(String[] args) {
		int id = Integer.parseInt(args[0]);
		String inPackage = args[1];
		String inClass = args[2];
		String methodName = args[3];
		int LOC = Integer.parseInt(args[4]);
		int CYCLO = Integer.parseInt(args[5]);
		int ATFD = Integer.parseInt(args[6]);
		float LAA = Float.parseFloat(args[7]);
		boolean is_long_method = Boolean.parseBoolean(args[8]);
		boolean iPlasma = Boolean.parseBoolean(args[9]);
		boolean PMD = Boolean.parseBoolean(args[10]);
		boolean is_feature_envy = Boolean.parseBoolean(args[11]);
		Method method = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, ATFD, LAA, is_long_method, iPlasma,
				PMD, is_feature_envy);
		return method;
		
	}

	@Test
	void test_ResultsIndicadorPMD_ISPLASMA() {
		setUp();
		String[] vMethod = new String[] { "2", "Package", "Rule", "Save", "4", "3", "2", "0.12", "true", "true", "true",
				"true" };
		String[] vMethod2= new String[] {"2", "Package", "Rule", "Save", "4", "3", "2", "0.12", "true", "true",
				"false", "true"};
		String[] vMethod3= new String[] {"2", "Package", "Rule", "Save", "4", "3", "2", "0.12", "false", "true",
				"true", "true"};
		String[] vMethod4= new String[] {"2", "Package", "Rule", "Save", "4", "3", "2", "0.12", "false", "true",
				"false", "true"};
		
		String[] vMethod5= new String[] {"2", "Package", "Rule", "Save", "4", "3", "2", "0.12", "true", "false",
				"false", "true"};
		
		String[] vMethod6= new String[] {"2", "Package", "Rule", "Save", "4", "3", "2", "0.12", "false", "false",
				"false", "true"};
		
		Method m=auxiliar(vMethod);
		Method m2 =auxiliar(vMethod2);
		Method m3 = auxiliar(vMethod3);
		Method m4 = auxiliar(vMethod4);
		
		Method m5= auxiliar(vMethod5);
		
		Method m6= auxiliar(vMethod6);
		assertEquals("DCI", h1.resultsIndicatorPMD(m));
		assertEquals("ADII", h1.resultsIndicatorPMD(m2));
		assertEquals("DII", h1.resultsIndicatorPMD(m3));
		assertEquals("ADCI", h1.resultsIndicatorPMD(m4));
		
		
		assertEquals("DCI", h1.resultsIndicatorIPlasma(m));
		assertEquals("ADII", h1.resultsIndicatorIPlasma(m5));
		assertEquals("DII", h1.resultsIndicatorIPlasma(m3));
		assertEquals("ADCI", h1.resultsIndicatorIPlasma(m6));

	}
	
	@Test
	void test_compareIplasmaValue() {
		setUp();
		HashMap<Integer, String> hm1=h1.compareIPlasmaValue();
		HashMap<Integer, String>hm2=h2.comparePMDValue();
		assertEquals(hm1.size(), h1.compareIPlasmaValue().size());
		assertEquals(hm2.size(), h2.compareIPlasmaValue().size());
		

	}

}
