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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 * This class is responsible for setting up the Graphical User Interface (GUI)
 * 
 * @author ES1_2019_LEIPL_83
 */

public class Window {
	private JFrame frame;
	private int loc = 80, cyclo = 10, atfd = 4; // DEFAULT VALUES
	private double laa = 0.42;
	private String[] operators_math = { "<=", "<", ">", ">=" };
	private String[] operators_math2 = { "AND", "OR" };
	private JPanel painel2;
	private GridBagConstraints grid = new GridBagConstraints();
	private JList<String> methodList;
	private Handler handler;
	private JScrollPane scrollPane = new JScrollPane();
	private ArrayList<Rule> ruleList = new ArrayList<Rule>();
	private String[] ruleNames = new String[5];
	private int i = 2;

	public Window() {
		this.handler = new Handler();
		Rule defaultLongMethod = new Rule("Default Long Method Rule", ">", "", "", ">", "", "");
		defaultLongMethod.setCyclo(cyclo);
		defaultLongMethod.setLoc(loc);
		ruleNames[0] = "Default Long Method Rule";
		ruleList.add(defaultLongMethod);
		Rule defaultFeatureEnvy = new Rule("Default Feature Envy Rule", ">", "", "", ">", "", "");
		defaultFeatureEnvy.setAtfd(atfd);
		defaultFeatureEnvy.setLaa(laa);
		ruleNames[1] = "Default Feature Envy Rule";
		ruleList.add(defaultFeatureEnvy);
		addContent();
	}

