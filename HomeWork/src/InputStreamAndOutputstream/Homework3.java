package InputStreamAndOutputstream;

import java.io.*;

/**
 * 三：	复制一个既带图片又带文字的文件(例如word，excel文件)。(预计时间：30分钟)
 */
public class Homework3 {
    public static void main(String[] args) {
        File file = new File("files");
        if(!file.exists())
        {
            file.mkdirs();
        }
        String filepath = file.getAbsolutePath();
        String frompath = filepath+File.separator+"homework3test.doc";
        String topath = filepath+File.separator+"homework3.doc";
        copy(frompath,topath);
        System.out.println("完成了");


    }
    public static void copy(String frompath,String topath)
    {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
             inputStream = new FileInputStream(frompath);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
             outputStream = new FileOutputStream(topath);
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
