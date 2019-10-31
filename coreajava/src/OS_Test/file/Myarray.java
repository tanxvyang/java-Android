package OS_Test.file;

public class Myarray {
    private long[] array;
    //表示有效数据的长度
    private int elements;

    public Myarray() {
        array = new long[50];
    }

    public Myarray(int maxSize){
        array = new long[maxSize];//这个大小是从创建文件时传入的
    }

    //接下来插入数据
    public void insert(int values){
        //第一次添加是为0的，即values
        array[elements]=values;
        elements++;//让她递增
        //当第二次调用这儿添加的时候，array[elements]里面是为1,然后递增为2
    }
    //显示数据
    public void diplay(){
        System.out.print("[");
        //用for循环遍历，i=0，下标为0
        for (int i = 0; i < elements; i++) {
            System.out.print(array[i]+"  ");
        }
        System.out.println("]");
    }

    public void diplayone(int j){
        System.out.print("[");
        //用for循环遍历，i=0，下标为0
        if (j>elements||j<0){
            //判断数组下标是否越界
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < elements; i++) {
            if (array[i] == array[j]){
                System.out.print(array[j]+"  ");
            }
        }
        System.out.println("]");

        // System.out.print("[");
        // System.out.print(array[j]+"  ");
        // System.out.println("]");
    }




    //删除数据
//    根据index来删除数据
    public void delete(int index){
        //删除也需要对index进行判断
        if(index >=elements || index<0)//如果index大于有效元素，或者小于0
        {
            //抛出一个异常
            throw new ArrayIndexOutOfBoundsException();
        }
        //假设数组的值分别为1,3,4，5，如果要删除3，那么我们把4的值赋值给array[1]，即3就可以了，覆盖她
//        5接着覆盖4，最后把elements减去1；表示有效长度减去1
        else{
            //i从index开始，小于i++
            for (int i = index; i < elements; i++) {
                //前面的值等于后面的值
                array[index]=array[index+1];
            }
            //最后还要对有效的长度减1
            elements--;
        }
    }



}
