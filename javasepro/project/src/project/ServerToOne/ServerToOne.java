package project.ServerToOne;

import project.ClientToOne.ClientToOne;
import project.GUI;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class ServerToOne {
    //TCP服务端
    public static DataInputStream dis = null;

    public static void startServer(int port,String name) {
        GUI.textAreaForMessage.append("服务器已启动~~\n");

        var ref = new Object() {
            Thread thread = null;
        };

        ref.thread = new Thread(() -> {
            try(
                    ServerSocket serverSocket = new ServerSocket(port)
            ){
                try(
                        Socket socket = serverSocket.accept();
                        InputStream is = socket.getInputStream()
                ) {
                    ServerToOne.dis = new DataInputStream(is);
                    GUI.textAreaForMessage.append("对方已上线~~\n");
                    if(!GUI.textArea.getText().isEmpty()){
                        boolean flag = true;
                        String [] names = GUI.textArea.getText().split("\n");
                        for (String s : names) {
                            if(Objects.equals(s,name)) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            GUI.textArea.append(name+'\n');
                        }
                    }else {
                        GUI.textArea.append(name+'\n');
                    }
                    while (true){
                        try {
                            GUI.textAreaForMessage.append(name + ":" +dis.readUTF()+"\n");
                        } catch (IOException e) {
                            GUI.textAreaForMessage.append(name + "已断开~~\n");
                            GUI.sendButton.removeActionListener(ClientToOne.actionListener);
                            GUI.textArea.setText("");

                            GUI.radioButton1.setEnabled(true);
                            GUI.radioButton2.setEnabled(true);
                            GUI.sendButton.setEnabled(false);
                            ref.thread.interrupt();
                            return;
                        }
                    }
                }catch (Exception e){
                    SwingUtilities.invokeLater(() ->
                            GUI.textAreaForMessage.append("对方未响应，请重新连接\n")
                    );
                    serverSocket.close();
                }
            }catch (Exception e){
                e.getStackTrace();
            }
        });
        ref.thread.start();
    }




}
