package day07;

public class Room {
    private int id;
    private boolean state;
    private Coustomer coustomer;

    public Room(int id) {
        this.id = id;
        state=false;
        coustomer=null;
    }
    public boolean in(Coustomer coustomer){
        this.coustomer=coustomer;
        state=true;
        return true;
    }
    public boolean out(){
        this.coustomer=null;
        state=false;
        return true;

    }
    public int getId() {
        return id;
    }

    public boolean isState() {
        return state;
    }

    public Coustomer getCoustomer() {
        return coustomer;
    }

    public String toString(){
        if (false==state){
            return "空房";

        }
        return coustomer.getName();
        //coustomer.toString
        //return cuoustomer+""
    }


}
