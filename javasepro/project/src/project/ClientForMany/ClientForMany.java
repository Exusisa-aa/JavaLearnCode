package project.ClientForMany;

import project.GUI;
import project.ServerToMany.ServerForMany;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class ClientForMany {
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
                    Socket socket = new Socket(friendIP, port);
                    OutputStream os = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os)
            ) {
                GUI.textAreaForMessage.append(name + "已上线~~\n");
                dos.writeUTF("name" + name);

                GUI.radioButton1.setEnabled(false);
                GUI.radioButton2.setEnabled(false);

                Runnable runnable = new ClientMyRunnable(socket, name);
                Thread thread = new Thread(runnable);
                thread.start();

                actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (!GUI.textFieldForMessage.getText().trim().isEmpty()) {
                            try {
                                ref.message = name + ":" + GUI.textFieldForMessage.getText();
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
                                GUI.textArea.setText("");
                                dos.writeUTF("leave");
                                dos.flush();
                                ref.flag = true;
                                GUI.sendButton.removeActionListener(actionListener);
                                GUI.sendButton.setEnabled(false);
                                Timer timer = new Timer(2000, f -> {
                                    GUI.connectButton1.setEnabled(true);
                                });
                                timer.setRepeats(false);//执行一次
                                timer.start();
                            } catch (IOException ex) {
                                //ignore
                            }
                        }
                    });
                    if (ref.flag) {
                        GUI.textAreaForMessage.append(name + "已断开~~\n");
                        ServerForMany.socketList.remove(socket);
                        GUI.sendButton.removeActionListener(ClientForMany.actionListener);

                        GUI.radioButton1.setEnabled(true);
                        GUI.radioButton2.setEnabled(true);
                        break;
                    }
                }

            } catch (Exception e) {
                e.getStackTrace();
            }
        });
        ref.thread.start();
    }


}