	/**
	 * This method sets up the main Frame, where the User is presented with all the
	 * functionalities of the application
	 */
	public void addContent() {
		if (frame != null)
			frame.dispose();
		setupFrame("Project", 1, 1);
		methodList = new JList<String>(handler.methodsName());
		methodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(methodList);
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
		JButton comparing = new JButton("Evaluate Tools");
		comparing.addActionListener(new MyActionListener("tools", this));
		JButton longMethodButton = new JButton("Long Method");
		longMethodButton.addActionListener(new MyActionListener("longMethod", this));
		JButton featureEnvyButton = new JButton("Feature Envy");
		featureEnvyButton.addActionListener(new MyActionListener("feature_envy", this));
		JButton openButton = new JButton("Open Excel");
		openButton.addActionListener(new MyActionListener("open_excel", this));
		buttonPanel.add(comparing);
		buttonPanel.add(longMethodButton);
		buttonPanel.add(featureEnvyButton);
		buttonPanel.add(openButton);
		JButton newRule = new JButton("New Rule");
		newRule.addActionListener(new MyActionListener("newRule", this));
		buttonPanel.add(newRule);
		frame.add(scrollPane, BorderLayout.CENTER);
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
		frame = new JFrame("Long Method");
		JPanel buttonPanel = new JPanel();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		JList<String> listRule = new JList<String>(ruleNames);
		frame.add(listRule, BorderLayout.CENTER);
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listRule.getSelectedValue() == null)
					return;
				else {
					for (Rule rule : ruleList)
						if (rule.getName().equals(listRule.getSelectedValue())) {
							frame.dispose();
							displayResults(rule, "Long Method");
							break;
						}
				}
			}
		});

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addContent();
			}
		});
		buttonPanel.add(calculate);
		buttonPanel.add(backButton);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Creates window to create new rules with user preferences
	 */

	public void create_new_rules_user() {
		frame.dispose();
		JFrame jframe = new JFrame();
		jframe.setTitle("USER_RULES");
		jframe.setSize(400, 400);
		jframe.setLayout(new FlowLayout());
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setResizable(false);

		this.painel2 = new JPanel(new GridBagLayout());
		JLabel label1 = new JLabel("CYCLO");
		JLabel label2 = new JLabel("ATFD");
		JLabel label3 = new JLabel("LAA");
		JLabel label4 = new JLabel("LOC");

		JLabel label5 = new JLabel("Value");
		JLabel label6 = new JLabel("Operator");
		JLabel label7 = new JLabel("Thereshold");
		JLabel label8 = new JLabel("LongMethod");
		JLabel label9 = new JLabel("FeatureEnvy");

		JComboBox<String> list_operadores1 = new JComboBox<String>(operators_math);
		JComboBox<String> list_operadores2 = new JComboBox<String>(operators_math);
		JComboBox<String> list_operadores3 = new JComboBox<String>(operators_math);
		JComboBox<String> list_operadores4 = new JComboBox<String>(operators_math);
		JComboBox<String> list_operadores5 = new JComboBox<String>(operators_math2);
		JComboBox<String> list_operadores6 = new JComboBox<String>(operators_math2);

		JTextField jtxt1 = new JTextField();
		JTextField jtxt2 = new JTextField();
		JTextField jtxt3 = new JTextField();
		JTextField jtxt4 = new JTextField();
		jtxt1.setPreferredSize(new Dimension(40, 20));
		jtxt2.setPreferredSize(new Dimension(40, 20));
		jtxt3.setPreferredSize(new Dimension(40, 20));
		jtxt4.setPreferredSize(new Dimension(40, 20));

		this.grid.insets = new Insets(10, 10, 10, 10);

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

		this.grid.gridx = 3;
		this.grid.gridy = 1;
		painel2.add(list_operadores5, grid);

		this.grid.gridx = 3;
		this.grid.gridy = 2;
		painel2.add(label8, grid);

		this.grid.gridx = 3;
		this.grid.gridy = 3;
		painel2.add(list_operadores6, grid);

		this.grid.gridx = 3;
		this.grid.gridy = 4;
		painel2.add(label9, grid);

		JButton creatRule = new JButton("Creat Rule");
		creatRule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String selected_operator1 = (String) list_operadores1.getSelectedItem();
					String selected_operator2 = (String) list_operadores2.getSelectedItem();
					String selected_operator3 = (String) list_operadores3.getSelectedItem();
					String selected_operator4 = (String) list_operadores4.getSelectedItem();
					String selected_operator5 = (String) list_operadores5.getSelectedItem();
					String selected_operator6 = (String) list_operadores6.getSelectedItem();

					Rule rule = new Rule("New Rule " + i, selected_operator1, selected_operator2, selected_operator3,
							selected_operator4, selected_operator5, selected_operator6);
					if (!jtxt1.getText().equals(""))
						rule.setCyclo(Integer.parseInt(jtxt1.getText()));
					if (!jtxt2.getText().equals(""))
						rule.setAtfd(Integer.parseInt(jtxt2.getText()));
					if (!jtxt3.getText().equals(""))
						rule.setLaa(Double.parseDouble(jtxt3.getText()));
					if (!jtxt4.getText().equals(""))
						rule.setLoc(Integer.parseInt(jtxt4.getText()));
					ruleList.add(rule);
					ruleNames[i] = rule.getName();
					i++;
					jframe.dispose();
					addContent();
				} catch (Exception exception) {
				}

			}
		});
		this.grid.gridx = 1;
		this.grid.gridy = 7;
		painel2.add(creatRule, grid);

		jframe.add(painel2);
		jframe.setVisible(true);
	}

	/**
	 * This method sets up the frame where the User will have access to the Feature
	 * Envy rule selection
	 */
	public void createFeatureEnvy() {
		frame.dispose();
		frame = new JFrame("Feature Envy");
		JPanel buttonPanel = new JPanel();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		JList<String> listRule = new JList<String>(ruleNames);
		frame.add(listRule, BorderLayout.CENTER);
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listRule.getSelectedValue() == null)
					return;
				else {
					for (Rule rule : ruleList)
						if (rule.getName().equals(listRule.getSelectedValue())) {
							frame.dispose();
							displayResults(rule, "Feature Envy");
							break;
						}
				}
			}
		});

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addContent();
			}
		});
		buttonPanel.add(calculate);
		buttonPanel.add(backButton);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Window to show results
	 * 
	 * @param rule
	 * @param type
	 */
	public void displayResults(Rule rule, String type) {
		frame = new JFrame("Results");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		String[] result = new String[420];
		int i = 0;
		if (type.equals("Feature Envy"))
			for (Method m : handler.getMethods()) {
				result[i] = m.getId() + " " + m.getCalculatedFeatureEnvy(rule);
				i++;
			}
		else
			for (Method m : handler.getMethods()) {
				result[i] = m.getId() + " " + m.getCalculatedLongMethod(rule);
				i++;
			}

		methodList = new JList<>(result);
		scrollPane.setViewportView(methodList);
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addContent();
			}
		});
		buttonPanel.add(backButton);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

	/**
	 * getter method of the class Window that gives us the getLoc attribute
	 * 
	 * @return loc
	 */
	public int getLoc() {
		return loc;
	}

	/**
	 * getter method of the class Window that gives us the getCyclo attribute
	 * 
	 * @return cyclo
	 */
	public int getCyclo() {
		return cyclo;
	}

	/**
	 * setter method that replaces the value of the loc attribute of the Window
	 * object
	 * 
	 * @param loc parameter to replace
	 */
	public void setLoc(int loc) {
		this.loc = loc;
	}

	/**
	 * setter method that replaces the value of the cyclo attribute of the Window
	 * object
	 * 
	 * @param cyclo parameter to replace
	 */
	public void setCyclo(int cyclo) {
		this.cyclo = cyclo;
	}

	/**
	 * getter method of the class Window that gives us the getAtfd attribute
	 * 
	 * @return atfd
	 */
	public int getAtfd() {
		return atfd;
	}

	/**
	 * setter method that replaces the value of the atfd attribute of the Window
	 * object
	 * 
	 * @param atfd parameter to replace
	 */
	public void setAtfd(int atfd) {
		this.atfd = atfd;
	}

	/**
	 * getter method of the class Window that gives us the getLaa attribute
	 * 
	 * @return laa
	 */
	public double getLaa() {
		return laa;
	}

	/**
	 * setter method that replaces the value of the laa attribute of the Window
	 * object
	 * 
	 * @param laa parameter to replace
	 */
	public void setLaa(double laa) {
		this.laa = laa;
	}

	/**
	 * getter method of the class Window that gives us the getSelectedMethod
	 * attribute
	 * 
	 * @return method or null
	 */
	public Method getSelectedMethod() {
		for (Method method : handler.getMethods())
			if (method.toString().equals(methodList.getSelectedValue()))
				return method;
		return null;
	}

	/**
	 * Creates window to select which Tool will be evaluated
	 */

	public void getToolList() {
		frame.dispose();
		frame = new JFrame("Select Tool To Evaluate");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		DefaultListModel<String> list = new DefaultListModel<String>();
		list.addElement("IPlasma");
		list.addElement("PMD");
		JList<String> toolList = new JList<String>(list);
		frame.add(toolList, BorderLayout.CENTER);
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getLongMethodTable(toolList.getSelectedValue());

			}
		});
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addContent();
			}
		});
		buttonPanel.add(calculate);
		buttonPanel.add(backButton);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setSize(400, 150);
		frame.setVisible(true);
	}

	/**
	 * Method to return JTable to present IPlasma Indicators
	 * 
	 * @param selectedTool
	 */
	public void getLongMethodTable(String selectedTool) {
		if (frame != null)
			frame.dispose();
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		if (selectedTool.equals("IPlasma")) {
			frame = new JFrame("Long Method - IPlasma Evaluation");
			hm = handler.compareIPlasmaValue();
		} else {
			frame = new JFrame("Long Method - PMD Evaluation");
			hm = handler.comparePMDValue();
		}
		final HashMap<Integer, String> map = hm;
		JPanel buttonPanel = new JPanel();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel(new Object[] { "MethodID", "Indicator Value" }, 0);
		for (Entry<Integer, String> a : hm.entrySet()) {
			model.addRow(new Object[] { a.getKey(), a.getValue() });
		}
		JTable j = new JTable(model);
		j.setFillsViewportHeight(true);
		scrollPane.setViewportView(j);
		frame.add(scrollPane, BorderLayout.CENTER);
		JButton results = new JButton("Results");
		results.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Results: " + handler.getResults(map)
						+ "\nDCI - Defeitos Corretamente Identificados\nDII - Defeitos Incorretamente Identificados\n"
						+ "ADCI - Ausências de Defeitos Corretamente Identificadas\nADII - Ausências de Defeitos Incorretamente Identificadas");
			}
		});
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addContent();
			}
		});
		buttonPanel.add(results);
		buttonPanel.add(backButton);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Window w = new Window();
	}

}
