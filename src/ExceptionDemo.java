/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/12/8 16:02
 * @Version 1.0
 */

public class ExceptionDemo {

    public static void main(String args[]){
/*       if(true){
            throw new NullPointerException();
        }*/

        try{
            if(true){
                throw new NullPointerException();
            }
        }catch (Exception e){
            System.out.println("走了catch"+e);
        }
    }

}
