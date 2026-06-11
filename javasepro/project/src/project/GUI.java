package project;


import project.ClientForMany.ClientForMany;
import project.ClientToOne.ClientToOne;
import project.ServerToMany.ServerForMany;
import project.ServerToOne.ServerToOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;


public class GUI {
    public static JTextArea textAreaForMessage;
    public static JTextField textFieldForMessage;
    public static JButton sendButton;
    public static JButton breakButton;
    public static JTextArea textArea;
    public static JRadioButton radioButton1;
    public static JRadioButton radioButton2;

    public static JButton connectButton1;
    public static void main(String[] args) {

        // 创建主窗口
        JFrame frame = new JFrame("多用户信息广播系统-客户端");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(860, 470);
        frame.setLayout(new GridBagLayout()); // 使用 GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // 组件可水平拉伸
        gbc.insets = new Insets(2, 2, 2, 2);    // 控件之间的间距
        gbc.weighty = 0;    // 设置为 0，防止组件垂直拉伸
        gbc.anchor = GridBagConstraints.PAGE_START; // 控件靠上对齐

        // 标签与文本框组合示例
        JPanel column1 = new JPanel(new GridLayout(1, 1));
        column1.add(new JLabel(""));
        column1.add(new JLabel(""));

        JPanel column2 = new JPanel(new GridLayout(1, 1));
        JLabel labelForPort = new JLabel("我的服务器端口：");
        column2.add(labelForPort);
        JTextField textFieldForMyPort = new JTextField();
        column2.add(textFieldForMyPort);

        JPanel column3 = new JPanel(new GridLayout(1, 1));
        JLabel labelForName = new JLabel("对方的名称：");
        column3.add(labelForName);
        JTextField textFieldForFriendName = new JTextField();
        column3.add(textFieldForFriendName);

        JPanel column4 = new JPanel(new GridLayout(1, 1));
        JButton connectButton = new JButton("启动服务器");
        connectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        connectButton.setForeground(Color.RED);
        connectButton.setPreferredSize(new Dimension(10, 18));
        column4.add(connectButton);

        // 设置 GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.25; // 占 1/4 宽度
        frame.add(column1, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.25;
        frame.add(column2, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0.25;
        frame.add(column3, gbc);

        gbc.gridx = 3;
        gbc.weightx = 0.25;
        frame.add(column4, gbc);

        // 标签与文本框组合示例
        JPanel column5 = new JPanel(new GridLayout(1, 1));
        JLabel labelForFriendIP = new JLabel("对方的服务器ip：");
        column5.add(labelForFriendIP);
        JTextField textFieldForFriendIP = new JTextField();
        column5.add(textFieldForFriendIP);

        JPanel column6 = new JPanel(new GridLayout(1, 1));
        JLabel labelForFriendPort = new JLabel("对方的服务器端口：");
        column6.add(labelForFriendPort);
        JTextField textFieldForFriendPort = new JTextField();
        column6.add(textFieldForFriendPort);

        JPanel column7 = new JPanel(new GridLayout(1, 1));
        column7.add(new JLabel("我的名称："));
        JTextField textFieldForMyName = new JTextField();
        column7.add(textFieldForMyName);

        JPanel column8 = new JPanel(new GridLayout(1, 1));
        connectButton1 = new JButton("连接服务器");
        connectButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        connectButton1.setForeground(Color.RED);
        connectButton1.setPreferredSize(new Dimension(10, 18));
        column8.add(connectButton1);

        // 设置 GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.25; // 占 1/4 宽度
        frame.add(column5, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.25;
        frame.add(column6, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0.25;
        frame.add(column7, gbc);

        gbc.gridx = 3;
        gbc.weightx = 0.25;
        frame.add(column8, gbc);


        // 单选按钮组
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        radioButton1 = new JRadioButton("群聊");
        radioButton2 = new JRadioButton("特定客户");
        radioButton2.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        radioButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        radioButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        radioButton1.setForeground(Color.BLUE);
        radioButton2.setForeground(Color.BLUE);
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        radioPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // 左边留出 20 像素
        frame.add(radioPanel, gbc);

        //发送文本
        textFieldForMessage = new JTextField();
        textFieldForMessage.setPreferredSize(new Dimension(10, 50));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 0.7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        textFieldForMessage.setFont(new Font("微软雅黑", Font.PLAIN, 24));
        frame.add(textFieldForMessage, gbc);

        JPanel sendAndBreakButtonPanel = new JPanel();
        sendButton = new JButton("发送信息");
        sendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sendButton.setForeground(Color.RED);
        sendButton.setEnabled(false);
        sendButton.setPreferredSize(new Dimension(115, 43));
        breakButton = new JButton("断开连接");
        breakButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        breakButton.setForeground(Color.RED);
        breakButton.setPreferredSize(new Dimension(115, 43));
        sendAndBreakButtonPanel.add(sendButton);
        sendAndBreakButtonPanel.add(breakButton);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(sendAndBreakButtonPanel, gbc);

        // 设置文本域
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("微软雅黑", Font.BOLD, 16));
        textArea.setRows(14); // 可选：设置默认行数
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        // 配置 GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 3;       // 第三行
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;   // 允许水平拉伸
        gbc.weighty = 0;     // 不允许垂直拉伸
        gbc.fill = GridBagConstraints.HORIZONTAL; // 水平填充可用空间
        gbc.anchor = GridBagConstraints.PAGE_START; //  控件靠上对齐

        // 添加带滚动条的文本域
        frame.add(new JScrollPane(textArea), gbc);

        // 设置文本域
        textAreaForMessage = new JTextArea();
        textAreaForMessage.setEditable(false);
        textAreaForMessage.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        textAreaForMessage.setRows(14); // 可选：设置默认行数
        textAreaForMessage.setBorder(BorderFactory.createEmptyBorder(5, 40, 0, 0));

        // 配置 GridBagConstraints
        gbc.gridx = 1;
        gbc.gridy = 3;       // 第三行
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;   // 允许水平拉伸
        gbc.weighty = 0;     // 不允许垂直拉伸
        gbc.fill = GridBagConstraints.HORIZONTAL; // 水平填充可用空间
        gbc.anchor = GridBagConstraints.PAGE_START; //  控件靠上对齐

        // 添加带滚动条的文本域
        frame.add(new JScrollPane(textAreaForMessage), gbc);



        // 可选：添加一个占位 JLabel 撑住下方空间
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(new JLabel(), gbc);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(connectButton.getText().equals("启动服务器")){
                    if(textFieldForMyPort.getText().matches("^(6553[0-5]|655[0-2][0-9]|65[0-4][0-9]{2}|6[0-4][0-9]{3}|[1-5][0-9]{4}|[1-9][0-9]{0,3})$")){
                        if(!textFieldForFriendName.getText().isEmpty()){
                            ServerToOne.startServer(Integer.parseInt(textFieldForMyPort.getText()),textFieldForFriendName.getText());
                        }else {
                            GUI.textAreaForMessage.append("请输入对方的昵称~~\n");
                        }
                    }else {
                        GUI.textAreaForMessage.append("请输入正确的端口号~~\n");
                    }
                }
                if(connectButton.getText().equals("创建群聊")){
                    if (textFieldForMyPort.getText().matches("^(6553[0-5]|655[0-2][0-9]|65[0-4][0-9]{2}|6[0-4][0-9]{3}|[1-5][0-9]{4}|[1-9][0-9]{0,3})$")) {
                        ServerForMany.startServer(Integer.parseInt(textFieldForMyPort.getText()));
                    } else {
                        GUI.textAreaForMessage.append("请输入正确的端口号~~\n");
                    }
                }
            }
        });

        connectButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connectButton1.getText().equals("连接服务器")) {
                    if(textFieldForFriendIP.getText().matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")){
                        if(textFieldForFriendPort.getText().matches("^(6553[0-5]|655[0-2][0-9]|65[0-4][0-9]{2}|6[0-4][0-9]{3}|[1-5][0-9]{4}|[1-9][0-9]{0,3})$")){
                            if(!textFieldForMyName.getText().isEmpty()){
                                if(textFieldForMyName.getText().equals(textFieldForFriendName.getText())){
                                    GUI.textAreaForMessage.append("两位的名字不能相同\n");
                                    return;
                                }
                                try {
                                    // 使用新线程执行网络操作，避免阻塞UI
                                    new Thread(() -> {
                                        try {
                                            ClientToOne.startClient(InetAddress.getByName(textFieldForFriendIP.getText()), Integer.parseInt(textFieldForFriendPort.getText()),textFieldForMyName.getText());
                                        } catch (Exception ex) {
                                            GUI.textAreaForMessage.append("连接异常: " + ex.getMessage() + "\n");
                                        }
                                    }).start();
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                            }else {
                                GUI.textAreaForMessage.append("请输入我的昵称~~\n");
                            }
                        }else {
                            GUI.textAreaForMessage.append("请输入正确的端口号~~\n");
                        }
                    }else {
                        GUI.textAreaForMessage.append("请输入正确的IP地址~~\n");
                    }
                }

                if (connectButton1.getText().equals("加入群聊")){
                    if(textFieldForFriendIP.getText().matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")){
                        if(textFieldForFriendPort.getText().matches("^(6553[0-5]|655[0-2][0-9]|65[0-4][0-9]{2}|6[0-4][0-9]{3}|[1-5][0-9]{4}|[1-9][0-9]{0,3})$")){
                            if(!textFieldForMyName.getText().isEmpty()){
                                try {
                                    // 使用新线程执行网络操作，避免阻塞UI
                                    new Thread(() -> {
                                        try {
                                            connectButton1.setEnabled(false);
                                            ClientForMany.startClient(InetAddress.getByName(textFieldForFriendIP.getText()), Integer.parseInt(textFieldForFriendPort.getText()),textFieldForMyName.getText());
                                        } catch (Exception ex) {
                                            GUI.textAreaForMessage.append("连接异常: " + ex.getMessage() + "\n");
                                        }
                                    }).start();
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                            }else {
                                GUI.textAreaForMessage.append("请输入我的昵称~~\n");
                            }
                        }else {
                            GUI.textAreaForMessage.append("请输入正确的端口号~~\n");
                        }
                    }else {
                        GUI.textAreaForMessage.append("请输入正确的IP地址~~\n");
                    }
                }
            }
        });

        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelForPort.setText("群聊的端口号：");
                labelForName.setText("");
                connectButton.setText("创建群聊");
                labelForFriendIP.setText("群聊的ip地址：");
                labelForFriendPort.setText("群聊的端口号：");
                connectButton1.setText("加入群聊");

                textFieldForMyPort.setText("");
                textFieldForFriendName.setVisible(false);
                textFieldForFriendIP.setText("");
                textFieldForFriendPort.setText("");
                textFieldForMyName.setText("");
                textAreaForMessage.setText("");
            }
        });

        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelForPort.setText("我的服务器端口：");
                labelForName.setText("对方的名称：");
                connectButton.setText("启动服务器");
                labelForFriendIP.setText("对方的服务器ip：");
                labelForFriendPort.setText("对方的服务器端口：");
                connectButton1.setText("连接服务器");

                textFieldForMyPort.setText("");
                textFieldForFriendName.setVisible(true);
                textFieldForFriendIP.setText("");
                textFieldForFriendPort.setText("");
                textFieldForMyName.setText("");
                textAreaForMessage.setText("");
            }
        });


        frame.setVisible(true);
    }


}