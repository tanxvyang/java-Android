package jdbc.factory;

import jdbc.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    public static Map<String,Object> objects=new HashMap<String, Object>();  //map<键类型,值类型>

    static {
        BufferedReader br=null;//读文件
        try {
            br=new BufferedReader(
                    new InputStreamReader(ObjectFactory.class//输入流
                                                            .getClassLoader()
                                                            .getResourceAsStream("object.txt")));
            String s;
            while ((s=br.readLine())!=null){
               // "key=value"
                String[] entry=s.split("=");//=
                objects.put(entry[0],Class.forName(entry[1]).newInstance());
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("objiectfactory初始化错误");//初始化时异常的的错误


        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static Object getObject(String key){

        return objects.get(key);
    }

    public static void main(String[] args) {
        UserService userService=(UserService) ObjectFactory.getObject("userser");
        System.out.println(userService);

    }
}
