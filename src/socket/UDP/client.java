package socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-02-24 23:18
 **/

public class client {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] buffer = "Hello Bitch".getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
                address, 65001);
        datagramSocket.send(packet);
        byte[] data = new byte[100];
        DatagramPacket receivePacket = new DatagramPacket(data, data.length);
        datagramSocket.receive(receivePacket);
        String content = new String(receivePacket.getData(), 0,
                receivePacket.getLength());
        System.out.println(content);
    }
}
