package project.GUI;

/**
 * 
 * 
 * 
 * this class is about the method object this object corresponds to a horizontal
 * line of the excel file
 * 
 * @author Members TEAM ES1
 * @version 1.0 Data : Dec 03-2019
 *
 */
public class Method {

	private int id;
	private String inPackage;
	private String inClass;
	private String methodName;
	private int LOC;
	private int CYCLO;
	private int ATFD;
	private double LAA;
	private boolean is_long_method;
	private boolean iPlasma;
	private boolean PMD;
	private boolean is_feature_envy;
	private boolean calculated_long_method, calculated_Feature_envy;

	/**
	 * constructor and initializes the attributes of the method object
	 * 
	 * @param id              refers the id
	 * @param inPackage       refers to the package where the method is
	 * @param inClass         refers to the Class where the method is
	 * @param methodName      refers to the name of the method is
	 * @param LOC
	 * @param CYCLO
	 * @param ATFD
	 * @param LAA
	 * @param is_long_method  can say if the method is long or not
	 * @param iPlasma
	 * @param PMD
	 * @param is_feature_envy can say if the method is feature_envy
	 */
	public Method(int id, String inPackage, String inClass, String methodName, int LOC, int CYCLO, int ATFD, double LAA,
			boolean is_long_method, boolean iPlasma, boolean PMD, boolean is_feature_envy) {
		this.id = id;
		this.inPackage = inPackage;
		this.inClass = inClass;
		this.methodName = methodName;
		this.LOC = LOC;
		this.CYCLO = CYCLO;
		this.ATFD = ATFD;
		this.LAA = LAA;
		this.is_long_method = is_long_method;
		this.iPlasma = iPlasma;
		this.PMD = PMD;
		this.is_feature_envy = is_feature_envy;
	}

	/**
	 * getter method of the class method that gives us the calculated_long_method
	 * attribute
	 * 
	 * @return isPlasma
	 */
	public boolean getCalculatedLongMethod(Rule rule) {
		calculate(rule, "Long Method");
		return calculated_long_method;
	}

	public boolean getCalculatedFeatureEnvy(Rule rule) {
		calculate(rule, "Feature Envy");
		return calculated_Feature_envy;
	}

	/**
	 * getter method of the class method that gives us the isplasma attribute
	 * 
	 * @return isPlasma
	 */
	public boolean isiPlasma() {
		return iPlasma;
	}

	/**
	 * setter method that replaces the value of the isPlasma attribute of the method
	 * object
	 * 
	 * @param iPlasma parameter to replace
	 * 
	 */
	public void setiPlasma(boolean iPlasma) {
		this.iPlasma = iPlasma;
	}

	/**
	 * getter method of the class method that gives us the PMD attribute
	 * 
	 * @return PMD
	 */
	public boolean isPMD() {
		return PMD;
	}

	/**
	 * setter method that replaces the value of the PMD attribute of the method
	 * object
	 * 
	 * @param pMD parameter to replace
	 * 
	 */
	public void setPMD(boolean pMD) {
		PMD = pMD;
	}

	/**
	 * getter method of the class method that gives us the inPackage attribute
	 * 
	 * @return inPackage
	 */
	public String getInPackage() {
		return inPackage;
	}

	/**
	 * getter method of the class method that gives us the inClass attribute
	 * 
	 * @return inClass
	 */
	public String getInClass() {
		return inClass;
	}

	/**
	 * getter method of the class method that gives us the methodName attribute
	 * 
	 * @return methoName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * getter method of the class method that gives us the Loc attribute
	 * 
	 * @return loc atribute
	 */
	public int getLOC() {
		return LOC;
	}

	/**
	 * getter method of the class method that gives us the Cyclo attribute
	 * 
	 * @return CYCLO atribute
	 */
	public int getCYCLO() {
		return CYCLO;
	}

	/**
	 * getter method of the class method that gives us the ATFD attribute
	 * 
	 * @return Atfd atribute
	 */
	public int getATFD() {
		return ATFD;
	}

	/**
	 * getter method of the class method that gives us the LAA attribute
	 * 
	 * @return Laa atribute
	 */
	public double getLAA() {
		return LAA;
	}

