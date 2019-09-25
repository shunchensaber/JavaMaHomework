package InputStreamAndOutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 二：	从控制台输入5个帐户信息，信息以逗号分割，具体格式：
 * 账号，姓名，金额，性别
 * 要求：
 * 1. 帐户信息必须做验证：
 *    账号、姓名：不可为空；金额、性别可以为空。
 *    其他check参照第五章。错误信息直接打印，不需要使用自定义异常。
 * 2. 验证正确后，把帐户信息封装成对象加入帐户数组。
 *    如果验证失败，打出提示信息，重新输入。
 * 3. 输满5个帐户后，把所有的帐户信息写入文件。
 * 4. 读取文件内容，把帐户信息打印在控制台。
 * （考察点：字符输入输出流 预计时间：90分钟）
 */
public class Homework2 {
    public static void main(String[] args) {
        File file  = new File("files");
        Scanner scanner = new Scanner(System.in);
        String filepath = file.getAbsolutePath()+File.separator+"homework2.text";
        RandomAccessFile accessFile =null;
        try {
            //写
             accessFile = new RandomAccessFile(filepath,"rw");
            for(int  i =0;i<5;i++)
            {
                String row = scanner.nextLine();
                String[] clo = row.split("，");
                User user = new User(Integer.parseInt(clo[0]),clo[1],Double.parseDouble(clo[2]),clo[3]);
                if(!user.Check())
                {
                    i--;
                    System.out.println("请重新输入");
                }
                else{
                    user.write(accessFile);
                }
            }
            //读
            accessFile.seek(0);
            for(  long i=0;i<accessFile.length();i=accessFile.getFilePointer())
            {
                User user = new User();
                user.read(accessFile);
                System.out.println(user.toString());
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
class User{
    private Integer id;
    private String name;
    private Double money;
    private String sex;

    public User(Integer id, String name, Double money, String sex) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.sex = sex;
    }

    public User() {
    }
    public boolean Check()
    {
        if(name.replaceAll(" ","").equals("")||id.toString().replaceAll(" ","").equals(""))
        {
            if(name.replaceAll(" ","").equals(""))
                System.out.println("名字不可为空");
            else{
                System.out.println("账号不可为空");
            }
            return false;
        }else {
            return true;
        }
    }

    public void write(RandomAccessFile randomAccessFile)
    {
        try {
            randomAccessFile.writeInt(id);
            randomAccessFile.writeUTF(name);
            randomAccessFile.writeDouble(money);
            randomAccessFile.writeUTF(sex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void read(RandomAccessFile randomAccessFile)
    {
        try {
             id =randomAccessFile.readInt();
            name =  randomAccessFile.readUTF();
            money = randomAccessFile.readDouble();
           sex =  randomAccessFile.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", sex='" + sex + '\'' +
                '}';
    }
}
