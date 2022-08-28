import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class MineSweeper {
    String[][] tarla;
    String[][] mayinTarla;
    int mayin;
    int boyut;
    int satir;
    int sutun;

    public MineSweeper(int satir, int sutun) {
        this.tarla = new String[satir][sutun];
        this.satir = satir;
        this.sutun = sutun;
        this.boyut = satir * sutun;
        this.mayin = boyut / 4;
        this.mayinTarla = new String[satir][sutun];
    
    }
    public void mine(){
        Random random = new Random();
        int x = 0, y = 0;

        for (int i = 0; i < this.mayin; i++) {

            x = random.nextInt(satir);
            y = random.nextInt(sutun);

            while (this.mayinTarla[x][y] == "* ") {
                x = random.nextInt(satir);
                y = random.nextInt(sutun);
            }

            this.mayinTarla[x][y] = "* ";
        }
        for(String[] row: this.mayinTarla){
            System.out.println(Arrays.toString(row));
        }
    }

    public void yazdirma() {
        System.out.println("Mayınların konumu : ");
        mine();
        System.out.println("==============================");
        System.out.println("Mayın Tarlası Oyununa Hosgeldiniz !");
        Scanner scan = new Scanner(System.in);

        tablo(this.satir, this.sutun);

        System.out.print("Satır Giriniz : ");
        int sa = scan.nextInt();
        System.out.print("Sütun Giriniz : ");
        int su = scan.nextInt();
        field(sa, su);
        tarladaNeVar();

        while(!isContinue(sa, su)){
            
            System.out.print("Satır Giriniz : ");
            sa = scan.nextInt();
            System.out.print("Sütun Giriniz : ");
            su = scan.nextInt();
            field(sa, su); 
            tarladaNeVar();
            System.out.println("==============================");
            if(isWin()){
                System.out.println("Oyunu Kazandınız !");
                tarladaNeVar();
                break;
            }
            
        }
        if(isContinue(sa, su)){
        System.out.println("Game Over !");
        }
        System.out.println("==============================");
        scan.close();
    }
    public void tablo(int a, int b){
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("- ");
                this.tarla[i][j] = "- ";
            }
            System.out.println();
        }

    }
    public void tarladaNeVar(){
        for (int i = 0; i < this.satir; i++) {
            for (int j = 0; j < this.sutun; j++) {
                System.out.print(this.tarla[i][j]);
            }
            System.out.println();
        }
    }

    public void field(int a, int b) {
        for (int i = 0; i < this.satir; i++) {
            for (int j = 0; j < this.sutun; j++) {
                if (i == a && j == b) {
                    this.tarla[i][j] = String.format("%d ",kacTaneMayinVarEtrafinda(i, j));
                }
            }
        }
        
    }
    public boolean isContinue(int a, int b){
        boolean i = this.mayinTarla[a][b] == "* " ? true : false ; 
        return i;
    }
    public boolean isWin(){
        int counter = 0;
        for (int i = 0; i < this.satir; i++) {
            for (int j = 0; j < this.sutun; j++) {
                if(this.tarla[i][j] == "- ")
                counter++;
            }
            
        }
        if(counter == this.mayin){
            return true;
        }
        return false;
    }

    public int kacTaneMayinVarEtrafinda(int i, int j) {
        int counter = 0;
        if (j - 1 >= 0) {
            if (this.mayinTarla[i][j - 1] == "* ") {
                counter++;
            }
        }
        if (j + 1 < this.sutun) {
            if (this.mayinTarla[i][j + 1] == "* ") {
                counter++;
            }
        }
        if (i - 1 >= 0) {
            if (this.mayinTarla[i - 1][j] == "* ") {
                counter++;
            }
            if (j - 1 >= 0) {
                if (this.mayinTarla[i - 1][j - 1] == "* ") {
                    counter++;
                }
            } else if (j + 1 < this.sutun) {
                if (this.mayinTarla[i - 1][j + 1] == "* ") {
                    counter++;
                }
            }

        }
        if (i + 1 < this.satir) {
            if (this.mayinTarla[i + 1][j] == "* ") {
                counter++;
            }
            if (j - 1 >= 0) {
                if (this.mayinTarla[i + 1][j - 1] == "* ") {
                    counter++;
                }
            }
            if (j + 1 < this.sutun) {
                if (this.mayinTarla[i + 1][j + 1] == "* ") {
                    counter++;
                }
            }

        }
        return counter;
    }

}
