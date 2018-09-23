package Stoke;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestNetwork {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr= InetAddress.getLocalHost();
        String ip =addr.getHostAddress();
        System.out.println(ip);// ipconfig  192.168.72.1
        InetAddress addr2=InetAddress.getByName("www.baidu.com");
        System.out.println(addr2.getHostAddress());

    }
}
