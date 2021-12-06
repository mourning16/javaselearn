import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2021/1/15 15:16
 * @Version 1.0
 */
//让多个线程等待，主线程先运行
public class CountDownLatchDemo {

    public static void main(String[] args) {

        //直接使用int，可能存在线程安全问题
        AtomicInteger atomicInteger = new AtomicInteger(0);

        //该值不能被重新设置，每次countDown会-1.当值为0时线程进入正常竞争CPU资源状态
        CountDownLatch latch = new CountDownLatch(1);

        for(int i =0 ;i<10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //此处也可以设定一个等待时间，过了这个等待时间直接放掉;
                        //latch.await(5,TimeUnit.SECONDS);
                        latch.await();
                        int no = atomicInteger.getAndAdd(1);
                        System.out.println( no  + "号运动员开始起跑 ~ ~");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        try {
            //主线程阻塞10秒钟
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("发令枪响了~~");
        latch.countDown();

    }
}
