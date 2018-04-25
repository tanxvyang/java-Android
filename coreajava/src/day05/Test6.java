package day05;

public class Test6 {
    public static void main(String[] args) {
      int i=1;
      f(i);
        System.out.println(i);//1
        int[] arr={1};
        f(arr);
        System.out.println(arr[0]);//2
    }

/*
* 方法的重载
* 在同一个类中
* 方法名相同 返回类型在某些jdk版本中要求相同
* 参数列表不同
* 参数类型不同  个数不同
*
* 目的 使调用者方便
* */
    public static void f(int a){
        a++;
    }
    public static void f(int [] arr){
        arr[0]++;
    }
}
