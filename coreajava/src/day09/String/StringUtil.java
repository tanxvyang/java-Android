package day09.String;

public class StringUtil {
    public static String join(String[] arr,String s){
        String str="";


        for (int i=0;i<arr.length;i++) {
            str+=(arr[i]+s);

        }
        return  str.substring(0,str.length()-1);
    }


}
