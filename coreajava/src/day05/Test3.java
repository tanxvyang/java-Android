package day05;



public class Test3 {


    public static void main(String[] args) {
        int[] arr; //  Java 也支持 int arr[];

        /*
        * 1.分配空间
        * 2.数据初始化
        *3. 将空间首地址赋值给arr[0]
        * */
       arr = new int[4];  //new 关键字为数组分配空间
       // System.out.println(arr);
      //  System.out.println(arr[2]);
        arr[1] = 3;
        System.out.println(arr[1]);
        //数组的静态初始化

        int[] a = new int []{1,2,3,4,6,7,9};
        int[] b = {1,2,3,4,6,7,9};        //可省略 new int 【】
                                      //{}只能做静态初始化操作
       // System.out.println(a[3]);
//        for (int i = 0; i<6;i++){
//            System.out.println(a[i]);
//        }
       // System.out.println(Arrays.toString(a));


      /*  System.out.println(a[8]);
      错误原因：数组下标越界异常，出现错误需要检查数组下标
      //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 8
*/
    }

}
