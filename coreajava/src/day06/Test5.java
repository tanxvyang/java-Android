package day06;

/* 矩阵转换*/
public class Test5  {
    public static void main(String[] args) {
//        int[][] array={
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };
        int [][] array=new int[4][4];
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                array[i][j]=array[i].length*i+(j+1);
            }
        }

        //System.out.println(array.length);
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print(array[j][i]+"\t");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
//        for (int i = 0; i <array.length ; i++) {
//            for (int j = 0; j <array[i].length ; j++) {
//                System.out.print(array[array[i].length-j-1][i]+"\t");
//            }
//            System.out.println();
//        }
        System.out.println("----------------------------------------");

        for (int j = 0; j <array.length ; j++) {
            for (int i = array[j].length-1; i >=0; i--) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");

        for (int i = 0; i < array.length ; i++) {
            for (int j = array[i].length-1; j>=0; j--) {
                System.out.print(array[i ][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");

        for (int i = 0; i < array.length ; i++) {
            for (int j =0; j<array[i].length; j++) {

                System.out.print(array[i ][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");
    }
}
