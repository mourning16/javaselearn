import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2021/1/15 15:47
 * @Version 1.0
 */
//主线程等待，多个线程运行
public class CountDownLatchDemo2 {

    public static void main(String[] args) {

        //合计10个面包
        int bread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(bread);

        int count = bread;

        for(int i = 0 ;i< bread ; i++){

            new Thread(){
                @Override
                public void run(){
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("吃面包~~~");
                    countDownLatch.countDown();
                }
            }.start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有面包全部吃完了~~");
    }
}
