package com.cognizant.henry.day8_20170629;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CopyThread implements Runnable {

	private static final Logger logger = LogManager.getLogger(CopyImage.class.getName());
	private static final int BUFFER_SIZE = 1024;

	private String fileCurrentPath;
	private String fileCopyPath;
	private long beginPos;
	private long endPos;

	public CopyThread() {
		super();
	}

	/**
	 * @param fileCurrentPath
	 * @param fileCopyPath
	 * @param beginPos
	 * @param endPos
	 */
	public CopyThread(String fileCurrentPath, String fileCopyPath, long beginPos, long endPos) {
		super();
		this.fileCurrentPath = fileCurrentPath;
		this.fileCopyPath = fileCopyPath;
		this.beginPos = beginPos;
		this.endPos = endPos;
	}

	/**
	 * @description run.
	 * 
	 */
	@Override
	public void run() {
		if (!readAndWriteFile()) {
			logger.error("Copy error!");
		}
	}

	/**
	 * @description read file.
	 * 
	 */
	private boolean readAndWriteFile() {
		RandomAccessFile read = null;

		try {
			read = new RandomAccessFile(fileCurrentPath, "r");
			read.seek(beginPos);
			byte[] buf = new byte[BUFFER_SIZE];
			int offset;
			long prePos = beginPos;
			int len;
			while (prePos < endPos) {
				offset = read.read(buf);
				if ((prePos + offset) < endPos) {
					len = offset;
				} else {
					len = (int) (endPos - prePos);
				}
				if (!writeFile(prePos, buf, 0, len)) {
					return false;
				}
				prePos = read.getFilePointer();
			}
			return true;
		} catch (FileNotFoundException e) {
			logger.error("File not found.");

		} catch (IOException e) {
			logger.error("Can not read file.");

		} finally {
			closeIO(read, "close reader failed.");
		}

		return false;
	}

	/**
	 * @description write file.
	 * 
	 */
	private boolean writeFile(long pos, byte[] buf, int begin, int len) {

		RandomAccessFile write = null;
		try {
			write = new RandomAccessFile(fileCopyPath, "rw");
			write.seek(pos);
			write.write(buf, begin, len);

			return true;
		} catch (FileNotFoundException e) {
			logger.error("File not found!");
		} catch (IOException e) {
			logger.error("File can not write.");
		} finally {
			closeIO(write, "Can not close writer.");
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
}
