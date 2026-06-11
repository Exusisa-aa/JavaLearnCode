package com.self.FileAndIo.Io.ByteStream.DataInputStreamAndDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamDemo {
    public static void main(String[] args) {
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\DataInputStreamAndDataOutputStream\\222.txt"))
        ) {
            dos.writeByte(97);
            dos.writeInt(97);
            dos.writeDouble(97.5);
            dos.writeUTF("top");
            dos.writeBoolean(true);
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
