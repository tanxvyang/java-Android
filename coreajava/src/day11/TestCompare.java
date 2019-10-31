package day11;

import java.util.Arrays;
import java.util.Comparator;

public class TestCompare {
    public static void main(String[] args) {
        Student[] students = {new Student(6,"111",76),
                              new Student(2,"aaa",23),
                              new Student(3,"ddd",34),
                              new Student(5,"daa",45),
                              new Student(1,"aax",56),
                              new Student(4,"xxx",67),};
        //排序
       // Arrays.sort(students);
       // selectSort(students);


        //按成绩排序

       //  Arrays.sort(students, new Comparator<Student>() {
       //      @Override
       //      public int compare(Student o1, Student o2) {
       //          Student s1 = o1;
       //          Student s2 = o2;
       //          return s2.getScore() - s1.getScore();
       //      }
       //  });



        // 按姓名排序,字典顺序
         Arrays.sort(students,new Comparator<Student>() {
             @Override
             public int compare(Student o1, Student o2) {
                 Student s1 = o1;
                 Student s2 = o2;
              //  return s1.getName().compareTo(s2.getName());
             return String.CASE_INSENSITIVE_ORDER.compare(s1.getName(),s2.getName());
             }
         });


//输出student[] 中的数据

        for (int i = 0;i< students.length;i++) {
            Student student = students[i];
            System.out.println(student.getId()+ " "+  student.getName() + " " +student.getScore());
        }
    }

public static void selectSort(Object[] a){
    for (int i = 0; i < a.length-1; i++) {
        for (int j = i + 1; j < a.length ; j++) {
            Comparable c1 = (Comparable) a[i];
            Comparable c2 = (Comparable) a[j];
            if (c1.compareTo(c2)>0) {
                Object temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

        }

    }
}

}
