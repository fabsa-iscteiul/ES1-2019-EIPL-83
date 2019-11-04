package project.GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Handler {

	private ArrayList<Method> methods = new ArrayList<Method>();

	/**
	 * Opens file and generates a Method object for each line
	 */
	public void BuildObjects() {
		try {
			String folderPath = System.getProperty("user.dir");
			String filePath = folderPath + "//src/DataEs1.csv";
			// File file = new File(filePath);
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			while (line != null) {
				String[] method = line.split(",");
				Method methodObj = new Method(Integer.parseInt(method[0]), method[1], method[2], method[3],
						Integer.parseInt(method[4]), Integer.parseInt(method[5]), Integer.parseInt(method[6]),
						Float.parseFloat(method[7]), Boolean.parseBoolean(method[8]), Boolean.parseBoolean(method[9]),
						Boolean.parseBoolean(method[10]), Boolean.parseBoolean(method[11]));
				methods.add(methodObj);
				line = br.readLine();
			}
			br.close();
			for (Method method : methods) {
				System.out.println(method);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Handler h = new Handler();
		h.BuildObjects();
	}
}
