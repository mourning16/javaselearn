import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/10/29 10:02
 * @Version 1.0
 */

public class ListDemo {

    public static void main(String args[]){

        List<String> list = new ArrayList<String>();
        list.add("8888");
        list.add("7777");

        if(list.size()>2){
            System.out.println(list.get(2));
        }

        System.out.println("OK");
    }
}
