/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/11/5 13:38
 * @Version 1.0
 */

public class ThreadDemo {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
        new Thread(){
            @Override
            public void run(){
                System.out.println("~~~~~~");
                System.out.println(Thread.currentThread().getId());
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        for(int i=0;i<10;i++){
            Thread t = new Thread(new ThreadTask());
            t.start();
        }

    }

}
