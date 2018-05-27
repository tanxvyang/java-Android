package day06;

import java.util.Arrays;




public class Test4 {
    public static void main(String[] args) {
          // int[] a={5,3,1,2,4};
        int[] a=new int[200000];
        for (int i = 0;i<a.length;i++){
            a[i]=(int)(Math.random()*999999);
        }
       // selectSort(a);  //选择排序416

         // bubleSort(a);//冒泡排序139

        //   insertSort(a);//插入排序 93

       // quickSort(a,0,a.length-1);//快速排序 72

         Arrays.sort(a);

       //从1970年1月1日00点00分00秒到当前时间的毫秒数；加八小时时差
        long start = System.currentTimeMillis();
        selectSort(a);
       long end=System.currentTimeMillis();
        System.out.println(end-start);
       // System.out.println(Arrays.toString(a));
    }
//快速排序
    private static void quickSort(int[] a, int left, int right) {
        int i=left;
        int j=right;
        int middle = a[(left+right)/2];
        do {
            while (a[i]<middle&& i<right){
                i++;
            }
            while (a[j]>middle && j>left){
                j--;
            }
            if (i<=j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;
                j--;
            }
        }while (i<j);
        if (left<j){
            quickSort(a,left,j);
        }
        if (right>i){
            quickSort(a,i,right);
        }
    }

//插入排序
    private static void insertSort(int[] a) {
        for (int i=1;i<a.length;i++){
          int num = a[i];
            int j = i-1;
        while (j != -1 && num < a[j]) {
            a[j + 1] = a[j];
            j--;

        }
        a[j+1]=num;
    }
    }
    private static void bubleSort(int[] a) {
        for (int i=0;i<a.length-1;i++){
            for (int j=0;j<a.length-i-1;j++){
                if (a[j]>a[j+1]){
                    int temp =a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;

                }
            }
        }
    }

    private static void selectSort(int[] a) {
        for (int i = 0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if (a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
    }


}
/*3.排序test4
     选择排序， selectSort(a)
     冒泡排序，  bubleSort(a);
     插入排序， insertSort(a);
     快速排序  quickSort(a,0,a.length-1);


      Arrays.sort(a);方法，排序方法可直接调用

   //cong1970年1月1日00点00分00秒到当前时间的毫秒数；加八小时时差
          long start = System.currentTimeMillis();
         selectSort(a);

          System.out.println(Arrays.toString(a));*/

