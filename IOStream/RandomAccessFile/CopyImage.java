package com.cognizant.henry.day8_20170629;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @description Copy image by three thread.
 * @author Henry
 * @version 0.0.1.20170629
 * 
 */
public class CopyImage {

	private static final int TOTAL_THREAD = 3;
	private static final Logger logger = LogManager.getLogger(CopyImage.class.getName());

	private String fileCurrentPath;
	private String fileCopyPath;
	private long fileSize;

	public CopyImage() {
		super();
	}

	/**
	 * 
	 * @description Construction method.
	 * @param fileCurrentPath
	 *            get file in this path.
	 * @param fileCopyPath
	 *            file copy to this path.
	 */
	public CopyImage(String fileCurrentPath, String fileCopyPath) {
		super();
		this.fileCurrentPath = fileCurrentPath;
		this.fileCopyPath = fileCopyPath;
	}

	/**
	 * @description copy image.
	 * 
	 */
	public boolean copyImage() {
		if (prepare()) {
			doingCopy();
			return true;
		}

		return false;
	}

	private void doingCopy() {
		long beginPos = 0;
		long endPos = fileSize / TOTAL_THREAD;
		for (int i = 1; i <= TOTAL_THREAD; i++) {
			Thread tmp = new Thread(new CopyThread(fileCurrentPath, fileCopyPath, beginPos, endPos));
			tmp.start();

			beginPos = endPos;
			if (i == TOTAL_THREAD) {
				endPos = fileSize;
			} else {
				endPos = endPos + (fileSize / TOTAL_THREAD);
			}
		}
	}

	/**
	 * @description check if the file exists.
	 * @param path
	 *            the path of file.
	 * 
	 */
	private boolean checkExists(String path) {

		File file = new File(path);
		if (file.isFile()) {
			return true;
		}
		return false;
	}

	/**
	 * @description Prepare for copy.
	 * 
	 */
	private boolean prepare() {
		if (checkExists(fileCurrentPath)) {
			fileSize = getFileLength();
			if (setCopyFileLength(fileSize)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @description get current file length.
	 * 
	 */
	private long getFileLength() {
		RandomAccessFile read = null;
		try {
			read = new RandomAccessFile(fileCurrentPath, "r");
			return read.length();
		} catch (FileNotFoundException e) {
			logger.error("File not found.");
			return 0;
		} catch (IOException e) {
			logger.error("Can not get file length.");
			return 0;
		} finally {
			closeIO(read, "Close reader failed.");
		}
	}

	/**
	 * @description set copy file length.
	 * 
	 */
	private boolean setCopyFileLength(long length) {
		RandomAccessFile writer = null;
		try {
			writer = new RandomAccessFile(fileCurrentPath, "rw");
			writer.setLength(length);

			return true;
		} catch (FileNotFoundException e) {
			logger.error("File not found.");

		} catch (IOException e) {
			logger.error("Can not set file length.");

		} finally {
			closeIO(writer, "Close writer failed.");
		}
		return false;
	}

	/**
	 * @description close IO stream.
	 * 
	 */
	private void closeIO(Closeable io, String errMsg) {
		try {
			if (io != null) {
				io.close();
			}
		} catch (IOException e) {
			logger.error(errMsg);
		}
	}

	/**
	 * @return the fileCurrentPath
	 */
	public String getFileCurrentPath() {
		return fileCurrentPath;
	}

	/**
	 * @param fileCurrentPath
	 *            the fileCurrentPath to set
	 */
	public void setFileCurrentPath(String fileCurrentPath) {
		this.fileCurrentPath = fileCurrentPath;
	}

	/**
	 * @return the fileCopyPath
	 */
	public String getFileCopyPath() {
		return fileCopyPath;
	}

	/**
	 * @param fileCopyPath
	 *            the fileCopyPath to set
	 */
	public void setFileCopyPath(String fileCopyPath) {
		this.fileCopyPath = fileCopyPath;
	}

	/**
	 * @return the fileSize
	 */
	public long getFileSize() {
		return fileSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CopyImage [fileCurrentPath=" + fileCurrentPath + ", fileCopyPath=" + fileCopyPath + ", fileSize="
				+ fileSize + "]";
	}
}
