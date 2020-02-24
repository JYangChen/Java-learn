package socket.TCP;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-02-24 23:13
 **/

public class server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(65000);
        while (true) {
            Socket socket = ss.accept();
            new LengthCalculator(socket).start();
        }
    }
}
