package project.GUI;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * 
 * 
 * 
 * this class will be the class responsible for reading the excel 
 * file and for this will have as its attribute the name of the folder
 * where the excel file is found and will 
 * have knowledge of all method objects in an arraylist
 * 
 * @author Members TEAM ES1  
 * @version 1.0
 * Data : Dec 03-2019
 *
 */
public class ReadExcel {

	private String pathExcel;
	private ArrayList<Method> methods = new ArrayList<Method>();

	
	/**
	 * constructor and initializes 
     * the attributes of the ReadExcel object
	 * @param path is the name of the folder where is the file
	 */
	public ReadExcel(String path) {
		this.pathExcel = path;
	}
	
	

	/**
	 * this method will be responsible for reading the excel file
	 * 
	 * to do this it will instantiate an XSSWorkbook object using it the folder name
	 * then it will instantiate an XSSFSheet Object and XSSFRow will also create a
	 * string that will be responsible for accumulating all the lines of the file
	 * this string is named cell in this method within the for loop excel file is
	 * read line by line at the end of this method the auxiliary method is invoked
	 * which is responsible for breaking the string containing all lines of the file
	 * and breaking the string in a string vector using the line terminator.
	 */
	public void readExel() {
		try {
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
		
		xwb.close();
		
		} catch (IOException e) {
			System.out.println("Erro a let Excel");
			e.printStackTrace();
		}

	}

	/**
	 * This method breaks the string containing the contents of the excel file into
	 * a string array based on the line terminator / n. Next is invoked within this
	 * method. vectortoMethod which receives a string array and transforms that
	 * string array into a method object and sends it to arrayList (ReadExcel class
	 * attribute)
	 * 
	 * @param excel content
	 */

	public void auxiliar(String excelContent) {

		String[] rows = excelContent.split("\n");

		for (int i = 0; i < rows.length; i++) {
			//System.out.println(rows[i]);
			vectorToMethod(rows[i].split(";"));
			//checkar
		}
	}

	/**
	 * 
	 * This method receives the string vector where all the attributes of the method
	 * object are in the form of strings. This method will initialize all its
	 * attributes (of the method object) with the information contained within the
	 * string and then instantiate a method object and add it to the object
	 * arraylist method
	 * 
	 * @param vMethod string broken by (/n)
	 */
	public void vectorToMethod(String[] vMethod) {
		int id = (int) Double.parseDouble(vMethod[0]);
		String inPackage = vMethod[1];
		String inClass = vMethod[2];
		String methodName = vMethod[3];
		int LOC = (int) Double.parseDouble(vMethod[4]);
		int CYCLO =(int) Double.parseDouble(vMethod[5]);
		int ATFD =(int) Double.parseDouble(vMethod[6]);
		int LAA =(int) Double.parseDouble(vMethod[7]);
		boolean is_long_method = Boolean.parseBoolean(vMethod[8]);
		boolean iPlasma = Boolean.parseBoolean(vMethod[9]);
		boolean PMD = Boolean.parseBoolean(vMethod[10]);
		boolean is_feature_envy = Boolean.parseBoolean(vMethod[11]);
		Method method = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, ATFD, LAA, is_long_method, iPlasma,
				PMD, is_feature_envy);
		methods.add(method);
		
	}
	
	/**
	 * setter method that replaces the value of the ArrayList<method> attribute of the ReadExcel object
	 * @param ArrayList<Method> methods parameter to replace
	 * 
	 */
	public void setMethods(ArrayList<Method> methods) {
		this.methods = methods;
	}
	
	/**
	 * 
	 * this method prints all method objects on the console by traversing it to the
	 * arrayList of method objects
	 */
	public void printMethods() {
		for (Method x : methods) {
			System.out.println(x);
		}
	}
	
	/**
	 * getter method of the class ReadExcel that gives us the methods attribute
	 * @return methods 
	 */
	public ArrayList<Method> getMethods() {
		return methods;
	}
	
	
	/**
	 * getter method of the class ReadExcel that gives us the pathExcel attribute
	 * @return pathExcel 
	 */
	public String getPathExcel() {
		return pathExcel;
	}



}
