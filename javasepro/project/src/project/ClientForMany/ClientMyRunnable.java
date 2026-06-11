package project.ClientForMany;

import project.GUI;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;


public class ClientMyRunnable implements Runnable{
    private final Socket socket;
    private final String name;

    public ClientMyRunnable(Socket socket,String name){
        this.socket = socket;
        this.name = name;
    }
    @Override
    public void run() {
        String index;
        try(
                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is)
        ) {
            while (true){
                String message = dis.readUTF();
                if(message.startsWith("name")){
                    index = "";
                    GUI.textArea.setText("");
                    String[] names = message.split("name");
                    names = Arrays.stream(names).distinct().toArray(String[]::new);
                    for (int i = 1; i < names.length; i++) {
                        index += names[i] + '\n';
                    }
                    GUI.textArea.append(index);
                } else {
                    GUI.textAreaForMessage.append(message + "\n");
                }
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
