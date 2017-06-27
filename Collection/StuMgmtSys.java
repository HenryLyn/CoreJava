import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 
 * @description A student management system.
 * @author henry
 * @version 0.0.1.20170627
 * 
 */

public class StuMgmtSys {

	private final static int TOTAL_COURSE = 3;
	private final static int TOTAL_SCORE_NUM = 4;
	private final static String COURSE_NAMES[] = { "Java", "C", "C++" };
	private final static Student[] STUDENTS = { new Student("01", "stuOne", 10), new Student("02", "stuTwo", 20),
			new Student("03", "stuThree", 30) };
	private Map<Student, List<Course>> stuInfo = new HashMap<Student, List<Course>>();

	/**
	 * @description Construction method for initialize students information.
	 * 
	 */
	public StuMgmtSys() {
		initStudentsInfo();
	}

	/**
	 * @description initialize student information.
	 */
	private void initStudentsInfo() {
		for (int i = 0; i < STUDENTS.length; i++) {
			stuInfo.put(STUDENTS[i], initCourseInfo());
		}
	}

	/**
	 * @description Add course information.
	 */
	private List<Course> initCourseInfo() {
		List<Course> list = new ArrayList<Course>();
		for (int i = 0; i < TOTAL_COURSE; i++) {
			Course corTmp = new Course();
			corTmp.setCorName(COURSE_NAMES[i]);
			corTmp.setUsualScore(getScore());
			corTmp.setMidScore(getScore());
			corTmp.setPraScore(getScore());
			corTmp.setFinalScore(getScore());
			corTmp.setGenScore(Double.parseDouble(String.format("%.2f",
					(corTmp.getUsualScore() + corTmp.getMidScore() + corTmp.getPraScore() + corTmp.getFinalScore())
							/ TOTAL_SCORE_NUM)));
			list.add(corTmp);
		}

		return list;
	}

	/**
	 * @description Get a course score with two decimal places.
	 */
	private double getScore() {
		return Double.parseDouble(String.format("%.2f", ((Math.random() * 71) + 30)));
	}

	/**
	 * @description Get student scores.
	 * @param stuNum
	 *            student number.
	 */
	public void getStuScoresByNum(String stuNum) {
		if (null == stuNum) {
			return;
		}
		Set<Student> stuSet = stuInfo.keySet();
		for (Student stu : stuSet) {
			if (stuNum.equals(stu.getStuNum())) {
				System.out.println("Student : " + stu.getStuName());
				List<Course> list = stuInfo.get(stu);
				for (Course cor : list) {
					System.out.println(cor.toString());
				}
			}
		}
	}

	public void getGenScores(String corName) {
		if (null == corName) {
			return;
		}
		System.out.println("The general scores of " + corName);
		Set<Student> stuSet = stuInfo.keySet();
		int sum = 0;
		int count = 0;
		for (Student stu : stuSet) {
			if (null != stu) {
				List<Course> list = stuInfo.get(stu);
				for (Course cor : list) {
					if (corName.equals(cor.getCorName())) {
						sum += cor.getGenScore();
						count += 1;
						System.out.println(stu.getStuName() + " : " + cor.getGenScore());
					}
				}
			}
		}
		System.out.println(
				"The average of general scores is " + Double.parseDouble(String.format("%.2f", (sum * 1.0 / count))));
	}

	public int getTheNumOfStu(String corName, int begin, int end) {
		if ((null == corName) || (begin > end) || (begin < 0 || end > 100)) {
			return 0;
		}
		Set<Student> stuSet = stuInfo.keySet();
		int count = 0;
		for (Student stu : stuSet) {
			if (null != stu) {
				List<Course> list = stuInfo.get(stu);
				for (Course cor : list) {
					if (corName.equals(cor.getCorName())) {
						if (cor.getGenScore() >= begin && cor.getGenScore() < end) {
							count += 1;
						}
					}
				}
			}
		}
		return count;
	}
}