	/**
	 * getter method of the class method that gives us the isIs_long_Method
	 * attribute
	 * 
	 * @return is_long_method
	 */
	public boolean isIs_long_method() {
		return is_long_method;
	}

	/**
	 * getter method of the class method that gives us the is_feature_envy attribute
	 * 
	 * @return isPlasma atribute
	 */
	public boolean isIs_feature_envy() {
		return is_feature_envy;
	}

	/**
	 * method calculates if a object method is a long method taking into account the
	 * attributes loc and cyclo
	 * 
	 * @return boolean value
	 */
	public boolean defaultLongMethod() {
		if (LOC > 80 && CYCLO > 10) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * method calculates if a object method is a feature_envy taking into account
	 * the attributes ATFD and LAA
	 * 
	 * @return boolean value
	 */
	public boolean defaultFeatureEnvy() {
		if (ATFD > 4 && LAA < 0.42) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * method to_string of the class method
	 * 
	 * if we call the method object inside sys it will generate a string with all
	 * its attributes
	 */
	@Override
	public String toString() {
		return "[id=" + id + ", methodName=" + methodName + ", LOC=" + LOC + ", CYCLO=" + CYCLO + ", ATFD=" + ATFD
				+ ", LAA=" + LAA + ", is_long_method=" + is_long_method + ", iPlasma=" + iPlasma + ", PMD=" + PMD
				+ ", is_feature_envy=" + is_feature_envy;
	}

	/**
	 * getter method of the class method that gives us the id attribute
	 * 
	 * @return id atributte
	 */
	public int getId() {
		return id;
	}

	/**
	 * setter method that replaces the value of the id attribute of the method
	 * object
	 * 
	 * @param id parameter to replace
	 * 
	 */
	public void setId(int id) {
		this.id = id;
	}

	private void calculate(Rule rule, String method) {
		calculated_Feature_envy = false; // first always set it to false so it can calculated it again
		calculated_long_method = false;
		boolean cycloBoolean = false, atfdBoolean = false, laaBoolean = false, locBoolean = false;
		if (rule.getCyclo() != 0)
			if (rule.getOperator1().equals("<="))
				cycloBoolean = (rule.getCyclo() <= CYCLO);
			else if (rule.getOperator1().equals(">="))
				cycloBoolean = (rule.getCyclo() >= CYCLO);
			else if (rule.getOperator1().equals(">"))
				cycloBoolean = (rule.getCyclo() > CYCLO);
			else
				cycloBoolean = (rule.getCyclo() < CYCLO);
		else // If not used in the rule its true
			cycloBoolean = true;
		if (rule.getAtfd() != 0)
			if (rule.getOperator2().equals("<="))
				atfdBoolean = (rule.getAtfd() <= ATFD);
			else if (rule.getOperator2().equals(">="))
				atfdBoolean = (rule.getAtfd() >= ATFD);
			else if (rule.getOperator2().equals(">"))
				atfdBoolean = (rule.getAtfd() > ATFD);
			else
				atfdBoolean = (rule.getAtfd() < ATFD);
		else
			atfdBoolean = true;
		if (rule.getLaa() != 0)
			if (rule.getOperator3().equals("<="))
				laaBoolean = (rule.getLaa() <= LAA);
			else if (rule.getOperator3().equals(">="))
				laaBoolean = (rule.getLaa() >= LAA);
			else if (rule.getOperator3().equals(">"))
				laaBoolean = (rule.getLaa() > LAA);
			else
				laaBoolean = (rule.getLaa() < LAA);
		else
			laaBoolean = true;
		if (rule.getLoc() != 0)
			if (rule.getOperator4().equals("<="))
				locBoolean = (rule.getLoc() <= LOC);

			else if (rule.getOperator4().equals(">="))
				locBoolean = (rule.getLoc() >= LOC);

			else if (rule.getOperator4().equals(">"))
				locBoolean = (rule.getLoc() > LOC);
			else
				locBoolean = (rule.getLoc() < LOC);
		else
			locBoolean = true;
		if (cycloBoolean && locBoolean && atfdBoolean && laaBoolean && method.equals("Feature Envy"))
			calculated_Feature_envy = true;
		else if (cycloBoolean && locBoolean && atfdBoolean && laaBoolean && method.equals("Long Method"))
			calculated_long_method = true;
	}

}
