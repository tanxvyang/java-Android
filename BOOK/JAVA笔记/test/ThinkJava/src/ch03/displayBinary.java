package ch03;

public class displayBinary {
    public static void main(String[] args) {

        displayBinary(44);
    }
    public static void displayBinary(int value){
        if (value>0){
            displayBinary(value/2);
            System.out.print(value%2);
        }


    }


}
