package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import project.GUI.Rule;

class RuleTest {

	Rule r1, r2, r3,r4;

	public void setUp() {
		r1 = new Rule("A", "<=", "<=", "<=", "<=", "OR", "OR");
		r2 = new Rule("B", ">=", ">=", ">=", ">=", "OR", "AND");
		r3 = new Rule("C", "<=", "<=", "<=", "<=", "AND", "OR");
		r4 = new Rule("C", "4", "5", "9", "3", "e", "e");

	}

	@Test
	public void TestsetLOC_getLOC() {
		setUp();
		r1.setLoc(5);
		r2.setLoc(5);
		r3.setLoc(5);
		assertEquals(5, r1.getLoc());
		assertEquals(5, r2.getLoc());
		assertEquals(5, r3.getLoc());
	}

	@Test
	public void TestsetaAtfd_getAtfd() {
		setUp();
		r1.setAtfd(5);
		r2.setAtfd(5);
		r3.setAtfd(5);
		assertEquals(5, r1.getAtfd());
		assertEquals(5, r2.getAtfd());
		assertEquals(5, r3.getAtfd());
	}

	@Test
	public void TestsetaCyclo_getCyclo() {
		setUp();
		r1.setCyclo(5);
		r2.setCyclo(5);
		r3.setCyclo(5);
		assertEquals(5, r1.getCyclo());
		assertEquals(5, r2.getCyclo());
		assertEquals(5, r3.getCyclo());
	}

	@Test
	public void TestsetaLaa_getLaa() {
		setUp();
		r1.setLaa(5.0);
		r2.setLaa(5.0);
		r3.setLaa(5.0);
		assertEquals(Double.valueOf(5.0), r1.getLaa());
		assertEquals(Double.valueOf(5.0), r2.getLaa());
		assertEquals(Double.valueOf(5.0), r3.getLaa());

	}

	@Test
	public void TestgetName() {
		setUp();
		assertTrue("A" == r1.getName());
		assertTrue("B" == r2.getName());
		assertTrue("C" == r3.getName());

	}

	@Test
	final void testGetOperator1() {
		setUp();
		assertTrue("<=" == r1.getOperator1());
		assertTrue("<=" == r1.getOperator2());
		assertTrue("<=" == r1.getOperator3());
		assertTrue("<=" == r1.getOperator4());
		assertTrue("OR" == r1.getOperator5());
		assertTrue("OR" == r1.getOperator6());

	}

}
