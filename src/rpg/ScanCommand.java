package rpg;

import java.util.Scanner;

public class ScanCommand{
    private static Scanner scan = new Scanner(System.in);

    public ScanCommand(){
    }

    public static int scan(){
        return scan.nextInt();
    }

    public static void close(){
        scan.close();
    }
}
