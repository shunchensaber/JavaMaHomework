package Collection;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

//2.设计一个生产电脑和搬运电脑的类。
// 要求生产出一台电脑就搬走一台电脑，
// 如果没有新的电脑生产出来，则搬运工要等待新的电脑产出
// 如果生产出的新电脑没有搬走，则要等待搬走之后再生产 ，并统计出生产的电脑数量
public class Homework1 {
    public static void main(String[] args) {
        Computer cp = new Computer();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Producer(cp));
        executorService.execute(new Consumer(cp));
    }

}
class Producer implements Runnable
        {
            Computer cp;
            Producer(Computer cp)
            {
                this.cp = cp;

            }

            @Override
            public void run()
            {
                while(true)
                {
                    cp.produce();
                }
            }

        }

        class Consumer implements Runnable
        {
            public Computer cp;
            Consumer(Computer cp)
            {
                this.cp = cp;
            }

            @Override
            public void run()
            {
                while(true)
                {
                    cp.consume();
                }
            }


        }


class Computer
{
    public int num = 0;
    public boolean flag = false;
    Computer()
    {

    }

    public synchronized void produce()
    {
        if(flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("生产第%d台电脑",++num));
        flag =true;
        notify();
    }
    public synchronized void consume()
    {
        if(!flag)
        {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费了一台电脑");
        flag = false;
        notify();
    }


}
