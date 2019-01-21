package com.home.test.udpnetwork;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

// 비연결 지향점
// 속도가 중요할 경우 사용 
// UDP (User Dataram Protocol)
public class UdpSendExample {
	
	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket(); // datagram socket 생성
		
		System.out.println("[발신 시작]");
		
		for (int i = 1; i < 3; i++) {
			String data = "메세지" + i;
			byte[] byteArr = data.getBytes("UTF-8");
			
			DatagramPacket packet = new DatagramPacket(byteArr, byteArr.length, 
					new InetSocketAddress("localhost", 5001) );	// datagram packet 생성
			
			datagramSocket.send(packet);
			System.out.println("[보낸 바이트 수]: "+ byteArr.length + " bytes");
		}
		
		System.out.println("[발신 종료]");
		
		datagramSocket.close();
	}
}
