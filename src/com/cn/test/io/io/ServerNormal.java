package com.cn.test.io.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerNormal {

	private static final int DEFAULT_PORT = 12345;

	private static ServerSocket server;

	public ServerNormal() {
		// TODO Auto-generated constructor stub
	}

	public static void start() throws IOException {
		start(DEFAULT_PORT);
	}

	public synchronized static void start(int port) throws IOException {
		if (server != null) {
			return;
		}
		try {
			server = new ServerSocket(port);
			System.out.println("服务器已启动，端口号：" + port);
			
			while (true) {
				Socket socket = server.accept();
				new Thread(new ServerHandler(socket)).start();
			}
			 
		} finally {
			if (server != null) {
				server.close();
				System.out.println("服务器已关闭");
				server = null;
			}
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// 运行服务器
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ServerNormal.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		// 避免客户端先于服务器启动前执行代码
		Thread.sleep(100);
		// 运行客户端
		char operators[] = { '+', '-', '*', '/' };
		Random random = new Random(System.currentTimeMillis());
		new Thread(new Runnable() {
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				while (true) {
					// 随机产生算术表达式
					String expression = random.nextInt(10) + "" + operators[random.nextInt(4)]
							+ (random.nextInt(10) + 1);
					Client.send(expression);
					try {
						Thread.currentThread().sleep(random.nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
