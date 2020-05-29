package day05;

public class Test7 {
    public static void main(String[] args) {
        int[][] arr = new int[2][3];//两行三列

        System.out.println(arr.length);
        System.out.println(arr[0].length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        int[][] arr2 = new int[2][];//

        //   System.out.println(arr2[0]);//null  数组是引用类型，默认值是null
        arr2[0] = new int[]{1, 2};
        arr2[1] = new int[]{1, 2, 3, 4};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }


        int[][] arr3 = {{1, 2, 3}, {2, 3, 4}, {5, 6, 7, 8}};
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
