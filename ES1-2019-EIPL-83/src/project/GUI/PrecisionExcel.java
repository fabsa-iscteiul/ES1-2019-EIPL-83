package project.GUI;

import java.io.File;
import java.io.IOException;

public class PrecisionExcel {

	ReadExcel read_excel;

	public PrecisionExcel(ReadExcel read_excel) {
		this.read_excel = read_excel;
	}

	public void calculate_accuracy_longMethod() {
		//Aqui estou a ler o ficheiro excel.
		try {
			this.read_excel.readExel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double pmd_accuracy;
		double Iplasma_accuracy;
		double line_accuracy;

		int pmd_certain = 0;
		int plasma_certain = 0;
		int line_certain = 0;

		for (Method m : this.read_excel.getMethods()) {
			if (m.isIs_long_method() == m.isPMD()) {
				pmd_certain++;
			}
			if (m.isIs_long_method() == m.isiPlasma()) {
				plasma_certain++;
			}
			if (m.isIs_long_method() == m.isiPlasma() && m.isPMD() == m.isIs_long_method()) {
				line_certain++;
			}

		}
		int size = this.read_excel.getMethods().size(); // tamanho do ficheiro excel
		pmd_accuracy = (double) ((pmd_certain * 100) / (size));
		Iplasma_accuracy = (double) ((plasma_certain * 100) / ((size)));
		line_accuracy = (double) ((line_certain * 100) / ((size)));
		System.out.println( "pmd_accuracy" + "=" + pmd_accuracy);
		System.out.println("plasma_accuracy" + "=" + Iplasma_accuracy);
		System.out.println("line_certain" + "=" + line_accuracy);
	}

	public void size_methods() {
		System.out.println(this.read_excel.getMethods().size());
	}

	public static void main(String[] args) {
		File excel_file = new File("Long-Method.xlsx");
		ReadExcel r_e = new ReadExcel(excel_file.toPath().toString());
        PrecisionExcel p_e = new PrecisionExcel(r_e);
		p_e.calculate_accuracy_longMethod();

	}
}
