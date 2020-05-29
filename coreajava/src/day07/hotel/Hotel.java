package day07.hotel;

//酒店
public class Hotel {
    private String name;
    private Room[][] rooms;

    public Hotel(String name) {
        this.name = name;
        //创建所有房间
        rooms = new Room[10][12];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                rooms[i][j] = new Room((i + 1) * 100 + (j + 1));
            }
        }
    }

    public void search() {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j].getId() + "\t");
            }
            System.out.println();
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j] + "\t");
            }
            System.out.println();
            System.out.println();

        }

    }

    public boolean in(int roomNo, Coustomer customer) {
        int i = roomNo / 100 - 1;
        int j = roomNo % 100 - 1;
        if (rooms[i][j].isState() == true) {
            return false;
        }
        rooms[i][j].in(customer);

        return true;
    }


    public boolean out(int roomNo) {
        int i = roomNo / 100 - 1;
        int j = roomNo % 100 - 1;
        if (rooms[i][j].isState() == false) {
            return false;
        }
        rooms[i][j].out();
        return true;
    }


    public String getName() {
        return name;
    }
}
