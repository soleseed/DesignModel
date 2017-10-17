package com.cn.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileScanner {

	private static void listFiles(File f) throws InterruptedException {
		if (f == null) {
			throw new IllegalArgumentException();
		}
		if (f.isFile()) {
			Thread.sleep(5000);
			System.out.println(f);
			return;
		}
		File[] allFiles = f.listFiles();
		if (Thread.interrupted()) {
			throw new InterruptedException("文件扫描中断");
		}
		if (allFiles != null && allFiles.length > 0) {
			for (File file : allFiles) {
				listFiles(file);
			}
		}

	}

	public static String readFromConsole() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			bReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public FileScanner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		final Thread fileIteratorThread = new Thread() {
			public void run() {
				try {
					listFiles(new File("F:\\"));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		new Thread() {
			public void run() {
				while (true) {
					System.out.println(readFromConsole());
					if ("quite".equalsIgnoreCase(readFromConsole())) {
						if (fileIteratorThread.isAlive()) {
							fileIteratorThread.interrupt();
							return;
						}
					} else {
						System.out.println("输入quit退出文件扫描");
					}
				}
			}
		}.start();
		fileIteratorThread.start();
	}

}
