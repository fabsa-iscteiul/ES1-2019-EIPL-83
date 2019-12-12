package project.GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class will have the main method and will give the GUI access to the
 * Method objects, which will generate at the start of the application
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
			System.out.println("Erro a abrir o ficheiro !");
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
			names[i] = methods.get(i).toString();
		return names;
	}
	
	//Method to return Indicator PMD for a Method
	public String resultsIndicatorPMD(Method m) {
		if (m.isIs_long_method()) {
			if (m.isPMD()) {
				return Indicator.DCI.toString();
			} else {
				return Indicator.ADII.toString();
			}
		} else {
			if (!m.isPMD()) {
				return Indicator.ADCI.toString();
			} else {
				return Indicator.DII.toString();
			}
		}		
	}
	
	
	// Method that retrieves HashMap with True or False from data
	public HashMap<Integer, String> comparePMDValue() {
		int j = methods.size();
		HashMap<Integer, String> trueOrFalse = new HashMap<Integer, String>();
		for(int i = 0; i < j; i++) {
			trueOrFalse.put(methods.get(i).getId(), resultsIndicatorPMD(methods.get(i)));
		}
		return trueOrFalse;
	}
	
	//Method to return Indicator against IPlasma vs reference
	
	public String resultsIndicatorIPlasma(Method m) {
		if (m.isIs_long_method()) {
			if (m.isiPlasma()) {
				return Indicator.DCI.toString();
			} else {
				return Indicator.ADII.toString();
			}
		} else {
			if (!m.isiPlasma()) {
				return Indicator.ADCI.toString();
			} else {
				return Indicator.DII.toString();
			}
		}		
	}
	
	
	//Method to return HashMap with values for IPlasma indicators
	
	public HashMap<Integer, String> compareIPlasmaValue() {
		int j = methods.size();
		HashMap<Integer, String> trueOrFalse = new HashMap<Integer, String>();
		for(int i = 0; i < j; i++) {
			trueOrFalse.put(methods.get(i).getId(), resultsIndicatorIPlasma(methods.get(i)));
		}
		return trueOrFalse;
	}
	
	
	//Method to return the results for each Indicator
	public HashMap<String, Integer> getResults (HashMap<Integer, String> results) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("DCI", 0);
		hm.put("DII", 0);
		hm.put("ADCI", 0);
		hm.put("ADII", 0);
		for (int i : results.keySet()) {			
			hm.put(results.get(i), hm.get(results.get(i))+1);
		}
		return hm;
	}

	
	public ArrayList<String> getLongMethodTest (Rule rule) {
		ArrayList<String> methodsList = new ArrayList <String>();
		for (Method m : getMethods()) {
			methodsList.add("MethodID: " + m.getId() + " Result: ");
		}
		return methodsList;
	}
}
