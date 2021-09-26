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

    private static boolean handleRequest(String url) throws MalformedURLException {
        URL myUrl = new URL(url);

        try {
            HttpURLConnection myUrlCon = (HttpURLConnection) myUrl.openConnection();
            myUrlCon.setConnectTimeout(5000);
            myUrlCon.setReadTimeout(5000);
            myUrlCon.setRequestMethod("HEAD");
            int responseCode = myUrlCon.getResponseCode();
            
            if (responseCode == 200) {
                System.out.println("Host: " + url + " is available, response code: " + responseCode);
                return true;
            } else  {
                System.out.println("Host: " + url + " is not available, response code: " + responseCode);
                return true;
            }
        } catch (IOException exception) {
            System.out.println("Host: " + url + "Catch IOException, please check correctness of the input  host name");
            return false;
        }
    }
}







/*



finally {
                if (statusCode != 200 & countTryConnet == 10){
                    System.out.println("Host: " + url + " is not avalable, response code: " + statusCode);
*/


