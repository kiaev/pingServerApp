import java.net.*;
import java.util.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

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

    private static boolean handleRequest(String url) throws Exception {
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
        } catch (MalformedURLException e) {
            System.out.println("Bad URL: " + url);
            return false;
        } catch (UnknownHostException e){
            System.out.println("Host: "+url+" is unknown");
            return false;
        } catch (IOException e) {
            System.out.println("Host: " +url+ " Catch IOException, please check correctness of the input host name");
            return false;
        }
    }
}
