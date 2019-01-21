package com.home.test.tcpnetwork;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// 연결 수락
public class ServerExample extends Application {
	
//	public static void main(String[] args) {
	
		ExecutorService excutorService;	//스레드풀 필드 선언
		ServerSocket serverSocket;
		List<Client> connections = new Vector<Client>(); // vector로 초기화
		
		
		void startServer() {
			// 서버 시작 코드
			excutorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors() // cpu 코어 수만큼 쓰레드 생성하기	
			);
			
			try {
				serverSocket = new ServerSocket();
				serverSocket.bind(new InetSocketAddress("localhost", 5001)); // serverSocket 생성
			} catch (Exception e) {
				if(serverSocket.isClosed()) {
					stopServer();
				}
				return;
			}
			
			// 연결 수락 코드, 쓰레드 내에서 돈다. 
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					Platform.runLater(() -> {
						displayText("[서버 시작]");
						btnStartStop.setText("stop");
					});
					// 작업이 도는 동안?
					while(true) {
						try {
							Socket socket = serverSocket.accept(); // 연결수락
							String message = "[연결  성공:"+ socket.getRemoteSocketAddress()
									+ " : "+ Thread.currentThread().getName() +"]";
							Platform.runLater(()->displayText(message));
							
							Client client = new Client(socket);
							connections.add(client);
							Platform.runLater(()->displayText("[연결 수락: " + connections.size() + "]"));
						} catch (Exception e) {
							if(serverSocket.isClosed()) {
								stopServer();
							}
							break;
						}
					}
				}
			};
			excutorService.submit(runnable); //스레드풀에서 처리
		}	// startServer() 메소드 엔드
		
		
		void stopServer() {
			// 서버 종료 코드 
			try {
				Iterator<Client> iterator = connections.iterator();
				while(iterator.hasNext()) {
					Client client = iterator.next();
					client.socket.close();
					iterator.remove();
				}
				if(serverSocket!=null && !serverSocket.isClosed()) {
					serverSocket.close(); // 소켓 서버 종료 
				}
				if(serverSocket!=null && !excutorService.isShutdown()) {
					excutorService.shutdown();	// 스레드 종료 
				}
				Platform.runLater(()->{
					displayText("[서버 멈춤]");
					btnStartStop.setText("start");
				});
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// 데이터 통신 코드
		class Client { 
			
			Socket socket;
			 
			Client(Socket socket){
			 this.socket = socket;
			 receive();
			}

			void receive() {
				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							while(true) {
								byte[] byteArr = new byte[100];
								InputStream inputStream = socket.getInputStream();
								
								// 데이터 받기
								int readByteCount = inputStream.read(byteArr);
								
								// 클라이언트가 비정상 종료를 했을 경우 IOException 발생
								if(readByteCount == -1) {
									throw new IOException();
								}
								
								// 클라이언트가 정상적으로 socket의 close()를 호출햇을 경우
								String message = "[요청 처리]: " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
								Platform.runLater(()->displayText(message));
								
								// 문자열로 변환
								String data = new String(byteArr, 0, readByteCount, "UTF-8");
								
								// 모든 클라이언트에게 보냄.
								for(Client client : connections) {
									client.send(data); 
								}
							}
							
						} catch (Exception e) {
							// TODO: handle exception
							try {
								connections.remove(Client.this);
								String message = "[클라이언트 통신 안됨: " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
								Platform.runLater(()->displayText(message));
								socket.close();
							} catch (IOException e2) {}
						}
					}
				};
				excutorService.submit(runnable); // 스레드풀에서 처리하기. 
			}
			
			// 클라이언트로 메세지를 보내는 코드 
			void send(String data) {
				Runnable runnable = new Runnable() { // 보내기 작업 생성 
					@Override
					public void run() {
						try {
							// 클라이언트에게 메세지보내기 
							byte[] byteArr = data.getBytes("UTF-8");
							OutputStream outputStream = socket.getOutputStream();
							outputStream.write(byteArr);
							outputStream.flush();
						} catch(Exception e) {
							try {
								String message = "[클라이언트 통신 안됨: " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
								Platform.runLater(()->displayText(message));
								connections.remove(Client.this);
								socket.close();
							} catch (IOException e2) {}
						}
					}
				};
				excutorService.submit(runnable);	// 스레드풀에서 처리
			}
		}
		
	//////////// UI 생성 코드 
	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	Button btnStartStop;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);

		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		btnStartStop.setOnAction(e -> {
			if (btnStartStop.getText().equals("start")) {
				startServer();
			} else if (btnStartStop.getText().equals("stop")) {
				stopServer();
			}
		});
		root.setBottom(btnStartStop);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.setOnCloseRequest(event -> stopServer());
		primaryStage.show();
	}

	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}

	public static void main(String[] args) {
		launch(args);
	}
		
//		
//		ServerSocket serverSocket = null;
//		try {
//			serverSocket = new ServerSocket();
//			serverSocket.bind(new InetSocketAddress("localhost", 5001)); // serverSocket 생성
//			
//			while (true) {
//				System.out.println("<<<<<<<<<< [server 연결 기다림]");
//				// 연결 요청
//				Socket socket = serverSocket.accept(); 
//				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
//				System.out.println("<<<<<<<<<< [server 연결 수락함]" + isa.getHostName());
//				
//				// client로부터 데이터 받고, 보내기
//				byte[] bytes = null;
//				String message = null;
//				
//				InputStream is = socket.getInputStream();
//				bytes = new byte[100];
//				int readByteCount = is.read(bytes);
//				message = new String(bytes, 0, readByteCount, "UTF-8");
//				System.out.println("[client 에서 메세지 받는거 성공] :"+message);
//				
//				OutputStream os = socket.getOutputStream();
//				message = "hello client~!";
//				bytes = message.getBytes("UTF-8");
//				os.write(bytes);
//				os.flush(); //?
//				System.out.println("[client 에게 메세지 보내는거 성공]");
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		// serverSocket이 닫혀있지 않을 경우 
//		if(serverSocket.isClosed()) {
//			try {
//				serverSocket.close();
//			} catch (Exception e1) {
//				// TODO: handle exception
//			}
//		}
//	}

	
}
