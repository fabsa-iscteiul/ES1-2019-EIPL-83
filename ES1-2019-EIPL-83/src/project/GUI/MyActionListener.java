package project.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MyActionListener implements ActionListener {

	private String type;
	private Window window;
	private Method selectedMethod;

	public MyActionListener(String type, Window window) {
		this.type = type;
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (type.equals("longMethod")) {
			if(window.getSelectedMethod() == null) {
				window.getToolList();
				return;
			}
			selectedMethod = window.getSelectedMethod();
			window.createLongMethodWindow(selectedMethod);
		} else if (type.equals("feature_envy")) {
			if(window.getSelectedMethod() == null) {
				JOptionPane.showMessageDialog(null, "Select one method");
				return;
			}
			selectedMethod = window.getSelectedMethod();
			window.createFeatureEnvy(selectedMethod);
		} else if (type.equals("open_excel")) {

			JFileChooser option = new JFileChooser("Importar ficheiros");
			int choosenVal = option.showOpenDialog(null);
			if (choosenVal == JFileChooser.APPROVE_OPTION) {

				File file = option.getSelectedFile();
				String pathFileExcel = file.toPath().toString();
				ReadExcel re = new ReadExcel(pathFileExcel);
				re.readExel();

				re.printMethods();
			}

		} else if (type.equals("newRule")) {
			window.create_new_rules_user();
		} 
	}
	
}
