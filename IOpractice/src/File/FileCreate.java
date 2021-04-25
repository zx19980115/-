package File;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1
    @Test
    public void create01(){
        String path = "d:\\news1.doc";
        File file = new File(path);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式2 new File(File parent,String child)    //根据父目录文件+子路径构建
    //e:\\news2.txt
    @Test
    public void create02(){
        //两个斜杠是转义符或者用/
        File parentFile = new File("d:\\");
        String fileName = "news2.xls";
        //这里的file只是一个对象
        //只有执行了createNewFile方法，才会真正的在磁盘创建文件
        File file = new File(parentFile,fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
