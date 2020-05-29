package day07.test6;

public class test06 {
    public static void main(String[] args) {
        C[] cs = new C[3];
        // C c=new C();
     /*  for (int i=0;i<cs.length;i++){
           c.setName("c"+i);
           cs[i]=c;
       }
        for (int i=0;i<cs.length;i++){
            System.out.println(cs[i].getName());
        }

        // c2
        // c2
        // c2

*/
    /*    for (int i=0;i<cs.length;i++){
            c.setName("c"+i);
            cs[i]=c;
            System.out.println(cs[i].getName());
        }*/
        // c0
        // c1
        // c2

        for (int i = 0; i < cs.length; i++) {
            C c = new C();
            c.setName("c" + i);
            cs[i] = c;
        }
        for (int i = 0; i < cs.length; i++) {
            System.out.println(cs[i].getName());
        }


    }
}

class C {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
