package InputStreamAndOutputstream;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 五：	实现一个文件查找器：在控制台输入一个路径，
 * 再输入一个关键字。查找输入路径下哪些文件的文件名包含关键字的。
 * 要求：设计测试用例及测试结果。(考察点：文件类 预计时间：90分钟。)
 */
public class Homework5 {
    public static void main(String[] args) {
        File file = new File(".//");
        System.out.println(findallcontains(file.getAbsolutePath(), "homework1"));
    }

    public static List<String> findallcontains(String path, String key) {
        File file = new File(path);
        LinkedList<String> re = new LinkedList<>();
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
//            System.out.println(file1.getAbsolutePath());
            if (file1.isFile()) {
                String temp = file1.getAbsolutePath();
                temp = temp.substring(temp.lastIndexOf('\\') + 1, temp.lastIndexOf('.'));
                if (temp.contains(key)) {
                    re.add(file1.getAbsolutePath());
                }
            }
            else
            {
                re.addAll(findallcontains(file1.toString(),key));
            }
        }
        return re;
    }
}
