package project.GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This class will have the main method and will give the GUI access to the
 * Method objects, which will generate at the star of the application
 * 
 * @author ES1_2019_LEIPL_83
 *
 */
public class Handler {

	private ArrayList<Method> methods = new ArrayList<Method>();
	
	public Handler() {
		// TODO Auto-generated constructor stub
		BuildObjects();
	}

	/**
	 * Opens file and generates a Method object for each line
	 * 
	 */
	public void BuildObjects() {
		try {
			String folderPath = System.getProperty("user.dir");
			String filePath = folderPath + "/src/DataEs1.csv";
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] method = line.split(",");
				vectorToMethod(method);
				line = br.readLine();
			}
			br.close();
//			for (Method method : methods) {
//				System.out.println(method.toString());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void vectorToMethod(String[] vMethod) {
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
		methods.add(method);
	}
	
	public ArrayList<Method> getMethods() {
		return methods;
	}
	
	public String[] methodsName() {
		String[] names = new String[methods.size()];
		for(int i =0; i<methods.size(); i++) // DECIDE WHAT TO PUT IN THE GUI 
			names[i] = methods.get(i).getId()+ " "+methods.get(i).getMethodName() +" Long Method = " + methods.get(i).isIs_long_method()+" Feature_envy = " + methods.get(i).isIs_feature_envy();
			return names;
	}

}
