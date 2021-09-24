import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("src/main/java/HostList.txt"));
        Sender.handleAddresses(scan);
    }
}
