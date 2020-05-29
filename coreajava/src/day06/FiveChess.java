package day06;

import java.util.Scanner;

public class FiveChess {
    public static String[][] chess = new String[16][16];

    static {//语句块，在运行前自动加载
        System.out.print("  ");
        for (int i = 0; i < chess[0].length; i++) {
            System.out.print(Integer.toHexString(i) + " ");  //方法：Integer.toHexString(i) 10进制转16进制字符串
            // System.out.print(i+" ");
        }
        System.out.println();

        for (int i = 0; i < chess.length; i++) {
            System.out.print(Integer.toHexString(i) + " ");  //方法：Integer.toHexString(i) 10进制转16进制字符串
            for (int j = 0; j < chess[i].length; j++) {
                chess[i][j] = "*";
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isBlack = true;
        do {
            //提示用户落子
            System.out.println((isBlack ? "黑" : "白") + "方落子");//如果黑。。否则白
            //棋子
            String b = isBlack ? "@" : "0";
//用户输入位置
            String p = sc.next();
            // chess["a"]["1"]//将位置转换成具体数组下标
            String m = p.charAt(0) + "";
            String n = p.charAt(1) + "";
            //十六进制字符串转int
            int i = Integer.parseInt(m, 16);  //方法Integer.parseInt(m,16)；
            int j = Integer.parseInt(n, 16);
            //如果当前位置有棋子
            if (!"*".equals(chess[i][j])) {
                System.out.println("当前位置有棋子了！");
                //跳出本次循环
                continue;
            }
            ///落子
            chess[i][j] = b;
            //打印棋盘
            print();
            //判断输赢
            if (a(i, j) >= 5 || b(i, j) >= 5 || c(i, j) >= 5 || d(i, j) >= 5) {
                System.out.println(isBlack ? "黑赢" : "白赢");
                break;
            }


            //换方
            isBlack = !isBlack;
        } while (true);

    }

    public static int d(int i, int j) {
        int num = 1;
        int i1 = i - 1;
        int j1 = j + 1;
        int i2 = i + 1;
        int j2 = j - 1;
        while (j != -1 && chess[i][j].equals(chess[i1][j1])) {
            num++;
            i1--;
            j1++;
        }
        while (j2 != 16 && chess[i][j].equals(chess[i2][j2])) {
            num++;
            i2++;
            j2--;
        }
        return num;

    }

    public static int c(int i, int j) {
        int num = 1;
        int i1 = i - 1;
        int j1 = j - 1;
        int i2 = i + 1;
        int j2 = j + 1;
        while (j != -1 && chess[i][j].equals(chess[i1][j1])) {
            num++;
            i1--;
            j1--;
        }
        while (j2 != 16 && chess[i][j].equals(chess[i2][j2])) {
            num++;
            i2++;
            j2++;
        }
        return num;
    }

    public static int b(int i, int j) {
        int num = 1;
        int i1 = i - 1;
        int j1 = j;
        int i2 = i + 1;
        int j2 = j;
        while (j1 != -1 && chess[i][j].equals(chess[i1][j1])) {
            num++;
            i1--;
        }
        while (j2 != 16 && chess[i][j].equals(chess[i2][j2])) {
            num++;
            i2++;
        }
        return num;
    }

    public static int a(int i, int j) {
        int num = 1;
        int i1 = i;
        int j1 = j - 1;
        int i2 = i;
        int j2 = j + 1;
        while (j1 != -1 && chess[i][j].equals(chess[i1][j1])) {
            num++;
            j1--;
        }
        while (j2 != 16 && chess[i][j].equals(chess[i2][j2])) {
            num++;
            j2++;
        }
        return num;
    }

    private static void print() {
        System.out.print("  ");
        for (int i = 0; i < chess[0].length; i++) {
            System.out.print(Integer.toHexString(i) + " ");  //方法：Integer.toHexString(i) 10进制转16进制字符串
            // System.out.print(i+" ");
        }
        System.out.println();

        for (int i = 0; i < chess.length; i++) {
            System.out.print(Integer.toHexString(i) + " ");  //方法：Integer.toHexString(i) 10进制转16进制字符串
            for (int j = 0; j < chess[i].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }
}
