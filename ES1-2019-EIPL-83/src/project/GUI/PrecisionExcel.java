package project.GUI;

/**
 * 
 * 
 * 
 * 
 * This class is responsible for calculating the accuracy of the Excel file and
 * will receive a ReadExcel object.
 * 
 * @author Members TEAM ES1
 * @version 1.0 Data : Dec 03-2019
 *
 */

public class PrecisionExcel {

	private ReadExcel read_excel;
	private double pmd_accuracy;
	private double Iplasma_accuracy;
	private double line_accuracy;

	/**
	 * constructor and initializes the attributes of the PrecisionExcel object
	 * 
	 * @param read_excel
	 */
	public PrecisionExcel(ReadExcel read_excel) {
		this.read_excel = read_excel;
	}

	/**
	 * This method will be responsible for calculating the accuracy of long_method
	 * this will have three int instances that will be accumulative so this method
	 * will go through all method objects and if its value is long_method equals the
	 * isPlasma value of the object then the pmd_certai variable will be incremented
	 * and so on for the other variables until read all method objects at the end
	 * these variables are multiplied by 100 and divided by the size of the excel
	 * file to calculate their precision at the end the value of the various
	 * precisions is printed on the console
	 */
	public void calculate_accuracy_longMethod() {
		this.read_excel.readExel();

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
		this.pmd_accuracy = (double) ((pmd_certain * 100) / (size));
		this.Iplasma_accuracy = (double) ((plasma_certain * 100) / ((size)));
		this.line_accuracy = (double) ((line_certain * 100) / ((size)));
		System.out.println("pmd_accuracy" + "=" + pmd_accuracy);
		System.out.println("plasma_accuracy" + "=" + Iplasma_accuracy);
		System.out.println("line_certain" + "=" + line_accuracy);
	}

	/**
	 * 
	 * This method prints the value o f the excel file size on the console.
	 */
	public void size_methods() {
		System.out.println(this.read_excel.getMethods().size());
	}

}
