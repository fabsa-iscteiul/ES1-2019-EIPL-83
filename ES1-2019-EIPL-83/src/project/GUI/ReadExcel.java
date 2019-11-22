package project.GUI;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private String pathExcel;
	private ArrayList<Method> methods = new ArrayList<Method>();

	public ReadExcel(String path) {
		this.pathExcel = path;
	}

	public void readExel() throws IOException {
		XSSFWorkbook xwb = new XSSFWorkbook(this.pathExcel);
		XSSFSheet sheet = xwb.getSheetAt(0);
		XSSFRow row;
		String cell = "";

		for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
				cell += row.getCell(j).toString();
				cell += ";";
			}
			cell += "\n";

		}

		//System.out.println(cell);
		auxiliar(cell);

	}

	public void printMethods() {
		for (Method x : methods) {
			System.out.println(x);
		}
	}

	public void auxiliar(String excelContent) {

		String[] rows = excelContent.split("\n");

		for (int i = 0; i < rows.length; i++) {
			System.out.println(rows[i]);
			vectorToMethod(rows[i].split(";"));
		}
	}

	public void vectorToMethod(String[] vMethod) {

		double id = Double.parseDouble(vMethod[0]);
		String inPackage = vMethod[1];
		String inClass = vMethod[2];
		String methodName = vMethod[3];
		double LOC = Double.parseDouble(vMethod[4]);
		double CYCLO = Double.parseDouble(vMethod[5]);
		double ATFD = Double.parseDouble(vMethod[6]);
		float LAA = Float.parseFloat(vMethod[7]);
		boolean is_long_method = Boolean.parseBoolean(vMethod[8]);
		boolean iPlasma = Boolean.parseBoolean(vMethod[9]);
		boolean PMD = Boolean.parseBoolean(vMethod[10]);
		boolean is_feature_envy = Boolean.parseBoolean(vMethod[11]);
		Method method = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, ATFD, LAA, is_long_method, iPlasma,
				PMD, is_feature_envy);
		methods.add(method);
	}



}
