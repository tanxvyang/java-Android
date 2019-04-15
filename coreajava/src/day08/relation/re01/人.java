package day08.relation.re01;
//组合关系
/*
* 人和心脏是组合关系
* 心脏和人是同步生成的
* 直接在人出现时就new出来的,不可替换
*
* */




public class 人 {
    private 心脏 x;

    public 人() {
        x=new 心脏();

    }

}
