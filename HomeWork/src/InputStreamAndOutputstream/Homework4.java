package InputStreamAndOutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 四：	把一个整形数组{1，3，6，23，12，564}所有值写入文件，
 * 再从文件读取处于偶数位置的数值。要求：设计测试用例及测试结果。（考察点：随机读写流 预计时间：40分钟）
 */
public class Homework4 {
    public static void main(String[] args) {
        int array[] = {1,3,6,23,12,564};
        xiedu(array);

    }
    public static void xiedu(int array[])
    {
        File file = new File("files");
        if(!file.exists())
        {
            file.mkdirs();
        }
        String filepath = file.getAbsolutePath()+File.separator+"homework4.txt";
        RandomAccessFile accessFile = null;
        try {
             accessFile = new RandomAccessFile(filepath,"rw");
            for(int i = 0;i<array.length;i++)
            {
                accessFile.writeInt(array[i]);
            }
            accessFile.seek(0);
            for (int i =0;i<array.length;i++)
            {
                if(i%2==0)
                {
                   System.out.println(accessFile.readInt());
                }
                else {
                    accessFile.skipBytes(4);//尝试跳过输入的 n 个字节以丢弃跳过的字节 一个int4字节
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                accessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
