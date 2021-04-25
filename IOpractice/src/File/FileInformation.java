package File;

import org.junit.Test;

import java.io.File;
import java.io.InputStream;

public class FileInformation {
    public static void main(String[] args) {

    }


    //获取文件信息
    @Test
    public void info(){
        //创建文件对象
        File file = new File("d:\\news1.doc");

        //调用相应的方法，得到对应的信息
        System.out.println("文件的名字="+file.getName());
        System.out.println("文件的绝对路径=" + file.getAbsolutePath());
        System.out.println("文件父级目录=" + file.getParent());
        System.out.println("文件大小(字节)=" + file.length());
        System.out.println("文件是否存在=" + file.exists());
        System.out.println("是不是一个目录=" + file.isDirectory());
    }
}
