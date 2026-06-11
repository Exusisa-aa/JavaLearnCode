package com.self.cinema.CustomerManage.ShowInfoOnBrowser;

import java.io.*;
import java.net.Socket;


public class ServerRunnable implements Runnable{
    private Socket socket;

    public ServerRunnable(Socket socket)
    {
        this.socket = socket;
    }

    //以下知识盲区  ai生成

    @Override
    public void run() {
        try (
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();
                PrintStream ps = new PrintStream(output)
        ) {
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String line = br.readLine();

            if (line == null || line.isEmpty()) return;

            String[] requestParts = line.split(" ");
            if (requestParts.length < 2) return;

            String path = requestParts[1];

            // 默认首页
            if ("/".equals(path)) {
                sendFile(ps, "Cinema/www/index.html", "text/html; charset=utf-8");
                return;
            }

            // 处理图片资源 /pictures/xxx.jpg
            if (path.startsWith("/pictures/")) {
                String filename = path.substring("/pictures/".length());
                sendFile(ps, "Cinema/www/pictures/" + filename, guessContentType(filename));
                return;
            }

            // 其他路径返回 404
            ps.println("HTTP/1.1 404 Not Found");
            ps.println("Content-Type: text/html; charset=utf-8");
            ps.println();
            ps.println("<h1>404 页面未找到</h1>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 发送文件内容
    private void sendFile(PrintStream ps, String filePath, String contentType) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            ps.println("HTTP/1.1 404 Not Found");
            ps.println("Content-Type: text/html; charset=utf-8");
            ps.println();
            ps.println("<h1>404 文件未找到</h1>");
            return;
        }

        ps.println("HTTP/1.1 200 OK");
        ps.println("Content-Type: " + contentType);
        ps.println("Content-Length: " + file.length());
        ps.println();
        ps.flush(); // 确保 header 写入

        try (InputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                ps.write(buffer, 0, bytesRead);
            }
        }
    }

    // 根据文件扩展名猜测 Content-Type
    private String guessContentType(String filename) {
        if (filename.endsWith(".html") || filename.endsWith(".htm")) {
            return "text/html";
        } else if (filename.endsWith(".css")) {
            return "text/css";
        } else if (filename.endsWith(".js")) {
            return "application/javascript";
        } else if (filename.endsWith(".png")) {
            return "image/png";
        } else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (filename.endsWith(".gif")) {
            return "image/gif";
        } else {
            return "application/octet-stream";
        }
    }
}
