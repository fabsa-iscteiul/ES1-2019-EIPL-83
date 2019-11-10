package project.GUI;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class MyActionListener implements ActionListener {

	private String type;
	private Window window;

	public MyActionListener(String type, Window window) {
		this.type = type;
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (type.equals("longMethod")) {
			window.createLongMethodWindow();
		} else if (type.equals("feature_envy")) {
			window.createFeatureEnvy();
		} else if (type.equals("open_excel")) {

			JFileChooser filechooser = new JFileChooser("Importar ficheiros");
			int choosenVal = filechooser.showOpenDialog(null);
			if (choosenVal == JFileChooser.APPROVE_OPTION) {

				File file = filechooser.getSelectedFile();
				File ficheiro_excel = new File(file.toString());
				try {
					Desktop.getDesktop().open(ficheiro_excel);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
	}

} }
