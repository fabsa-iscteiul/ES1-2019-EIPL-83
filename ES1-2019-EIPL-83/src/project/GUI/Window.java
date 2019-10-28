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
		frame.setLocationRelativeTo(null);
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
		frame.setLayout(new GridLayout(5, 2));
		frame.setLocationRelativeTo(null);
		JLabel label = new JLabel("LOC?");
		frame.add(label);
		JTextField nrLines = new JTextField();
		frame.add(nrLines);
		JLabel label1 = new JLabel("CYCLO?");
		frame.add(label1);
		JTextField cycleComplexity = new JTextField();
		frame.add(cycleComplexity);
		JLabel label2 = new JLabel("ATFD?");
		frame.add(label2);
		JTextField atfd = new JTextField();
		frame.add(atfd);
		JLabel label3 = new JLabel("LAA?");
		frame.add(label3);
		JTextField laa = new JTextField();
		frame.add(laa);

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
