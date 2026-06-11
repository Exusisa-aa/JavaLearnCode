package project.ClientToOne;

import project.GUI;
import project.ServerToOne.ServerToOne;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Objects;

public class ClientToOne {
    public static ActionListener actionListener;
    public static void startClient(InetAddress friendIP,int port,String name){

        var ref = new Object() {
            Thread thread = null;
            String message = "";
            boolean flag = false;
        };

        GUI.sendButton.setEnabled(true);

        ref.thread = new Thread(() -> {
            try(
                    Socket socket = new Socket()
            ) {
                GUI.textAreaForMessage.append("正在链接~~\n");
                socket.connect(new InetSocketAddress(friendIP, port));
                try(
                        OutputStream os = socket.getOutputStream();
                        DataOutputStream dos = new DataOutputStream(os)
                ) {
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

                    GUI.radioButton1.setEnabled(false);
                    GUI.radioButton2.setEnabled(false);

                        actionListener = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                if (!GUI.textFieldForMessage.getText().isEmpty()) {
                                    try {
                                        ref.message = GUI.textFieldForMessage.getText();
                                        GUI.textAreaForMessage.append(name + ":" + ref.message + "\n");
                                        dos.writeUTF(ref.message);
                                        GUI.textFieldForMessage.setText("");
                                        ref.message = "";
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                } else {
                                    GUI.textAreaForMessage.append("输入不能为空~~\n");
                                }
                            }
                        };
                    GUI.sendButton.addActionListener(actionListener);
                    while (true) {
                        GUI.breakButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    ref.flag = true;
                                    socket.close();
                                    ServerToOne.dis.close();
                                    GUI.sendButton.removeActionListener(actionListener);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });
                        if(ref.flag){
                            GUI.textAreaForMessage.append(name + "已断开~~\n");
                            GUI.textArea.setText("");

                            break;
                        }
                    }

                }catch (SocketTimeoutException e){
                    e.getStackTrace();
                }
            }catch (Exception e){
                SwingUtilities.invokeLater(() ->
                        GUI.textAreaForMessage.append("对方服务器未上线,已自动退出~~\n")
                );
                e.getStackTrace();
            }
        });
        ref.thread.start();
    }
}
