import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/10/26 9:27
 * @Version 1.0
 */

public class DateDemo {

    public static  void main(String[] args){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,11-1,1);
        System.out.println(sdf.format(calendar.getTime()));

    }
}
