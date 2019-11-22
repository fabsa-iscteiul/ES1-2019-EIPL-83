package project.GUI;

public class Method {

	private double id;
	private String inPackage;
	private String inClass;
	private String methodName;
	private double LOC;
	private double CYCLO;
	private double ATFD;
	private float LAA;
	private boolean is_long_method;
	private boolean iPlasma;
	private boolean PMD;
	private boolean is_feature_envy;

	public Method(double id, String inPackage, String inClass, String methodName, double LOC, double CYCLO, double ATFD, float LAA,
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

	public boolean defaultLongMethod() {
		if (LOC > 80 && CYCLO > 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean defaultFeatureEnvy() {
		if (ATFD > 4 && LAA < 0.42) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Method [id=" + id + ", inPackage=" + inPackage + ", inClass=" + inClass + ", methodName=" + methodName
				+ ", LOC=" + LOC + ", CYCLO=" + CYCLO + ", ATFD=" + ATFD + ", LAA=" + LAA + ", is_long_method="
				+ is_long_method + ", iPlasma=" + iPlasma + ", PMD=" + PMD + ", is_feature_envy=" + is_feature_envy
				+ "]";
	}

}
