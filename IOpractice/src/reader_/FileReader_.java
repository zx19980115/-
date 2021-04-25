package reader_;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    /**
     * 单个字符读取文件
     */
    @Test
    public void readFile01(){
        String path = "d:\\story.txt";
        FileReader fileReader = null;
        int data = 0;
        //1.创建FileReader对象
        try {
            fileReader = new FileReader(path);
            //循环读取 使用read，单个字符读取
            while ((data=fileReader.read())!=-1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 指定字符数量读取
     */
    @Test
    public void readFile02(){
        String path = "d:\\story.txt";
        FileReader fileReader = null;
        int readLen = 0;
        char[] chars = new char[8];
        //1.创建FileReader对象
        try {
            fileReader = new FileReader(path);
            //循环读取 使用read，单个字符读取
            while ((readLen=fileReader.read(chars))!=-1){
                System.out.print(new String(chars,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
