package day06;

import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
       String[][] rooms = new String[10][12];

       // System.out.println(rooms[4][1]);
        for (int i = 0;i < rooms.length;i++){
            for (int j = 0;j < rooms[i].length;j++){
                rooms[i][j] = "EMPTY";
            }
        }
        String cmd =null;
        do {
            System.out.println("输入命令：");
            cmd=sc.next();

            if ("search".equals(cmd)){
                search(rooms);
            }

            if("in".equals(cmd)){
                int roomNo = sc.nextInt();
                String member=sc.next();

                in(roomNo,member,rooms);
            }
            if ("out".equals(cmd)){
                int roomNo=sc.nextInt();
                out(roomNo,rooms);
            }
            if (!"search".equals(cmd) &&!"in".equals(cmd)&&!"out".equals(cmd)&&!"search".equals(cmd)){
                System.out.println("命令错误！");
            }

        } while (!"quit".equals(cmd));//用常量。equals（）比较字符串
        System.out.println("再见！");
    }

    private static void out(int roomNo,String[][]rooms) {
        int i=roomNo/100-1;
        int j=roomNo%100-1 ;

        if("EMPTY".equals(rooms[i][j])){
            System.out.println("房间无人入住，请重新输入");
            return;
        }
        rooms[i][j]="EMPTY";
        System.out.println(roomNo+"已退房");
    }

    private static void in(int roomNo,String member,String[][]rooms) {
        int i=roomNo/100-1;
        int j=roomNo%100-1 ;

        if(!"EMPTY".equals(rooms[i][j])){
            System.out.println("房间已有客人，请重新输入");
            return;
        }
        rooms[i][j]=member;
        System.out.println(member+"成功入驻"+roomNo);
    }

    private static void search(String[][]rooms) {
      //  System.out.println("Hotel.search");
        for (int i = 0;i < rooms.length;i++){
            for (int j = 0; j < rooms.length;j++){
                System.out.print((i+1)*100+(j+1)+"\t\t");
            }
            System.out.println();
            for (int j = 0;j < rooms.length;j++){
                System.out.print(rooms[i][j]+"\t");
            }
            System.out.println();
            System.out.println();
        }
    }
}
