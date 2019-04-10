package day07.hotel;

public class TestHotel {
    public static void main(String[] args) {
        Hotel hotel=new Hotel("xxx");
        hotel.search();

        Coustomer coustomer=new Coustomer("abc");

        boolean b=hotel.in(302, coustomer);

        if (true==b){
            System.out.println(coustomer+"入住成功");
        }else {
            System.out.println("房间有客人");
        }
        hotel.search();

        boolean b2=hotel.out(302);
        if (true==b2){
            System.out.println("退房成功");
        }else {
            System.out.println("房间没有客人");
        }
    }
}
