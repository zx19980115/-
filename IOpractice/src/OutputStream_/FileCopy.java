package OutputStream_;


import java.io.*;

public class FileCopy {
    public static void main(String[] args) {

        String srcFilepath = "d:\\tmallbuy.png";
        String destFilepath = "e:\\tmallbuy.png";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilepath);
            fileOutputStream = new FileOutputStream(destFilepath);
            int readData = 0;
            byte[] bytes = new byte[1024];
            while ((readData=fileInputStream.read(bytes))!=-1){
                //读取到后，就写入到文件 通过fileOutputStream
                //即，一边读一边写
                fileOutputStream.write(bytes,0,readData);//一定要使用这个方法
            }
            System.out.println("拷贝成功~");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
