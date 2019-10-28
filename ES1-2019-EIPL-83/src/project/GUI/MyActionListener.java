package project.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

	private String type;

	public MyActionListener(String type) {
		this.type = type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (type.equals("longMethod")) {

		}
	}

}
