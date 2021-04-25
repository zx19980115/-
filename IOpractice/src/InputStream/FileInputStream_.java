package InputStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {

    public static void main(String[] args) {
    }

    /**
     * 演示读取文件。。
     * 设置字节的读取个数
     */
    @Test
    public void readFile01(){
        String path = "d:\\news1.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        //字节数组
        byte[] bytes = new byte[64];
        int readLen = 0;
        try {
            //创建FileInputStream对象，用于读取文件
            fileInputStream = new FileInputStream(path);
            //从该输入流读取一个字节的数据。如果没有输入可用，该方法将阻止。
            //如果返回-1，表示该读取完毕
            while ((readLen=fileInputStream.read(bytes)) !=-1){
                System.out.print(new String(bytes,0,readLen));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流，释放资源
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
