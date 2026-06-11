package com.selfNetworkCommunication.BSExample;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerRunnable implements Runnable{
    private Socket socket;

    public ServerRunnable(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try(
                OutputStream os = socket.getOutputStream();
                PrintStream ps = new PrintStream(os)
        ) {
            while (true){
                try {
                    ps.println("HTTP/1.1 200 OK");
                    ps.println("Content-Type: text/html; charset=utf-8");
                    ps.println();
                    ps.println("<div style='color:red;font-size:120px;text-align:center'>显示了一行信息</div>");
                    socket.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
