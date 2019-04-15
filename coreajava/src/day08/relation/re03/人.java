package day08.relation.re03;

import day08.relation.re03.汽车;

//关联关系
/*
* 人有汽车,但不是与生俱来的
* 需要从别处获得,是使用关系
* 所以需要set方法来提供
*
*
* */

public class 人 {

    private 汽车 q;

    public void setQ(汽车 q) {
        this.q = q;
    }


}
