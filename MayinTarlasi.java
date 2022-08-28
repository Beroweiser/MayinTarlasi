/**
 * MayinTarlasi
 */
import java.util.Scanner;
public class MayinTarlasi {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Mayın tarlasının satır sayısını giriniz : "); 
        int satir = scan.nextInt();
        System.out.print("Mayın tarlasının sütun sayısını giriniz : ");
        int sutun = scan.nextInt();
        MineSweeper trl = new MineSweeper(satir, sutun);
        
        trl.yazdirma();


    }
}