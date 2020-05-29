package day08.Poker;

public class Pai {
    public static final int ACE = 1;
    public static final int J = 11;
    public static final int Q = 12;
    public static final int K = 13;
    public static final int heitao = 0;
    public static final int hongtao = 1;
    public static final int fangpian = 2;
    public static final int meihua = 3;
    public static final int xiaowang = 14;
    public static final int dawang = 15;


    private int dianshu;
    private int huase;

    public Pai(int dianshu, int huase) {
        this.dianshu = dianshu;
        this.huase = huase;
    }

    @Override
    public String toString() {
        String huase = null;
        String dianshu = null;
        switch (this.huase) {
            case 0:
                huase = "黑桃";
                break;
            case 1:
                huase = "红桃";
                break;
            case 2:
                huase = "方片";
                break;
            case 3:
                huase = "梅花";
                break;
            case 14:
                huase = "小王";
                break;

            case 15:
                huase = "大王";
                break;

        }
        switch (this.dianshu) {
            case ACE:
                dianshu = "A";
                break;
            case J:
                dianshu = "J";
                break;

            case Q:
                dianshu = "Q";
                break;

            case K:
                dianshu = "K";
                break;
            case 14:
                dianshu = "小王";
                break;
            case 15:
                dianshu = "大王";
                break;
            default:
                dianshu = this.dianshu + "";
                break;


        }

        return huase + dianshu;
    }
}
