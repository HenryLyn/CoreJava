/**
 * @description A class for course.
 * @author Henry
 * @version 0.0.1.20170627
 * 
 * */
public class Course {

	private String corName;
	private double usualScore;
	private double midScore;	// middle exam score.
	private double praScore;	// practice score.
	private double finalScore;	// final exam score.
	private double genScore; // general score.
	
	public Course(){
		
	}
	
	/**
	 * @param corName 
	 * 			course name.
	 * @param usualScore
	 * 			course usual score.
	 * @param midScore
	 * 			course middle exam score.
	 * @param praScore
	 * 			course practice score.
	 * @param finalScore
	 * 			course final exam score.
	 * @param genScore
	 * 			course general score.
	 */
	public Course(String corName, double usualScore, double midScore, double praScore, double finalScore,
			double genScore) {
		super();
		this.corName = corName;
		this.usualScore = usualScore;
		this.midScore = midScore;
		this.praScore = praScore;
		this.finalScore = finalScore;
		this.genScore = genScore;
	}

	/**
	 * @return the corName
	 */
	public String getCorName() {
		return corName;
	}

	/**
	 * @param corName
	 *            the corName to set
	 */
	public void setCorName(String corName) {
		this.corName = corName;
	}

	/**
	 * @return the usualScore
	 */
	public double getUsualScore() {
		return usualScore;
	}

	/**
	 * @param usualScore
	 *            the usualScore to set
	 */
	public void setUsualScore(double usualScore) {
		this.usualScore = usualScore;
	}

	/**
	 * @return the midScore
	 */
	public double getMidScore() {
		return midScore;
	}

	/**
	 * @param midScore
	 *            the midScore to set
	 */
	public void setMidScore(double midScore) {
		this.midScore = midScore;
	}

	/**
	 * @return the praScore
	 */
	public double getPraScore() {
		return praScore;
	}

	/**
	 * @param praScore
	 *            the praScore to set
	 */
	public void setPraScore(double praScore) {
		this.praScore = praScore;
	}

	/**
	 * @return the finalScore
	 */
	public double getFinalScore() {
		return finalScore;
	}

	/**
	 * @param finalScore
	 *            the finalScore to set
	 */
	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}

	/**
	 * @return the genScore
	 */
	public double getGenScore() {
		return genScore;
	}

	/**
	 * @param genScore
	 *            the genScore to set
	 */
	public void setGenScore(double genScore) {
		this.genScore = genScore;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "corName=" + corName + ", usualScore=" + usualScore + ", midScore=" + midScore + ", praScore="
				+ praScore + ", finalScore=" + finalScore + ", genScore=" + genScore;
	}
	
}
