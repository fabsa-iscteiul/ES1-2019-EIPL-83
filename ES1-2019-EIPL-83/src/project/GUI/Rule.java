package project.GUI;
/**
 * 
 * 
 * 
 * 
 * 
 * @author ES1-2019-EIPL-83
 * @version 1.0
 * Data : Dec 05-2019
 *
 */
public class Rule {
	
	private String name;
	private String operator1,operator2,operator3,operator4;
	private int loc=0,atfd=0,cyclo=0;
	private double laa=0;
	/** 
     * constructor and initializes 
     * the attributes of the Rule object
	 *@param name
	 *@param operator1
	 *@param operator2
	 *@param operator3
	 *@param operator4
	 */
	public Rule(String name,String operator1, String operator2,String operator3,String operator4) {
		if(!(operator1.equals("<=") || operator1.equals(">=") || operator1.equals("<") || operator1.equals(">") || 
				operator2.equals("<=") || operator2.equals(">=") || operator2.equals("<") || operator2.equals(">") || 
				operator3.equals("<=") || operator3.equals(">=") || operator3.equals("<") || operator3.equals(">") || 
				operator4.equals("<=") || operator4.equals(">=") || operator4.equals("<") || operator4.equals(">") ))
			return;
		this.operator1=operator1;
		this.operator2=operator2;
		this.operator3=operator3;
		this.operator4=operator4;
		this.name=name;
	}
	/**
	 * setter method that replaces the value of the loc attribute of the Rule object
	 * @param loc parameter to replace
	 */
	public void setLoc(int loc) {
		this.loc = loc;
	}

    /**
     * setter method that replaces the value of the atfd attribute of the Rule object
     * @param atfd parameter to replace
     */

	public void setAtfd(int atfd) {
		this.atfd = atfd;
	}
	/**
     * setter method that replaces the value of the cyclo attribute of the Rule object
     * @param cyclo parameter to replace
     */
	public void setCyclo(int cyclo) {
		this.cyclo = cyclo;
	}
	/**
     * setter method that replaces the value of the laa attribute of the Rule object
     * @param laa parameter to replace
     */
	public void setLaa(double laa) {
		this.laa = laa;
	}
	/**
	 * getter method of the class Rule that gives us the name attribute
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * getter method of the class Rule that gives us the operator1 attribute
	 * @return operator1 
	 */
	public String getOperator1() {
		return operator1;
	}
	/**
	 * getter method of the class Rule that gives us the operator2 attribute
	 * @return operator2 
	 */

	public String getOperator2() {
		return operator2;
	}
	/**
	 * getter method of the class Rule that gives us the operator3 attribute
	 * @return operator3 
	 */
	public String getOperator3() {
		return operator3;
	}
	/**
	 * getter method of the class Rule that gives us the operator4 attribute
	 * @return operator4 
	 */
	public String getOperator4() {
		return operator4;
	}
	/**
	 * getter method of the class Rule that gives us the loc attribute
	 * @return loc
	 */
	public int getLoc() {
		return loc;
	}
	/**
	 * getter method of the class Rule that gives us the atfd attribute
	 * @return atfd
	 */
	public int getAtfd() {
		return atfd;
	}
	/**
	 * getter method of the class Rule that gives us the cyclo attribute
	 * @return cyclo
	 */
	public int getCyclo() {
		return cyclo;
	}
	/**
	 * getter method of the class Rule that gives us the laa attribute
	 * @return laa 
	 */
	public double getLaa() {
		return laa;
	}

	// tentativa de commit
	
	
}
