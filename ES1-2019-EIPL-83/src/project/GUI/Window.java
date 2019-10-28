package project.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window {
	private JFrame frame;

	public Window() {
		frame = new JFrame("ES PROJECT");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addContent();
		frame.setVisible(true);

	}

	private void addContent() {
		JButton longMethod = new JButton();
		longMethod.addActionListener(new MyActionListener("longMethod"));
	}
}
