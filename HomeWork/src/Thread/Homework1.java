package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1  设计4个线程对象，2个线程执行加法操作，2个线程执行减法操作
 */
public class Homework1 {
    static int num = 10;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new add1());
        exec.execute(new add2());
        exec.execute(new sub1());
        exec.execute(new sub2());
        exec.execute(new add2());
        exec.shutdown();
    }
}

class add1 implements Runnable{


    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                Homework1.num += 10;
                System.out.println(Thread.currentThread().getName()+":"+"num+10="+(Homework1.num-10)+"+"+10+"="+(Homework1.num));
            }
        }


    }
}

class add2 implements Runnable{


    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                Homework1.num += 20;
                System.out.println(Thread.currentThread().getName()+":"+"num+20="+(Homework1.num-20)+"+"+20+"="+(Homework1.num));
            }
        }


    }
}

class sub1 implements Runnable{


    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                Homework1.num -= 10;
                System.out.println(Thread.currentThread().getName()+":"+"num-10="+(Homework1.num+10)+"-"+10+"="+(Homework1.num));
            }
        }


    }
}


class sub2 implements Runnable{


    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                Homework1.num -= 20;
                System.out.println(Thread.currentThread().getName()+":"+"num-20="+(Homework1.num+20)+"-"+20+"="+(Homework1.num));
            }
        }


    }
}
