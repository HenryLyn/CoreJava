
public class Main {

	private static final int TIMES = 3;
	private static final String REG = "[0-9]+";

	public static void main(String[] args) {
		StuMgmtSys sms = new StuMgmtSys();
		System.out.println("*************************************************");
		sms.getStuScoresByNum("01");
		sms.getStuScoresByNum("02");
		System.out.println("*************************************************");
		sms.getGenScores("Java");
		System.out.println("*************************************************");
		System.out.println("The number os student is :" + sms.getTheNumOfStu("Java", 30, 90));

	}
}
