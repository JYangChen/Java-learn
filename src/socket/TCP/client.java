package socket.TCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-02-24 23:15
 **/

public class client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 65000);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        os.write(new String("Hello World").getBytes());
        int ch = 0;
        byte[] buffer = new byte[1024];
        ch = is.read(buffer);
        String content = new String(buffer, 0, ch);
        System.out.println(content);
        is.close();
        os.close();
        socket.close();
    }
}
