package project.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * This class is responsible for setting up the Graphical User Interface (GUI)
 * for each functionality of the application
 * 
 * @author ES1_2019_LEIPL_83
 */
public class Window {
	private JFrame frame;
	private int loc = 80, cyclo = 10, atfd = 4; // DEFAULT VALUES
	private double laa = 0.42;
	private String[] operators_math = { "<=", "<", ">", ">=" };
	private JPanel painel2;
	private GridBagConstraints grid = new GridBagConstraints();
	private JList<String> methodList;
	private Handler handler;
	
	public Window() {
		this.handler = new Handler();
		addContent();

	}

	/**
	 * This method sets up the main Frame, where the User is presented with all the
	 * functionalities of the application
	 */
	private void addContent() {
		if (frame != null)
			frame.dispose();
		setupFrame("Project", 1, 1);
		methodList = new JList<String>(handler.methodsName());
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
		JButton newRule = new JButton("New Rule");
		newRule.addActionListener(new MyActionListener("newRule", this));
		buttonPanel.add(newRule);
		frame.add(methodList,BorderLayout.CENTER);
		frame.add(displayPanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setVisible(true);

	}

	/**
	 * This method sets up the frame where the User will have access to the Long
	 * Method
	 */
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
					// if it passes through this it means the user set a valid
					// value for loc
					loc = nrLines;
					int cycloUpdate = Integer.parseInt(cycleComplexity.getText());
					// if it passes through this it means the user set a valid
					// value for cyclo
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

	public void create_new_rules_user() {
		JFrame jframe = new JFrame();
		jframe.setTitle("USER_RULES");
		jframe.setSize(400, 400);
		jframe.setLayout(new FlowLayout());
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.setVisible(true);

		this.painel2 = new JPanel(new GridBagLayout());
		JLabel label1 = new JLabel("CYCLO");
		JLabel label2 = new JLabel("ATFD");
		JLabel label3 = new JLabel("LAA");
		JLabel label4 = new JLabel("LOC");

		JLabel label5 = new JLabel("Value");
		JLabel label6 = new JLabel("Operator");
		JLabel label7 = new JLabel("Thereshold");

		JComboBox<String> list_operadores1 = new JComboBox<String>(operators_math);
		JComboBox<String> list_operadores2 = new JComboBox<String>(operators_math);
		JComboBox<String> list_operadores3 = new JComboBox<String>(operators_math);
		JComboBox<String> list_operadores4 = new JComboBox<String>(operators_math);

		String selected_operator1 = (String) list_operadores1.getSelectedItem();
		String selected_operator2 = (String) list_operadores2.getSelectedItem();
		String selected_operator3 = (String) list_operadores3.getSelectedItem();
		String selected_operator4 = (String) list_operadores4.getSelectedItem();

		JTextField jtxt1 = new JTextField();
		JTextField jtxt2 = new JTextField();
		JTextField jtxt3 = new JTextField();
		JTextField jtxt4 = new JTextField();

		jtxt1.setPreferredSize(new Dimension(40, 20));
		jtxt2.setPreferredSize(new Dimension(40, 20));
		jtxt3.setPreferredSize(new Dimension(40, 20));
		jtxt4.setPreferredSize(new Dimension(40, 20));

		this.grid.insets = new Insets(10,10,10,10);

		this.grid.gridx = 0;
		this.grid.gridy = 0; ///////// primeira posição da grid
		painel2.add(label7, grid);

		this.grid.gridx = 1;
		this.grid.gridy = 0;/////////// segunda posição matriz (grid)
		painel2.add(label6, grid);

		this.grid.gridx = 2;
		this.grid.gridy = 0;
		painel2.add(label5, grid);

		this.grid.gridx = 0;
		this.grid.gridy = 1;
		painel2.add(label1, grid);

		this.grid.gridx = 0;
		this.grid.gridy = 2;
		painel2.add(label2, grid);

		this.grid.gridx = 0;
		this.grid.gridy = 3;
		painel2.add(label3, grid);

		this.grid.gridx = 0;
		this.grid.gridy = 4;
		painel2.add(label4, grid);

		this.grid.gridx = 1;
		this.grid.gridy = 1;
		painel2.add(list_operadores1, grid);

		this.grid.gridx = 1;
		this.grid.gridy = 2;
		painel2.add(list_operadores2, grid);

		this.grid.gridx = 1;
		this.grid.gridy = 3;
		painel2.add(list_operadores3, grid);

		this.grid.gridx = 1;
		this.grid.gridy = 4;
		painel2.add(list_operadores4, grid);

		this.grid.gridx = 2;
		this.grid.gridy = 1;
		painel2.add(jtxt1, grid);

		this.grid.gridx = 2;
		this.grid.gridy = 2;
		painel2.add(jtxt2, grid);

		this.grid.gridx = 2;
		this.grid.gridy = 3;
		painel2.add(jtxt3, grid);

		this.grid.gridx = 2;
		this.grid.gridy = 4;
		painel2.add(jtxt4, grid);
		
		JButton creatRule = new JButton("Creat Rule");

		this.grid.gridx = 1;
		this.grid.gridy = 7;
		painel2.add(creatRule,grid);
		
		

		jframe.add(painel2);
	}

	/**
	 * This method sets up the frame where the User will have access to the Feature
	 * Envy
	 */
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

	/**
	 * This method sets up the basic elements of any frame. It also builds the Grid
	 * Layout according to the number of columns and rows desired
	 * 
	 * @param title   A String that will be the title of the frame
	 * @param rows    The number of rows wanted
	 * @param columns The number of columns wanted
	 */
	private void setupFrame(String title, int rows, int columns) {
		frame = new JFrame(title);
		frame.setLayout(new GridLayout(rows, columns));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	

	public static void main(String[] args) { // Sï¿½ PARA TESTAR DEPOIS REMOVER
												// ISTO
		@SuppressWarnings("unused")
		Window w = new Window();
	}
}
