package day08.Poker;

import com.sun.org.apache.bcel.internal.generic.POP2;

import javax.naming.Name;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Poker {
    private Pai[] p;
    private Pai[] p1;
    private Pai[] p2;
    private Pai[] p3;
    private Pai[] p4;


    public Pai[] getP() {
        return p;
    }

    public void setP(Pai[] p) {
        this.p = p;
    }

    public void xipai() {

        // Pai[] p=new Pai[this.p.length];
        //
        // for(int i=0;i<this.p.length;i++){
        //     int index;
        //
        //     do {
        //      index=(int) (Math.random()*(53-0+1))+0;
        // } while (p[index]!=null);
        //
        //     p[index]=this.p[i];
        //
        //
        // }
        // this.p=p;  //重新赋值


        //将数组转换成list
        List l = Arrays.asList(this.p);
        //将list中的数据打乱
        Collections.shuffle(l);
        //将list装换成数组
        this.p = (Pai[]) l.toArray();


    }


    public Poker() {
        super();
        p = new Pai[54];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {

                //i=0 j=0-12

                if (i == Pai.heitao) {
                    p[i * 13 + j] = new Pai(j + 1, Pai.heitao);


                }
                //i=1 j=0-12
                if (i == Pai.hongtao) {
                    p[i * 13 + j] = new Pai(j + 1, Pai.hongtao);

                }
                if (i == Pai.fangpian) {
                    p[i * 13 + j] = new Pai(j + 1, Pai.fangpian);

                }
                if (i == Pai.meihua) {
                    p[i * 13 + j] = new Pai(j + 1, Pai.meihua);

                }

            }
            p[52] = new Pai(Pai.xiaowang, Pai.xiaowang);
            p[53] = new Pai(Pai.dawang, Pai.dawang);

        }


    }


    public void fapai() {

        //
        // //将数组转换成list
        // List l= Arrays.asList(this.p);
        // //将list中的数据打乱
        // Collections.shuffle(l);
        // //将list装换成数组
        // this.p=(Pai[]) l.toArray();


        p1 = new Pai[25];//玩家1牌组集合
        p2 = new Pai[25];//玩家2牌组集合
        p3 = new Pai[25];//玩家3牌组集合
        p4 = new Pai[25];//底牌牌组集合

        Pai[] p = this.p;
  /*
  for (int i=0;i<p.length;i++){
    for (int j=0;j<4;j++){
      if (j==0){
          p1[i]=p[i];
          //System.out.println(p1);


      }
        if (j==1){
            p2[i]=p[i];
          //  System.out.println(p2);

        }
        if (j==2){
            p3[i]=p[i];
          //  System.out.println(p3);
        }
        if (j==3){
            p4[i]=p[i];
           // System.out.println(p4);
        }

    }





}

  */


        //new Pai[this.p.length];


      /*  for (int i = 0; i < this.p.length; i++) {
                int index;

                do {
                 index=(int) (Math.random()*(53-0+1))+0;
            } while (p[index]!=null);
            //
                p[index]=this.p[i];
            //
            //
            }
            this.p=p;  //重新赋值


        }

        */

        for (int i = 0; i < p.length; i++) {
            if (i >= p.length - 3) {
                p1[i] = p[i];
            } else if (i % 3 == 0) {
                p2[i] = p[i];
            } else if (i % 3 == 1) {
                p3[i] = p[i];
            } else {
                p4[i] = p[i];
            }
        }
        //("玩家1的牌"+p1+"玩家2的牌"+p2+"玩家3的牌"+p3+"玩家4的牌"+p4);
        this.p = p;

    }
}