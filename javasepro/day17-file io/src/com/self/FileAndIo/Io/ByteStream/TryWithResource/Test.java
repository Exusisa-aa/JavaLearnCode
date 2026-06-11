package com.self.FileAndIo.Io.ByteStream.TryWithResource;

public class Test implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("释放了资源~~!");
    }
}
