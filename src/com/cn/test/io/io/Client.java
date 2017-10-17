package com.cn.test.io.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private static final int DEFAULT_PORT = 12345;

	private static final String DEFAULT_SERVER_IP = "127.0.0.1";

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void send(String message) {
		send(DEFAULT_PORT, message);
	}

	public static void send(int port, String message) {
		System.out.println("算术表达式为：" + message);
		Socket socket = null;
		BufferedReader reader = null;
		PrintWriter writer = null;

		try {
			socket = new Socket(DEFAULT_SERVER_IP, port);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println(message);
			System.out.println("___结果为：" + reader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				reader = null;
			}
			if (writer != null) {
				writer.close();
				writer = null;
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				socket = null;
			}
		}

	}

}
