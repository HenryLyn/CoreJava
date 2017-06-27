
/**
 * @description A class for student.
 * @author Henry
 * @version 0.0.1.20170627
 * 
 */
public class Student {

	private String stuNum;
	private String stuName;
	private int stuAge;

	public Student() {

	}

	/**
	 * @param stuNum
	 *            student number.
	 * @param stuName
	 *            student name.
	 * @param stuAge
	 *            student age.
	 */
	public Student(String stuNo, String stuName, int stuAge) {
		super();
		this.stuNum = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
	}

	/**
	 * @return the stuNum
	 */
	public String getStuNum() {
		return stuNum;
	}

	/**
	 * @param stuNum
	 *            the stuNum to set
	 */
	public void setStuNum(String stuNo) {
		this.stuNum = stuNo;
	}

	/**
	 * @return the stuName
	 */
	public String getStuName() {
		return stuName;
	}

	/**
	 * @param stuName
	 *            the stuName to set
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	/**
	 * @return the stuAge
	 */
	public int getStuAge() {
		return stuAge;
	}

	/**
	 * @param stuAge
	 *            the stuAge to set
	 */
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
}
