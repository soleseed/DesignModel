package com.cn.jvm.test.jvm.thread.threadpool;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {

	static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<HttpRequestHandler>(1);

	static String basePath;

	static ServerSocket serverSocket;

	private static int port = 8080;

	public static void setPort(int port) {
		if (port > 0) {
			SimpleHttpServer.port = port;
		}
	}

	public static void setBasepath(String path) {
		if (path != null && new File(path).exists() && new File(path).isDirectory()) {
			SimpleHttpServer.basePath = path;
		}
	}

	public static void start() throws IOException {
		serverSocket = new ServerSocket(port);
		Socket socket = null;
		while ((socket = serverSocket.accept()) != null) {
			// 接收一个客户端socket,生成一个httprequesthandler,放入线程池
			threadPool.execute(new HttpRequestHandler(socket));
		}
		socket.close();
	}

	static class HttpRequestHandler implements Runnable {

		private Socket socket;

		public HttpRequestHandler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

		private void close(Closeable... closeables) {
			if (closeables != null) {
				for (Closeable closeable : closeables) {
					try {
						closeable.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}
}
