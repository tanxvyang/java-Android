package day07.HumanMarriage;

public class person {
    private String name;
    private boolean  sex;
    private person  partener;

    public person(String name, boolean sex) {
        this.name = name;
        this.sex = sex;
    }

    public person() {
    }


    public boolean marry(person partener){
     if (this.sex==partener.sex){
         System.out.println("同性不能结婚");
         return false;
     }
     if (this.partener!=null||partener.partener!=null){
         System.out.println("已经结婚的不能在结婚");
         return false;
     }

        //我的配偶是跟我结婚的人
        this.partener=partener;
        //跟我结婚的人的配偶是我
        partener.partener=this;

        return true;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public person getPartener() {
        return partener;
    }

    public void setPartener(person partener) {
        this.partener = partener;
    }
}
