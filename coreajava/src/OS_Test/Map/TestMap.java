package OS_Test.Map;

import javax.lang.model.element.NestingKind;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
        * HashMap     Key 为哈希散列表,线程不安全,允许一个Key为null,value可以为null
        * Hash table   Key为哈希散列表   ,线程安全,key和value都不能为null
        * TreeMap     可key为平衡二叉树
        *LinkedHashMap              key为哈希散列表和链表
        * Properties          访问属性文件,特殊的map ,key 和value 都是string类型
        * */
public class TestMap {
    public static void main(String[] args) {
     /*   Map<String ,Integer > m = new HashMap<>();
        m.put("aaa",1);
        m.put("bbb",2);
        m.put("ccc",3);
        m.put("ddd",4);
        System.out.println(m.get("bbb"));
        System.out.println(m);


        */
        //System.out.println(m.put("aaa"));

 /*
//使用keySet遍历map,获得map的所有key
        Set<String> keys = m.keySet();
        for (String key : keys){  //
            System.out.println(key+"="+m.get(key));  //无序
        }
*/

/*

 //使用entrySet遍历Map,获得map的所有entry
       Set<  Map.Entry<String,Integer>  > entrys = m.entrySet();
        for ( Map.Entry<String,Integer> entry : entrys) {
            System.out.println(entry.getKey()+ "=" +entry.getValue());
        }*/



      entry e = new entry();
        e.put("a","1");
        e.put("b","2");
        e.put("c","3");
        e.put("d","4");
        e.put("e","5");
        e.put("f","6");
        e.put("g","7");
        System.out.println(e.get("e"));

    }

    private  static  class entry{
        private  String key;
        private String value;

        private String[]  values = new String[100];


        public void put(String key,String value){
            int i = Math.abs(key.hashCode())%(values.length);
            values[i] = value;

        }

        public String get(String key){
            int i = Math.abs(key.hashCode())%(values.length);

            return values[i];
        }

    }



}
