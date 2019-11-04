package project.GUI;

public class Method {

	private double id;
	private String inClass;
	private String methodName;
	private double LOC;
	private double CYCLO;
	private double ATFD;
	private double LAA;
	private boolean is_long_method;
	private boolean iPlasma;
	private boolean PMD;
	private boolean is_feature_envy;

	public Method(double id, String inClass, String methodName, double LOC, double CYCLO, double ATFD, double LAA,
			boolean is_long_method, boolean iPlasma, boolean PMD, boolean is_feature_envy) {
		this.id = id;
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
}
