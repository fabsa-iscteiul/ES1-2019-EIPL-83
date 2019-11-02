package project.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Window {
	private JFrame frame;
	private int loc = 80, cyclo = 10, atfd = 4; // DEFAULT VALUES
	private double laa = 0.42;

	public Window() {
		addContent();

	}

	private void addContent() {
		if (frame != null)
			frame.dispose();
		setupFrame("Project", 1, 1);
		frame.setLayout(new BorderLayout());
		JPanel displayPanel = new JPanel(); // FLOWLAYOUT IS THE DEFAULT
		JPanel buttonPanel = new JPanel();
		JLabel locDisplay = new JLabel("Loc Threshold = " + loc);
		displayPanel.add(locDisplay);
		JLabel cycloDisplay = new JLabel("Cyclo Threshold = " + cyclo);
		displayPanel.add(cycloDisplay);
		JLabel atfdDisplay = new JLabel("Atfd Threshold = " + atfd);
		displayPanel.add(atfdDisplay);
		JLabel laaDisplay = new JLabel("Laa Threshold = " + laa);
		displayPanel.add(laaDisplay);
		JButton longMethodButton = new JButton("Long Method");
		longMethodButton.addActionListener(new MyActionListener("longMethod", this));
		JButton featureEnvyButton = new JButton("Feature Envy");
		featureEnvyButton.addActionListener(new MyActionListener("feature_envy", this));
		JButton openButton = new JButton("Open Excel");
		openButton.addActionListener(new MyActionListener("open_excel", this));
		buttonPanel.add(longMethodButton);
		buttonPanel.add(featureEnvyButton);
		buttonPanel.add(openButton);
		frame.add(displayPanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	public void createLongMethodWindow() {
		frame.dispose();
		setupFrame("Long Method", 4, 2);
		JLabel labelLOC = new JLabel("LOC? ( default value = 80 )");
		frame.add(labelLOC);
		JTextField locThreshold = new JTextField();
		frame.add(locThreshold);
		JLabel labelCYCLO = new JLabel("CYCLO? ( default value = 10 )");
		frame.add(labelCYCLO);
		JTextField cycleComplexity = new JTextField();
		frame.add(cycleComplexity);
		JLabel labelID = new JLabel("Method ID?");
		frame.add(labelID);
		JTextField methodID = new JTextField();
		frame.add(methodID);
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int nrLines = Integer.parseInt(locThreshold.getText());
					// if it passes through this it means the user set a valid value for loc
					loc = nrLines;
					int cycloUpdate = Integer.parseInt(cycleComplexity.getText());
					// if it passes through this it means the user set a valid value for cyclo
					cyclo = cycloUpdate;
				} catch (Exception exception) {
				}

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

	public void createFeatureEnvy() {
		frame.dispose();
		setupFrame("Feature Envy", 4, 2);
		JLabel labelATFD = new JLabel("ATFD? ( default value = 4 )");
		frame.add(labelATFD);
		JTextField atfd = new JTextField();
		frame.add(atfd);
		JLabel labelLAA = new JLabel("LAA? ( default value = 0.42 )");
		frame.add(labelLAA);
		JTextField laa = new JTextField();
		frame.add(laa);
		JLabel labelID = new JLabel("Method ID?");
		frame.add(labelID);
		JTextField methodID = new JTextField();
		frame.add(methodID);
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

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

	private void setupFrame(String title, int rows, int colums) {
		frame = new JFrame(title);
		frame.setLayout(new GridLayout(rows, colums));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1600, 1000));
		frame.setLocationRelativeTo(null);
	}

	public int getLoc() {
		return loc;
	}

	public int getCyclo() {
		return cyclo;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public void setCyclo(int cyclo) {
		this.cyclo = cyclo;
	}

	public int getAtfd() {
		return atfd;
	}

	public void setAtfd(int atfd) {
		this.atfd = atfd;
	}

	public double getLaa() {
		return laa;
	}

	public void setLaa(double laa) {
		this.laa = laa;
	}

	public static void main(String[] args) { // SÓ PARA TESTAR DEPOIS REMOVER ISTO
		@SuppressWarnings("unused")
		Window w = new Window();
	}
}
