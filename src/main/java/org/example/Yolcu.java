package org.example;

import java.util.Scanner;

class SiyasiException extends  Exception{
    @Override
    public void printStackTrace() {
        System.out.println("Siyasi Yasağınız Bulunuyor...");
    }
}
class VizeException extends Exception{
    @Override
    public void printStackTrace() {
        System.out.println("Gideceğiniz Ülkeye Vizeniz Bulunmamaktadır...");
    }
}
class HarcException extends Exception{
    @Override
    public void printStackTrace() {
        System.out.println("Lütfen yurtdışı harcını tam yatırın...");
    }
}
public class Yolcu {
    private int harc;
    private boolean siyasiYasak;
    private boolean vizeDurumu;
    public Yolcu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Yatırdığınız Harç Bedeli: ");
        this.harc = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Siyasi Yasağınız bulunuyor mu (evet ya da hayır)?");
        String cevap = scanner.nextLine();
        if (cevap.equals("evet")){
            this.siyasiYasak = true;
        }
        else{
            this.siyasiYasak = false;
        }

        System.out.println("Vizeniz bulunuyor mu(evet ya da hayır)?");
        String cevap2 = scanner.nextLine();
        if (cevap2.equals("evet")){
            this.vizeDurumu = true;
        }
        else{
            this.vizeDurumu = false;
        }
    }
    public void yurtDisiHarciKontrol() throws HarcException {
        if (harc < 15){
            throw new HarcException();
        }
        else{
            System.out.println("Yurtdışı harcı tamam.");

        }
    }
    public void siyasiYasakKontrol() throws SiyasiException {
        if (this.siyasiYasak == true){
            throw new SiyasiException();
        }
        else{
            System.out.println("Siyasi yasak yok geç.");
        }
    }
    public void vizeDurumuKontrol() throws VizeException {
        if (this.vizeDurumu == false){
            throw new VizeException();
        }
        else{
            System.out.println("Vizen var geç.");
        }
    }

}
