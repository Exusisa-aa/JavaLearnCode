package project.ServerToMany;


import project.GUI;
import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServerMyRunnable implements Runnable{
    private final Socket socket;

    private Lock lock = new ReentrantLock();


    public ServerMyRunnable(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        String index = "";
        try(
                InputStream is = socket.getInputStream();
        ) {
            DataInputStream dis = new DataInputStream(is);
            String name = dis.readUTF();

            if(name.startsWith("name")){
                ServerForMany.nameList.add(name);
                for (String s : ServerForMany.nameList) {
                    index += s;
                }
                sendMessage(index);
            }

            while (true){
                try {
                    String message = dis.readUTF();
                    if(message.equals("leave")){
                        lock.lock();
                        ServerForMany.nameList.remove(name);
                        index = "";
                        for (String s : ServerForMany.nameList) {
                            index += s;
                        }
                        lock.unlock();
                        sendMessage(index);
                    }else {
                        sendMessage(message);
                    }
                } catch (IOException e) {
                    e.getStackTrace();
                    break;
                }
            }
        }catch (Exception e){
            SwingUtilities.invokeLater(() ->
                    GUI.textAreaForMessage.append("对方未响应，请重新连接\n")
            );
            try {
                socket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void sendMessage(String message){
        List<Socket> toRemove = new ArrayList<>();

        for (Socket socket : ServerForMany.socketList) {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(message);
                dos.flush();
            } catch (IOException e) {
                // 出现异常说明该客户端已断开
                toRemove.add(socket);
            }
        }

        // 移除无效 socket
        ServerForMany.socketList.removeAll(toRemove);
    }

}
