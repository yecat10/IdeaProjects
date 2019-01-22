package com.doubleriver.java.nio;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * @Author ronye
 * @Created 2018/12/5 - 2:15 PM
 */

public class TestBuffer {
    /*一、缓冲区的基本概念
        缓冲区，Buffer，在java NIO中负责数据的存取，存储不同类型的数据
        ByteBuffer
        CharBuffer
        LongBuffer
        IntBuffer
        FloatBuffer
        DoubleBuffer
        ShortBuffer
      二、缓冲区核心方法
        上述缓冲区的管理方式基本一致，通过allocate()获取缓冲区
        通过put()存入数据，通过get()获取数据
      三、核心属性
        capacity：表示缓冲区中最大存储数据的容量，一旦声明，不能修改；
        limit：表示缓冲区可以操作数据的大小
        position：表示缓冲区中正在操作数据的位置
        position<=limit<=capacity

        mark 标志当前position
        reset 恢复到mark的position

      四、直接缓冲区，非直接缓冲区
        allocate()建立非直接缓冲区，将缓冲区建立在jvm的内存上
        allocateDirect()建立直接缓冲区； ，将缓冲区建立在操作系统的物理内存上

     */
    @Test
    public void test1(){
        //分配缓冲区
        ByteBuffer bb = ByteBuffer.allocate(1024);
        //在缓冲区中存入数据
        String str = "abcde";
        bb.put(str.getBytes());
        System.out.println(bb.position() +" /" + bb.limit() + "/" + bb.capacity());
        //切换到读取数据的模式
        bb.flip();
        System.out.println(bb.position() +" /" + bb.limit() + "/" + bb.capacity());
        //读取数据到数组
        byte[] bytes = new byte[bb.limit()];
        bb.get(bytes);
        System.out.println(new String(bytes));
        System.out.println(bb.position() +" /" + bb.limit() + "/" + bb.capacity());
        //重读
        bb.rewind();
        bb.get(bytes);
        System.out.println(new String(bytes));
        System.out.println(bb.position() +" /" + bb.limit() + "/" + bb.capacity());
         //清空缓冲区, 但是数据依然存在，只是处于"被遗忘"状态;仅position、limit、capacity指针重制
        bb.clear();
        System.out.println(bb.position() +" /" + bb.limit() + "/" + bb.capacity());
        bb.get(bytes);
        System.out.println(new String(bytes));

    }
    @Test
    public void test2(){
        String str = "abcde";

        ByteBuffer bb = ByteBuffer.allocate(1024);

        bb.put(str.getBytes());

        bb.flip();

        byte[] dst = new byte[bb.limit()];
        bb.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println(bb.position() +" /" + bb.limit() + "/" + bb.capacity());

        bb.mark();
        bb.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(bb.position() +" /" + bb.limit() + "/" + bb.capacity());

        bb.reset();
        System.out.println(bb.position() +" /" + bb.limit() + "/" + bb.capacity());
        //判断缓冲区的类型
        System.out.println(bb.isDirect());

    }
}
