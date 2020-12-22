import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/10/14 19:19
 * @Version 1.0
 */

public class SdfDemo {

    public static void main(String args[]){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


/*        try {
            sdf.parse(sdf.format(""));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        Date date = new Date();
        Long l = date.getTime();








    }

}
