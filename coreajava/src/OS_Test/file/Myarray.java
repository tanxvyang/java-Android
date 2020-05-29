package OS_Test.file;

public class Myarray {
    private long[] array;
    //��ʾ��Ч���ݵĳ���
    private int elements;

    public Myarray() {
        array = new long[50];
    }

    public Myarray(int maxSize) {
        array = new long[maxSize];//�����С�ǴӴ����ļ�ʱ�����
    }

    //��������������
    public void insert(int values) {
        //��һ�������Ϊ0�ģ���values
        array[elements] = values;
        elements++;//��������
        //���ڶ��ε��������ӵ�ʱ��array[elements]������Ϊ1,Ȼ�����Ϊ2
    }

    //��ʾ����
    public void diplay() {
        System.out.print("[");
        //��forѭ��������i=0���±�Ϊ0
        for (int i = 0; i < elements; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println("]");
    }

    public void diplayone(int j) {
        System.out.print("[");
        //��forѭ��������i=0���±�Ϊ0
        if (j > elements || j < 0) {
            //�ж������±��Ƿ�Խ��
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < elements; i++) {
            if (array[i] == array[j]) {
                System.out.print(array[j] + "  ");
            }
        }
        System.out.println("]");

        // System.out.print("[");
        // System.out.print(array[j]+"  ");
        // System.out.println("]");
    }


    //ɾ������
//    ����index��ɾ������
    public void delete(int index) {
        //ɾ��Ҳ��Ҫ��index�����ж�
        if (index >= elements || index < 0)//���index������ЧԪ�أ�����С��0
        {
            //�׳�һ���쳣
            throw new ArrayIndexOutOfBoundsException();
        }
        //���������ֵ�ֱ�Ϊ1,3,4��5�����Ҫɾ��3����ô���ǰ�4��ֵ��ֵ��array[1]����3�Ϳ����ˣ�������
//        5���Ÿ���4������elements��ȥ1����ʾ��Ч���ȼ�ȥ1
        else {
            //i��index��ʼ��С��i++
            for (int i = index; i < elements; i++) {
                //ǰ���ֵ���ں����ֵ
                array[index] = array[index + 1];
            }
            //���Ҫ����Ч�ĳ��ȼ�1
            elements--;
        }
    }


}
