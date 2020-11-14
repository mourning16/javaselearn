/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/11/11 13:35
 * @Version 1.0
 */

public class ThreadTask implements  Runnable {

    private static int count  = 1;

    @Override
    public void run() {
        System.out.println("实现runnable" + count++);
        System.out.println("线程ID:"+Thread.currentThread().getId());
    }
}
