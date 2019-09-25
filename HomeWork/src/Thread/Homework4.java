package Thread;

/**
 *
 * 4.编写一个Java程序实现多线程，
 * 在线程中输出线程的名字，隔300毫秒输出一次，
 * 共输出20次。
 */
public class Homework4 implements Runnable {


    public static void main(String[] args) {

        Thread thread  = new Thread(new Homework4());
        thread.setName("线程");
        thread.start();
        System.out.println();
    }

    @Override
    public void run() {
        for(int i = 0;i<20;i++)
        {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
