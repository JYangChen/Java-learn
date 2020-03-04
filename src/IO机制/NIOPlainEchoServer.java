package IO机制;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 22:28
 **/

public class NIOPlainEchoServer {
    public void serve(int port) throws IOException {
        System.out.println("Listening for connections on port " +
                port);
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket ss = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        ss.bind(address);
        serverChannel.configureBlocking(false); //设置为非阻塞状态
        Selector selector = Selector.open();
        // 将channel 注册到 selector 里，并说明让 selector关注的点，这里是关注建立连接这个事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            try {
                // 阻塞等待就绪的 Channel，即没有与客户端建立连接前就一直轮询
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            // 获取到 Selector 里所有就绪的 SelectedKey 实例，将每一个channel注册到一个 selector 就会产生一个 SelecterKey
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                // 将就绪的 SelectedKey从Selector中移除，因为马上就要去处理它，防止重复执行
                iterator.remove();
                try {
                    // 若 SelectedKey 处于 Acceptable 状态
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        // 接受客户端的连接
                        SocketChannel client = server.accept();
                        System.out.println("Accepted connection from " + client);
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, ByteBuffer.allocate(100));
                    }
                    if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        // 从channel里读取数据存入到 ByteBuffer 里面
                        client.read(output);
                    }
                    // 若 SelectedKey 处于可写状态
                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        // 将ByteBuffer里的数据写入到channel里
                        client.write(output);
                        output.compact(); // 将数据从缓存中移除
                    }
                } catch (IOException e) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException ce) {

                    }
                }
            }
        }
    }
}
