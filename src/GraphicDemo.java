import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2021/1/5 14:10
 * @Version 1.0
 */

public class GraphicDemo {

    private String prefix  = "                             ";

    //创建图片
    private static void createImage(String fileLocation, BufferedImage image) {
        try {
            FileOutputStream fos = new FileOutputStream(fileLocation);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
        /*    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
            encoder.encode(image);*/
            ImageIO.write(image ,"jpg",bos);

            bos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //合并两张图片
    public static void mergeImage(String bigPath,String smallPath,String x,String y) throws IOException {

        try {
            BufferedImage small;
            File file = new File(bigPath);
            BufferedImage big = ImageIO.read(file);

            small = ImageIO.read(new File(smallPath));

            Graphics2D g = big.createGraphics();

            float fx = Float.parseFloat(x);
            float fy = Float.parseFloat(y);
            int x_i = (int)fx;
            int y_i = (int)fy;
            g.drawImage(small, x_i, y_i,small.getWidth(),small.getHeight(), null);
            g.dispose();
            ImageIO.write(big, "jpg", new File(bigPath));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        String firstPath = "C:\\Users\\Administrator\\Desktop\\picture\\123.jpg";
        String secondPath = "C:\\Users\\Administrator\\Desktop\\picture\\sign.png";

        String prefix  = "                  ";
        Map<String,String> info = new HashMap<String,String>();
        info.put("prdName","爱心保");
        info.put("policyNo",prefix + "1546435435435");
        info.put("appName",prefix + "投保人");
        info.put("insureName",prefix + "被保人");
        info.put("expireDate",prefix + "20210105");

        Map<String,String> queAns = new LinkedHashMap<String,String>();
        queAns.put("1.这是一段用来测试问题的字符串;",prefix + "是");
        queAns.put("2.这是一段用来测试问题的字符串;",prefix + "是");
        queAns.put("3.这是一段用来测试问题的字符串;",prefix + "是");
        queAns.put("4.这是一段用来测试问题的字符串;",prefix + "是");
        queAns.put("5.这是一段用来测试问题的字符串;",prefix + "是");
        queAns.put("6.这是一段用来测试问题的字符串;",prefix + "是");

        queAns.put("问题2",prefix + "否");
        generatePic(info,queAns,firstPath,secondPath);
    }

    public static void generatePic(Map<String,String> info , Map<String,String> queAns , String firstPath , String secondPath){

        List<Map> list = new ArrayList<Map>();

        Map<String, String> map7 = new HashMap<String, String>();
        map7.put("title", "保单信息");
        list.add(map7);

        Map<String, String> map8 = new HashMap<String, String>();
        map8.put("title2", info.get("prdName"));
        list.add(map8);

        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("保单号码", info.get("policyNo"));
        list.add(map1);

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("投保人 ", " " + info.get("appName"));
        list.add(map2);

        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("被保险人", info.get("insureName"));
        list.add(map3);

        Map<String, String> map4 = new HashMap<String, String>();
        map4.put("生效日期", info.get("expireDate"));
        list.add(map4);

        Map<String, String> map6 = new HashMap<String, String>();
        map6.put("title", "问卷信息");
        list.add(map6);

        int count = list.size();
        int countLast  =list.size();

        if(queAns!=null && queAns.size()>0){
            Set<String> stringSet = queAns.keySet();
            int i = 1;
            for(String que : stringSet){
                Map<String, String> map5 = new HashMap<String, String>();
                map5.put(que , queAns.get(que));
                i++;
                countLast = countLast + generateData(map5,list);
            }

        }

        Map<String, String> map9 = new HashMap<String, String>();
        map9.put("title", "电子签名");
        list.add(map9);

        int imageWidth = 800;// 图片的宽度
        int imageHeight = 1000;// 图片的高度
        imageHeight += list.size() * 50;
        System.out.println(imageHeight);

        BufferedImage image = new BufferedImage(imageWidth, imageHeight,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setColor(Color.white);

        int high = 100;
        int wigth = 0;
        graphics.setFont(new Font("宋体", Font.BOLD, 50));

/*        high += 10;
        graphics.drawLine(50, high, 1150, high);*/
        int j = 0;
        for(Map<String, String> rowMap : list){
            high += 50;
            wigth = 50;
            for(Map.Entry<String, String> entry : rowMap.entrySet()){
                graphics.setColor(Color.black);
                String name = entry.getKey() + "：" + entry.getValue();
                if("title".equals(entry.getKey())){
                    high += 50;
                    graphics.setFont(new Font("黑体", Font.BOLD, 30));
                    if(entry.getValue()!=null){
                        graphics.drawString(entry.getValue(), wigth, high);
                    }

                    graphics.setFont(new Font("宋体", Font.BOLD, 20));
                } else  if("title2".equals(entry.getKey())){
                    high += 50;
                    graphics.setFont(new Font("宋体", Font.BOLD, 25));
                    if(entry.getValue()!=null){
                        graphics.drawString(entry.getValue(), wigth, high);
                    }

                } else if( count <= j  && j <= countLast){
                    name = entry.getKey();
                    graphics.setFont(new Font("宋体", Font.BOLD, 20));
                    graphics.drawString(name, wigth, high);
                    graphics.setFont(new Font("宋体", Font.BOLD, 20));
                    graphics.setColor(Color.blue);
                    graphics.drawString("                                    "+entry.getValue(), wigth, high);
                    wigth += 400;
                }else {
                    graphics.drawString(name, wigth, high);
                    wigth += 400;
                }
            }
            j++;
        }

        createImage(firstPath, image);

        try {
            mergeImage(firstPath,secondPath,
                    "150",imageHeight-500+"");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int generateData(Map<String,String> map , List<Map> list){

        Set<String> sets = map.keySet();
        int count = 0;
        if(sets!=null && sets.size()>0){
            StringBuilder stringBuilder = new StringBuilder();
            for(String que : sets){

                int size = que.length() / 15;
                if (que.length() % 15 != 0) {
                    size += 1;
                }

                List<String> list1 =  getList(que, 15, size);

                for(int j=0; j < list1.size();j++){
                    Map<String, String> map10 = new HashMap<String, String>();

                    boolean flag = j==0 ? true : false ;
                    if(flag){
                        map10.put(list1.get(j),"  " + map.get(que));
                    }else{
                        map10.put("   "+list1.get(j),"  ");
                    }

                    list.add(map10);
                    count++;
                }
            }

        }
        return count;
    }

    public static List<String> getList(String str, int length,
                                       int size) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            String childStr = substring(str, i * length,
                    (i + 1) * length);
            list.add(childStr);
        }
        return list;
    }

    public static String substring(String str, int x, int y) {
        if (x > str.length())
            return null;
        if (y > str.length()) {
            return str.substring(x, str.length());
        } else {
            return str.substring(x, y);
        }
    }
}
