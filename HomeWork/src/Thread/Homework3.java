package Thread;

/**
 * 3.现在张三想要李四的画。李四想要张三的书，
 * 张三对李四说：把你的画给我，我就给你书，李四也对
 * 张三说，把你的书给我，我就给你画，此时张三在等待李四
 * 的答复，李四也在等待张三的答复
 */
public class Homework3 implements  Runnable{

    //类锁与对象锁？？
    static Zhangsan zhangsan = new Zhangsan();
    static Lisi lisi = new Lisi();
    public boolean flag = true;
    Homework3(boolean flag)
    {
        this.flag  = flag;
    }
    @Override
    public void run() {
        if (flag) {
            synchronized (zhangsan) {
                zhangsan.say();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lisi) {
                    zhangsan.get();
                }
            }
        }
if (!flag) {
    synchronized (lisi) {

        lisi.say();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (zhangsan) {
            lisi.get();
        }
    }
}
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Homework3(true));
        Thread thread1 = new Thread(new Homework3(false));

        thread.start();
        thread1.start();
    }
}

class Zhangsan{
    void say()
    {
       System.out.println("张三说：把你的画给我，我就给你书");

    }
    void get()
    {
        System.out.println("张三得到了画");
    }

}
class Lisi{
    void say()
    {
        System.out.println("李四说：把你的书给我，我就给你画");
    }
    void get()
    {
        System.out.println("李四得到了画");
    }
}
