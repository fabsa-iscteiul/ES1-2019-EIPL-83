package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import project.GUI.Method;
import project.GUI.Window;

class WindowTest {

	Window w;

	public void setUp() {
		w = new Window();

	}

	@Test
	public void teste_addContent() {
		setUp();
		w.addContent();

	}

	@Test
	public void teste_Create_new_Rules() {
		setUp();
		w.create_new_rules_user();

	}

	@Test
	public void TestsetLOC_getLOC() {
		setUp();
		w.setLoc(5);
		w.setLoc(5);
		w.setLoc(5);
		assertEquals(5, w.getLoc());
		assertEquals(5, w.getLoc());
		assertEquals(5, w.getLoc());
	}

	@Test
	public void TestsetaAtfd_getAtfd() {
		setUp();
		w.setAtfd(5);
		w.setAtfd(5);
		w.setAtfd(5);
		assertEquals(5, w.getAtfd());
		assertEquals(5, w.getAtfd());
		assertEquals(5, w.getAtfd());
	}

	@Test
	public void TestsetaCyclo_getCyclo() {
		setUp();
		w.setCyclo(5);
		w.setCyclo(5);
		w.setCyclo(5);
		assertEquals(5, w.getCyclo());
		assertEquals(5, w.getCyclo());
		assertEquals(5, w.getCyclo());
	}

	@Test
	public void TestsetaLaa_getLaa() {
		setUp();
		w.setLaa(5.0);
		w.setLaa(5.0);
		w.setLaa(5.0);
		assertEquals(Double.valueOf(5.0), w.getLaa());
		assertEquals(Double.valueOf(5.0), w.getLaa());
		assertEquals(Double.valueOf(5.0), w.getLaa());

	}

	@Test
	public void TestCreate_Feature_envy() {
		setUp();
		int id = 4;
		String inPackage = "project.GUI";
		String inClass = "Method";
		String methodName = "name";
		int LOC = 5;
		int CYCLO = 6;
		int ATFD = 7;
		float LAA = 8;
		boolean is_long_method = true;
		boolean is_feature_envy = false;
		boolean iPlasma = true;
		boolean PMD = true;
		is_feature_envy = false;

		Method m = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, ATFD, LAA, is_long_method, iPlasma, PMD,
				is_feature_envy);
		w.createFeatureEnvy(m);

	}
	
	@Test
	public void TestCreateLongMethod() {
		setUp();
		int id = 4;
		String inPackage = "project.GUI";
		String inClass = "Method";
		String methodName = "name";
		int LOC = 5;
		int CYCLO = 6;
		int ATFD = 7;
		float LAA = 8;
		boolean is_long_method = true;
		boolean is_feature_envy = false;
		boolean iPlasma = true;
		boolean PMD = true;
		is_feature_envy = false;

		Method m = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, ATFD, LAA, is_long_method, iPlasma, PMD,
				is_feature_envy);
		w.createLongMethodWindow(m);

	}
}
