package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import project.GUI.Rule;

class RuleTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	Rule r1, r2, r3, r4, r5, r6, r7, r8;
	int loc = 0, atfd = 0, cyclo = 0;
	double laa = 0;

	protected void setUp() {
		r1 = new Rule("A", "<=", "<=", "<=", "<=", "OR", "OR");
		r2 = new Rule("B", ">=", ">=", ">=", ">=", "OR", "AND");
		r3 = new Rule("C", "<=", "<=", "<=", "<=", "AND", "OR");
		r4 = new Rule("D", ">=", ">=", ">=", ">=", "AND", "AND");
		r5 = new Rule("E", "<=", ">=", ">=", ">=", "OR", "OR");
		r6 = new Rule("F", "<=", ">=", "<=", ">=", "AND", "AND");
		r7 = new Rule("G", "<=", "<=", ">=", "<=", "OR", "AND");
		r8 = new Rule("H", "<=", "<=", "<=", "<=", "AND", "OR");
		loc = 0;
		atfd = 0;
		cyclo = 0;
		laa = 0;

	}

	@Test
	final void testRule() {

		setUp();

		Rule r = new Rule("H", "<=", "<=", "<=", "<=", "AND", "OR");
		Assert.assertNotEquals(r, r8);

	}

	@Test
	final void testSetLoc() {
		System.out.println("setLoc");
		int loc = 10;
		Rule instance = new Rule("A", "<=", "<=", "<=", "<=", "OR", "OR");
		instance.setLoc(loc);
		assertEquals(instance.getLoc(), loc);

	}

	@Test
	final void testSetAtfd() {
		System.out.println("setAtfd");
		int atfd = 10;
		Rule instance = new Rule("A", "<=", "<=", "<=", "<=", "OR", "OR");
		instance.setAtfd(atfd);
		assertEquals(instance.getAtfd(), atfd);

	}

	@Test
	final void testSetCyclo() {
		System.out.println("setCyclo");
		int cyclo = 10;
		Rule instance = new Rule("A", "<=", "<=", "<=", "<=", "OR", "OR");
		instance.setCyclo(cyclo);
		assertEquals(instance.getCyclo(), cyclo);
	}

	@Test
	final void testSetLaa() {
		System.out.println("setLaa");
		double laa = 0.55;
		Rule instance = new Rule("A", "<=", "<=", "<=", "<=", "OR", "OR");
		instance.setLaa(laa);
		assertEquals(instance.getLaa(), laa, 0.5);
	}

	@Test
	final void testGetName() {
		setUp();
		assertEquals("A", r1.getName());
		assertEquals("B", r2.getName());
		assertEquals("C", r3.getName());
		assertEquals("D", r4.getName());
		assertEquals("E", r5.getName());
		assertEquals("F", r6.getName());
		assertEquals("G", r7.getName());
		assertEquals("H", r8.getName());
	}

	@Test
	final void testGetOperator1() {
		setUp();
		assertEquals("<=", r1.getOperator1());
		assertEquals(">=", r2.getOperator1());
		assertEquals("<=", r3.getOperator1());
		assertEquals(">=", r4.getOperator1());
		assertEquals("<=", r5.getOperator1());
		assertEquals("<=", r6.getOperator1());
		assertEquals("<=", r7.getOperator1());
		assertEquals("<=", r8.getOperator1());
	}

	@Test
	final void testGetOperator2() {
		setUp();
		assertEquals("<=", r1.getOperator2());
		assertEquals(">=", r2.getOperator2());
		assertEquals("<=", r3.getOperator2());
		assertEquals(">=", r4.getOperator2());
		assertEquals(">=", r5.getOperator2());
		assertEquals(">=", r6.getOperator2());
		assertEquals("<=", r7.getOperator2());
		assertEquals("<=", r8.getOperator2());
	}

	@Test
	final void testGetOperator3() {
		setUp();
		assertEquals("<=", r1.getOperator3());
		assertEquals(">=", r2.getOperator3());
		assertEquals("<=", r3.getOperator3());
		assertEquals(">=", r4.getOperator3());
		assertEquals(">=", r5.getOperator3());
		assertEquals("<=", r6.getOperator3());
		assertEquals(">=", r7.getOperator3());
		assertEquals("<=", r8.getOperator3());
	}

	@Test
	final void testGetOperator4() {
		setUp();
		assertEquals("<=", r1.getOperator4());
		assertEquals(">=", r2.getOperator4());
		assertEquals("<=", r3.getOperator4());
		assertEquals(">=", r4.getOperator4());
		assertEquals(">=", r5.getOperator4());
		assertEquals(">=", r6.getOperator4());
		assertEquals("<=", r7.getOperator4());
		assertEquals("<=", r8.getOperator4());
	}

	@Test
	final void testGetOperator5() {
		setUp();
		assertEquals("OR", r1.getOperator5());
		assertEquals("OR", r2.getOperator5());
		assertEquals("AND", r3.getOperator5());
		assertEquals("AND", r4.getOperator5());
		assertEquals("OR", r5.getOperator5());
		assertEquals("AND", r6.getOperator5());
		assertEquals("OR", r7.getOperator5());
		assertEquals("AND", r8.getOperator5());
	}

	@Test
	final void testGetOperator6() {
		setUp();
		assertEquals("OR", r1.getOperator6());
		assertEquals("AND", r2.getOperator6());
		assertEquals("OR", r3.getOperator6());
		assertEquals("AND", r4.getOperator6());
		assertEquals("OR", r5.getOperator6());
		assertEquals("AND", r6.getOperator6());
		assertEquals("AND", r7.getOperator6());
		assertEquals("OR", r8.getOperator6());
	}

	@Test
	final void testGetLoc() {
		setUp();
		int aux1 = r1.getLoc();
		int aux2 = r2.getLoc();
		int aux3 = r3.getLoc();

		assertEquals(0, aux1);
		assertEquals(0, aux2);
		assertEquals(0, aux3);
	}

	@Test
	final void testGetAtfd() {
		setUp();
		int aux1 = r1.getAtfd();
		int aux2 = r2.getAtfd();
		int aux3 = r3.getAtfd();

		assertEquals(0, aux1);
		assertEquals(0, aux2);
		assertEquals(0, aux3);
	}

	@Test
	final void testGetCyclo() {
		setUp();
		int aux1 = r1.getCyclo();
		int aux2 = r2.getCyclo();
		int aux3 = r3.getCyclo();

		assertEquals(0, aux1);
		assertEquals(0, aux2);
		assertEquals(0, aux3);
	}

	@Test
	final void testGetLaa() {
		setUp();
		double aux1 = r1.getLaa();
		double aux2 = r2.getLaa();
		double aux3 = r3.getLaa();

		assertEquals(0, aux1, 0);
		assertEquals(0, aux2, 0);
		assertEquals(0, aux3, 0);
	}

}
