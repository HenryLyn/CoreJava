
public class Main {

	public static void main(String[] args) {
		String curPath = "c://test.txt";
		String bakPath = "c://test_bak.txt";
		String bakPathNotExists = "c://test/test_bak.txt";

		BackupFile bf = new BackupFile(curPath, bakPath);
		if (bf.backupFile()) {
			System.out.println("Backup file successed!");
		} else {
			System.out.println("Backup file failed.");
		}

		bf.setFileBackupPath(bakPathNotExists);
		if (bf.backupFile()) {
			System.out.println("Backup file successed!");
		} else {
			System.out.println("Backup file failed.");
		}
	}

}
