package Collection.Collection2;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
 * 1)	从控制台循环输入帐户信息，以逗号隔开：”账号，姓名，金额，性别”，check正确后封装为对象加入List,当控制台输入“end”输入截止。把List内容写入文件。
 * 步骤：
 * 1.	从控制台输入账户信息
 * 2.	判断输入内容是否是”end”。如果是则进入步骤5
 * 3.	验证账户信息，验证正确后加入List
 * 4.	验证失败，重新转入步骤1
 * 5.	把List内容写入文件
 * （考察点：list的插入、遍历  预计时间：40分钟）
 */
public class Homework1{

    public static void main(String[] args) {

        List<User> list = new ArrayList<>();


        Scanner scan = new Scanner(System.in);
        int id = 0;
        String name;
        Double money;
        String sex;
        User user = null;

        while (true) {
            String temp = scan.next();
            if (temp.equals("end")) {
                break;
            } else {
                id = Integer.parseInt(temp);
            }

            name = scan.next();
            money = scan.nextDouble();
            sex = scan.next();

            user = new User(id, name, money, sex);
            if (user.Check()) {
                list.add(user);
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println("out stopping");
        Iterator<User> it= list.iterator();
        while(it.hasNext())
        {
            sb.append(it.next().toString());
        }

        String towrite = sb.toString();

        File file = new File("Homework1.txt");
        OutputStream op = null;
        try {
           op = new FileOutputStream(file);
            byte[] b=  towrite.getBytes();
            int off = 0,len = 200;


                op.write(b);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }finally {
            try {
                op.close();
                System.out.println("写入完成");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}


class User {
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

    public boolean Check() {
        if (name.replaceAll(" ", "").equals("") || id.toString().replaceAll(" ", "").equals("")) {
            if (name.replaceAll(" ", "").equals(""))
                System.out.println("名字不可为空");
            else {
                System.out.println("账号不可为空");
            }
            return false;
        } else {
            return true;
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

