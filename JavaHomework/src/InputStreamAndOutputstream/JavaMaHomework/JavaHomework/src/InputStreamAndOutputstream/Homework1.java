package InputStreamAndOutputstream;

import java.io.*;

/**
 * 一：	读取一个长度为20+的字符串(包含汉字和字母)，利用字节流写入文件，要求每次写10个字节。写入完毕后，从文件读取写入内容，打印在控制台上。(考察点：字节流读写、数组操作 预计时间90分钟)。
 * 步骤提示：
 * 1)	建立一个长度为20+的字符串。
 * 2)	把字符串转为字节数组形式。
 * 3)	建立字节输出流。
 * 4)	把字节数组的开始位置后10位字节写入输出流。
 * 5)	开始位置向后移动10位。
 * 6)	如果开始位置 + 10超过字节数组总长度，则输入结束。(注意：最后一次写入输出流的字节可能不满10个，需要程序控制)
 * 7)	建立字节输入流。
 * 8)	利用字节输入流读取所写文件内容，内容放置在一个字节数组中。
 * 9)	把字节数组转化为字符串显示在控制台上。
 */
public class Homework1 {

    public static void main(String[] args)  {
        /**
         * 写
         */
        String str = "今天是个好日子asdfghjkl今天是个好日子asdfghjkl1122";
        byte[] bytes = str.getBytes();

        File file = new File("files");

        int readbytes = 10;
        String filepath = null;

        if(!file.exists())
        {
            file.mkdirs();
        }
        OutputStream outputStream = null;
        try {
            filepath = file.getAbsolutePath()+File.separator+"homework1.text";
             outputStream = new FileOutputStream(filepath);
            int off = 0;
            while(off<bytes.length)
            {
                int len;
                if(off+readbytes>=bytes.length)
                {
                    len = bytes.length-off;
                }
                else {
                    len =10;
                }
                outputStream.write(bytes,off,len);
                off+=len;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 读
         */
        try {

            InputStream inputStream = new FileInputStream(filepath);
            byte[] re = new byte[inputStream.available()];
            inputStream.read(re);
            System.out.println(new String(re));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
