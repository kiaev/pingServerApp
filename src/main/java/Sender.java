import java.net.*;
import java.util.*;
import java.io.IOException;

public class Sender {

    public static void handleAddresses(Scanner scan) throws Exception {
        ArrayList<String> list = new ArrayList<String>();

        while (scan.hasNext()) {
            list.add(scan.next());
        }
        scan.close();
        for (int i = 0; i < list.size(); i++) {
            String url = list.get(i);
            Sender.handleRequest(url);
        }
    }

    private static void handleRequest(String url) throws Exception {
        URL myUrl = new URL(url);
        int countTryConnet = 0;

        HttpURLConnection myUrlCon = (HttpURLConnection) myUrl.openConnection();
        int statusCode = myUrlCon.getResponseCode();

        while (countTryConnet < 10) {
            try {
                if (statusCode == 200) {
                    System.out.println("Host: " + url + " is avalable, response code: " + statusCode);
                    break;
                } else {
                    countTryConnet++;
                    System.out.println("Try to connect host...");
                }
            } finally {
                if (statusCode != 200 & countTryConnet == 10){
                    System.out.println("Host: " + url + " is not avalable, response code: " + statusCode);
            }
        }
        }
    }
}







