package project.ServerToMany;
import project.GUI;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ServerForMany {
    public static final List<Socket> socketList =
            Collections.synchronizedList(new ArrayList<>());

    public static final List<String> nameList =
            Collections.synchronizedList(new ArrayList<>());
    public static void startServer(int port)  {
        try {
            GUI.textAreaForMessage.append("服务端" + InetAddress.getLocalHost() + "已启动~\n");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        var ref = new Object() {
            Thread thread = null;
        };

        ref.thread = new Thread(() -> {
            try(
                    ServerSocket serverSocket = new ServerSocket(port)
            ){
                while (true){
                    //多线程处理多条socket管道，故结束的时候可以监测每条客户端的情况
                    Socket socket = serverSocket.accept();
                    socketList.add(socket);
                    Runnable runnable = new ServerMyRunnable(socket);
                    Thread thread = new Thread(runnable);
                    thread.start();
                }
            }catch (Exception e){
                ref.thread.interrupt();
                e.getStackTrace();
            }
        });
        ref.thread.start();
    }
}
