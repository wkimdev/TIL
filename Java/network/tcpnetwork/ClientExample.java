package com.home.test.tcpnetwork;

import java.awt.im.InputContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// 연결 요청
public class ClientExample extends Application {
	Socket socket;
	
	// 연결 시작 코드 
	void startClient() {
		Thread thread = new Thread() {	// 스레드 생성 
			@Override
			public void run() {
				try {
					socket = new Socket(); 
					socket.connect(new InetSocketAddress("localhost", 5001));
					Platform.runLater(()->{
						displayText("[연결 완료 : "  + socket.getRemoteSocketAddress() + "]");
						btnConn.setText("stop");
				        btnSend.setDisable(false);
					});
				} catch(Exception e) {
					Platform.runLater(()->displayText("[서버 통신 안됨]"));
					if(!socket.isClosed()) { stopClient(); }
					return;
				}
				receive();
			}
		};
		thread.start();
	}
	
	// 연결 끊기 코드
	void stopClient() {
		try {
			Platform.runLater(()->{
				displayText("[���� ����]");
				btnConn.setText("start");
				btnSend.setDisable(true);
			});
			if(socket!=null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {}
	}
	
	// 데이터 받기 코드
	void receive() {
		while(true) {
			try {
				byte[] byteArr = new byte[100];
				InputStream inputStream = socket.getInputStream();
				
				int readByteCount = inputStream.read(byteArr);
				
				if(readByteCount == -1) { throw new IOException(); }
				
				String data = new String(byteArr, 0, readByteCount, "UTF-8");
				
				Platform.runLater(()->displayText("[받기 완료] "  + data));
			} catch (Exception e) {
				Platform.runLater(()->displayText("[서버 통신 완료]"));
				stopClient();
				break;
			}
		}
	}
	
	
	// 데이터 전송 코드
	void send(String data) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {		
					byte[] byteArr = data.getBytes("UTF-8");
					// 서버로 데이터 보내기 
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(byteArr);
					outputStream.flush();
					Platform.runLater(()->displayText("[������ �Ϸ�]"));
				} catch(Exception e) {
					Platform.runLater(()->displayText("[���� ��� �ȵ�]"));
					stopClient();
				}				
			}
		};
		thread.start();
	}
	
	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);

		BorderPane bottom = new BorderPane();
		txtInput = new TextField();
		txtInput.setPrefSize(60, 30);
		BorderPane.setMargin(txtInput, new Insets(0, 1, 1, 1));

		btnConn = new Button("start");
		btnConn.setPrefSize(60, 30);
		btnConn.setOnAction(e -> {
			if (btnConn.getText().equals("start")) {
				startClient();
			} else if (btnConn.getText().equals("stop")) {
				stopClient();
			}
		});

		btnSend = new Button("send");
		btnSend.setPrefSize(60, 30);
		btnSend.setDisable(true);
		btnSend.setOnAction(e -> send(txtInput.getText()));

		bottom.setCenter(txtInput);
		bottom.setLeft(btnConn);
		bottom.setRight(btnSend);
		root.setBottom(bottom);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.setOnCloseRequest(event -> stopClient());
		primaryStage.show();
	}

	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
//	public static void main(String[] args) {
//		
//		Socket socket = null;
//		try {
//			socket = new Socket();
//			System.out.println("[client 연결 요청] >>>>>>>");
//			// 연결 요청 코드 
//			socket.connect(new InetSocketAddress("localhost", 5001));
//			System.out.println("[client 연결 성공] >>>>>>>");
//			
//			// 서버에게 메세지를 보내기
//			byte[] bytes = null;
//			String message = null;
//			
//			OutputStream os = socket.getOutputStream();
//			message = "hello server~";
//			bytes = message.getBytes("UTF-8");
//			os.write(bytes);
//			os.flush(); //?
//			System.out.println("[server에게 메세지 보내는거 성공]");
//			
//			// 서버에게 메세지를 받기
//			InputStream is = socket.getInputStream();
//			bytes = new byte[100];
//			int readByteCount = is.read(bytes);
//			message = new String(bytes, 0, readByteCount, "UTF-8");
//			System.out.println("[server 서버 메세지 받는거 성공] :"+message);
//			
//			// 끊기
//			os.close();
//			is.close();
//			
//		} catch (UnknownHostException e) {
//			// TODO: handle exception ip표기가 잘 못 되었을 경우 
//		} catch (IOException e) {
//			// TODO: handle exception 해당 포트와 서버 연결 안됨
//		}
//		
//		// 연결이 되어있을 경우 
//		if(!socket.isClosed()) {
//			try {
//				socket.close();
//			} catch (IOException e) {
//				// TODO: handle exception
//			}
//		}
//	}
	
}
