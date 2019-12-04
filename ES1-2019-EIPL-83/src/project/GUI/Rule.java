package project.GUI;

public class Rule {
	
	private String name;
	private String operator1,operator2,operator3,operator4;
	private int loc=0,atfd=0,cyclo=0;
	private double laa=0;
	
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

	public void setLoc(int loc) {
		this.loc = loc;
	}


	public void setAtfd(int atfd) {
		this.atfd = atfd;
	}

	public void setCyclo(int cyclo) {
		this.cyclo = cyclo;
	}

	public void setLaa(double laa) {
		this.laa = laa;
	}

	public String getName() {
		return name;
	}

	public String getOperator1() {
		return operator1;
	}


	public String getOperator2() {
		return operator2;
	}

	public String getOperator3() {
		return operator3;
	}

	public String getOperator4() {
		return operator4;
	}

	public int getLoc() {
		return loc;
	}

	public int getAtfd() {
		return atfd;
	}

	public int getCyclo() {
		return cyclo;
	}

	public double getLaa() {
		return laa;
	}

	
	
	
}
