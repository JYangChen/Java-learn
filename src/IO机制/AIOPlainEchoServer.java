package IO机制;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 22:43
 **/

public class AIOPlainEchoServer {

    public void serve (int port) throws IOException {
        System.out.println("Listening for connections on port " + port);
        final AsynchronousServerSocketChannel serverChannel =
                AsynchronousServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(port);
        serverChannel.bind(address);
        final CountDownLatch latch = new CountDownLatch(1);
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>(){
            @Override
            public void completed(final AsynchronousSocketChannel channel, Object attachment) {
                // 一旦完成处理，再次接收新的客户端请求
                serverChannel.accept(null, this);
                ByteBuffer buffer = ByteBuffer.allocate(100);
                // 在channel里植入一个读操作 EchoCompletionHandler，一旦buffer有数据写入，EchoCompletionHandler 便会被唤醒
                channel.read(buffer, buffer, new EchoCompletionHandler(channel));
            }
            @Override
            public void failed(Throwable throwable, Object attachment) {
                try {
                    // 若遇到异常，关闭 channel
                    serverChannel.close();
                } catch (IOException e) {

                } finally {
                    latch.countDown();
                }
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private final class EchoCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
        private final AsynchronousSocketChannel channel;
        EchoCompletionHandler(AsynchronousSocketChannel channel) {
            this.channel = channel;
        }
        @Override
        public void completed(Integer result, ByteBuffer buffer) {
            buffer.flip();
            channel.write(buffer, buffer, new CompletionHandler<Integer,
                                ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer buffer) {
                    if (buffer.hasRemaining()) {
                        channel.write(buffer, buffer, this);
                    } else {
                        buffer.compact();
                        channel.read(buffer, buffer, EchoCompletionHandler.this);
                    }
                }
                @Override
                public void failed (Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {

                    }
                }
            });
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {

        }
    }

}
