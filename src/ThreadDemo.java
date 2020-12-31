import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/11/5 13:38
 * @Version 1.0
 */

//wait和notify的练习
public class ThreadDemo {

        public static String str = "init";

        public static void waitDemo(){

            synchronized (str){
                try {
                    str.wait();
                    System.out.println("线程" + Thread.currentThread().getName() + "被阻塞");
                } catch (InterruptedException e) {
                    System.out.println("str的阻塞被打断");
                }
            }
        }

        public static void notifyDemo(){
            synchronized (str){
                str.notify();
                System.out.println(Thread.currentThread().getName() + "已经被打唤醒");
            }
        }

}

class Test{

    private static final int MAX_COUNT = 10;

    public static void main(String[] args) {
        new Thread(new WaitThread()).start();
        new Thread(new NotifyThread()).start();
    }
}

class WaitThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被启动");
        System.out.println("即将阻塞线程:"+Thread.currentThread().getName());
        ThreadDemo.waitDemo();
    }
}

class NotifyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被启动");
        try {
            System.out.println("沉睡十秒后即将唤醒线程~~");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadDemo.notifyDemo();
    }
}
