package OutputStream_;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void writeFile(){
        String path = "d:\\hello.txt";
        String str = "Hello World";
        FileOutputStream fileOutputStream = null;
        try {
            //得到FileOutputStream对象
            fileOutputStream = new FileOutputStream(path);
            //append - 如果是 true ，那么字节将被写入文件的末尾，而不是开头(意思就是追加的方式添加字节)
            fileOutputStream = new FileOutputStream(path,true);
            //写入一个字符串
            //getBytes()可以把字符串转换成字节数组
            fileOutputStream.write(str.getBytes());
            //写入一个字节
            fileOutputStream.write('H');
            //从位于偏移量 off的指定字节数组写入 len字节到该文件输出流
            fileOutputStream.write(str.getBytes(),0,str.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
