package socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-02-24 23:17
 **/

public class server {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(65001);
        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(packet);
        byte[] data = packet.getData();
        String content = new String(data, 0, packet.getLength());
        System.out.println(content);
        byte[] sendedContent = String.valueOf(content.length()).getBytes();
        DatagramPacket packetToClient = new DatagramPacket(sendedContent,
                sendedContent.length,
                packet.getAddress(), packet.getPort());
        datagramSocket.send(packetToClient);
    }
}
