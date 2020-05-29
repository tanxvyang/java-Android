package day11;

public class Student implements Comparable<Student> { //是对象可以比较
    private Integer id;
    private String name;
    private Integer score;

    public Student(Integer id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    // @Override
    // public int compareTo(Object o) { //写比较规则
    //     if(o instanceof Student){
    //         Student student = (Student) o;
    //         return this.id-student.id;
    //     }
    //     return 1;
    // }

    @Override
    public int compareTo(Student o) { //写比较规则
        return this.id - o.id;
    }
}
