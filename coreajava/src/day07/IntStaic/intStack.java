package day07.IntStaic;

public class intStack {
    //放数据的空间
    private int[] data;//data 外部不可getset
     //当前栈中放几个数字
    private  int size;//size 外部可获得,不可操作

    //创建一个栈,这个栈最多能放几个元素
    public  intStack(int max) {
        data=new int[max];
        size=0;

    }

    //构造方法
    //创建一个栈,这个栈最多能放10个元素

    public intStack() {
        //  data=new int[max];
        //         size=0;
        this(10);          //调用自己 this();只能出现在构造方法的第一行

    }
    //栈是否满
    public boolean isFull(){
        return size==data.length;
    }

    //栈是否空
    public boolean isEmpty(){
        return  size==0;
    }

    public int getSize() {//外部可以获得
        return size;
    }
    //入栈
    public void push(int i){
        if (isFull()){
            throw new RuntimeException("栈已满");


        }
        data[size++]=i;
    }
    //出栈

    public int pop() {
        if (isEmpty()){
            throw new  RuntimeException("栈已空");
        }
         return data[--size];
    }
}
