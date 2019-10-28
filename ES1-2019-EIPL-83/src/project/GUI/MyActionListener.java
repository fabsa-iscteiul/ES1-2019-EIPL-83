package project.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		} else if (type.equals("")) {

		}
	}

}
