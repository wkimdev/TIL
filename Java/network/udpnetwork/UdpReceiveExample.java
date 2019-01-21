package com.home.test.udpnetwork;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveExample extends Thread {
	
	public static void main(String[] args) throws SocketException, InterruptedException {
		// port에서 수신하는 datagramsocket설정
		DatagramSocket datagramSocket = new DatagramSocket(5001);
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				System.out.println("[수신 시작]");
				
				try {
					while(true) {
						// 데이터를 받고 
						// datagram packet수신
						DatagramPacket packet = new DatagramPacket(new byte[100], 100);
						datagramSocket.receive(packet);
						
						// 받은 데이터가 BYTE단위 이기때문에 string으로 바꿔서 뿌린다.
						// Constructs a new String by decoding the specified subarray of bytes using the specified charset.
						String data = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
						System.out.println("[받은 내용: "+ packet.getSocketAddress() + " ]" + data);
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("[수신 종료]");
				}
			}
		};
		thread.start();
		
		Thread.sleep(10000);
		datagramSocket.close();
	}
	
}
