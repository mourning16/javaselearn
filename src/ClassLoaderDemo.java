import org.omg.SendingContext.RunTime;

class Dto{}

public class ClassLoaderDemo {

    public static void main(String[] args){

        Object str0 = "123";
        System.out.println((String)str0);

        Object str1 = null;
        System.out.println((String)str1);
        System.out.println("----------------------------------------------");
        //系统类  根类加载器加载
        String str = "hello world";
        System.out.println(str.getClass().getClassLoader());

        //自定义类 自定义类加载器
        Dto dto = new Dto();
        System.out.println(dto.getClass().getClassLoader());
        System.out.println(dto.getClass().getClassLoader().getParent());
        System.out.println(dto.getClass().getClassLoader().getParent().getParent());

        //获取最大内存
        System.out.println(Runtime.getRuntime().maxMemory());
        //获取总共内存
        System.out.println(Runtime.getRuntime().totalMemory());
        //伸缩区空间 = max - total


       for(int i =0;i<Integer.MAX_VALUE;i++){
            str += str;
        }

    }

}
