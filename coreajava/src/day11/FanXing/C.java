package day11.FanXing;


//E是C类的参数
//表示任意类型,
//当调用时传什么类型就是什么类型
//如果没传,当做Object使用
//泛型只在编译期间 有效
//运行时当做Object


public class C <E,T extends Number>{  //限定  T传的值只能是Number 类型或其子类型
    private E e;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
    public T f(E e){
        return null;
    }
}
