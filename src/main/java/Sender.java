import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.ArrayList;

public class Sender {

    public static void handleIPArray(Scanner scan) throws Exception {
        ArrayList<String> list = new ArrayList<String>();

        while (scan.hasNext()){
            list.add(scan.next());
        }
        scan.close();
        for (int i = 0; i < list.size(); i++){
            String ipAddress = list.get(i);
            Sender.sendPingRequest(ipAddress);
        }
    }

    private static void sendPingRequest(String ipAddress) throws Exception {
        InetAddress inetAddress = InetAddress.getByName(ipAddress);
        int countTryConnet = 0;

        System.out.println("Sending Ping Request to " + ipAddress);
        while (countTryConnet < 10) {
            try {
                if (inetAddress.isReachable(5000)) {
                    System.out.println("Host "+ipAddress+" is available");
                    break;
                } else {
                    countTryConnet++;
                    System.out.println(countTryConnet);
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        if (countTryConnet == 10){
            System.out.println("Sorry ! Host "+ipAddress+" is not available. Check please");
        }
    }
}
