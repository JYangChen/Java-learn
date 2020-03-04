package IO机制;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 17:46
 **/

public class BIOPlainEchoServer {
    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        while (true) {
            final Socket clientSocket = socket.accept();
            System.out.println("Accepted connection from" + clientSocket);
            new Thread(new Runnable(){
                @Override
                public void run(){
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), false);
                        while(true){
                            writer.println(reader.readLine());
                            writer.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
    // 引入线程池来避免不必要的开销
    public void improvedServe(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        while(true){
            final Socket clientSocket = socket.accept();
            System.out.println("Accepted connection from" + clientSocket);
            executorService.execute(() -> {
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), false);
                    while(true){
                        writer.println(reader.readLine());
                        writer.flush();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            });
        }
    }
}
