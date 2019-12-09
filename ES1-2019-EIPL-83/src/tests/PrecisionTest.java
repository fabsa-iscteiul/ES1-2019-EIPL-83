package tests;

//
import java.io.File;

import org.junit.jupiter.api.Test;

import project.GUI.PrecisionExcel;
import project.GUI.ReadExcel;

class PrecisionTest {
	PrecisionExcel pe1, pe2, pe3;
	File excel_file = new File("Long-Method.xlsx");
	ReadExcel r_e = new ReadExcel(excel_file.toPath().toString());

	protected void setUp() {
		pe1 = new PrecisionExcel(r_e);
		pe2 = new PrecisionExcel(r_e);
		pe3 = new PrecisionExcel(r_e);

	}

	@Test
	void TestCalculate_accuracy_longMethod() {
		setUp();
		pe1.calculate_accuracy_longMethod();
		pe2.calculate_accuracy_longMethod();
		pe3.calculate_accuracy_longMethod();

	}

}
