package project.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Window {
	private JFrame frame;

	public Window() {
		addContent();

	}

	private void addContent() {
		if (frame != null)
			frame.dispose();
		frame = new JFrame("ES PROJECT");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		JButton longMethodButton = new JButton("Long Method");
		longMethodButton.addActionListener(new MyActionListener("longMethod", this));
		frame.add(longMethodButton, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	public void createLongMethodWindow() {
		frame.dispose();
		frame = new JFrame("Long Method");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 400));
		frame.setLayout(new GridLayout(2, 2));
		frame.setLocationRelativeTo(null);
		JLabel label = new JLabel("How many lines to consider?");
		frame.add(label);
		JTextField nrLines = new JTextField();
		frame.add(nrLines);
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		frame.add(calculateButton);
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addContent();
			}
		});
		frame.add(backButton);
		frame.setVisible(true);
	}

	public static void main(String[] args) { // SÓ PARA TESTAR DEPOIS REMOVER ISTO
		@SuppressWarnings("unused")
		Window w = new Window();
	}
}
