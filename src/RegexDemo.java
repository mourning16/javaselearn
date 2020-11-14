import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description 正则表达式的demo
 * @Author Mourning 16
 * @Date 2020/10/10 16:35
 * @Version 1.0
 */

public class RegexDemo {

    //String match方法里面也是调用的Pattern  Matcher这一套 效率高
    private static Pattern pattern = Pattern.compile("\\d{4}(-|\\/)\\d{1,2}(-|\\/)\\d{1,2}([\\s\\S]*)");

    public static void main(String args[]){

        Matcher matcher = pattern.matcher("20201010");
        if(!matcher.matches()){
            System.out.println(matcher.matches());
        }

        matcher = pattern.matcher("2020/1/10 00:00:00");
        System.out.println(matcher.matches());

        matcher = pattern.matcher("2020-10-1  00:00:00");
        System.out.println(matcher.matches());

    }


}
