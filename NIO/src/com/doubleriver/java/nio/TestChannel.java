package com.doubleriver.java.nio;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author ronye
 * @Created 2018/12/5 - 3:22 PM
 */
public class TestChannel {
    /*
        通道：用于建立目标节点与源节点的连接，配合缓冲区进行数据传输

        java.nio.channels.Channel 接口和实现类
            |--FileChannel
            |--SocketChannel
            |--ServerSocketChannel
            |--DatagramChannel

        Java针对支持通道的类提供了获取通道的方法 getChannel()

        本地IO
        FileInputStream / FileOutputStream
        RandomAccessFile

        网络IO
        Socket
        ServerSocket
        DatagramSocket
     */
    @Test
    public void test() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("1.JPG");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("2.JPG");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try{
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            ByteBuffer bb = ByteBuffer.allocate(1024);
            while(inChannel.read(bb) != -1){
                bb.flip();//切换到读取模式
                outChannel.write(bb);//将缓冲区的数据写入到通道
                bb.clear();//将缓冲区清空
            }
        }catch(IOException ex){
            System.out.println("IOException 异常");
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outChannel!=null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
