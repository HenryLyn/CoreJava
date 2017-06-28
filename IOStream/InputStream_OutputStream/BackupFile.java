import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @description Backup file.
 * @author Henry
 * @version 0.0.1.20170628
 * 
 */

public class BackupFile {

	private String fileCurrentPath;
	private String fileBackupPath;
	private InputStream in;
	private OutputStream out;
	private BufferedInputStream bufIn;
	private BufferedOutputStream bufOut;

	public BackupFile() {
		super();
	}

	/**
	 * @param fileCurrentPath
	 *            the current path of file.
	 * @param fileBackupPath
	 *            the backup path of file.
	 */
	public BackupFile(String fileCurrentPath, String fileBackupPath) {
		super();
		this.fileCurrentPath = fileCurrentPath;
		this.fileBackupPath = fileBackupPath;
	}

	/**
	 * @description backup file.
	 */
	public boolean backupFile() {
		if (checkFileExists()) {
			if (readAndWriteCurrentFile()) {
				return true;
			}
		}

		return false;

	}

	/**
	 * @description check if the file is exists.
	 */
	private boolean checkFileExists() {

		boolean isExists = false;

		if ((null == fileCurrentPath || ("" == fileCurrentPath)) && (null == fileBackupPath)
				|| ("" == fileBackupPath)) {

			return isExists;
		}

		// check if the current file is exists.
		File file = new File(fileCurrentPath);
		if (file.exists()) {

			// check if the backup file is exists.
			// if not, create a new file for back up.
			file = new File(fileBackupPath);
			if (file.exists()) {
				isExists = true;
			} else {
				try {
					int end = fileBackupPath.lastIndexOf("/");
					file = new File(fileBackupPath.substring(0, end));
					file.mkdir();
					file = new File(fileBackupPath);
					isExists = file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return isExists;
	}

	/**
	 * @description read the current file.
	 */
	private boolean readAndWriteCurrentFile() {
		try {
			in = new FileInputStream(fileCurrentPath);
			bufIn = new BufferedInputStream(in);
			byte buf[] = new byte[1024];
			int len = 0;
			while ((len = bufIn.read(buf)) != -1) {
				if (!writeBackupFile(buf, len)) {
					return false;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;

		} finally {
			closeIStream();
		}

		return true;
	}

	/**
	 * @description write the backup file.
	 * @param buf
	 *            the buffer of output stream.
	 * @param len
	 *            the current data length.
	 */
	private boolean writeBackupFile(byte[] buf, int len) {

		try {
			out = new FileOutputStream(fileBackupPath);
			bufOut = new BufferedOutputStream(out);
			bufOut.write(buf, 0, len);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeOStream();
		}

		return true;
	}

	/**
	 * @description close the input stream.
	 */
	private void closeIStream() {
		try {
			if (null != bufIn) {
				bufIn.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (null != in) {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description close the input stream.
	 */
	private void closeOStream() {
		try {
			if (null != bufOut) {
				bufOut.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (null != out) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the filePath
	 */
	public String getFileCurrentPath() {
		return fileCurrentPath;
	}

	/**
	 * @param filePath
	 *            the filePath to set
	 */
	public void setFileCurrentPath(String filePath) {
		this.fileCurrentPath = filePath;
	}

	/**
	 * @return the fileBackupPath
	 */
	public String getFileBackupPath() {
		return fileBackupPath;
	}

	/**
	 * @param fileBackupPath
	 *            the fileBackupPath to set
	 */
	public void setFileBackupPath(String fileBackupPath) {
		this.fileBackupPath = fileBackupPath;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BackupFile [fileCurrentPath=" + fileCurrentPath + ", fileBackupPath=" + fileBackupPath + "]";
	}

}
