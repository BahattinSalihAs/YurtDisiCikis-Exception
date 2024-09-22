package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException, HarcException {
        System.out.println("Sabiha Gökçen Havalimanına Hoşgeldiniz...");
        String sartlar = "Yurtdışı çıkış kuralları \n" +
                "Herhangi bir siyasi yasağınızın bulunmaması gerekiyor...\n" +
                "15 Tl harç bedelinizi tam olarak yatırmanız gerekiyor...\n" +
                "Gideceğiniz ülkeye vizenizin bulunması gerekiyor...";
        String message = "Yurtdışı Çıkış Kurallarının Hepsini Yerine Getirmeniz Gerekiyor...";

        while(true){
            System.out.println("*********************************");
            System.out.println(sartlar);
            System.out.println("*********************************");
            Yolcu yolcu = new Yolcu();

            System.out.println("Siyasi Yasak Kontrol Ediliyor...");
            Thread.sleep(3000);
            try{
                yolcu.siyasiYasakKontrol();
            }
            catch (SiyasiException e){
                e.printStackTrace();
                continue;
            }

            System.out.println("Yurt Dışı Harcı Kontrol Ediliyor...");
            Thread.sleep(3000);

            try{
                yolcu.yurtDisiHarciKontrol();
            }
            catch (HarcException e){
                e.printStackTrace();
                continue;
            }

            System.out.println("Vize Durumu Kontrol Ediliyor...");
            Thread.sleep(3000);
            try{
                yolcu.vizeDurumuKontrol();
            }
            catch (VizeException e){
                e.printStackTrace();
                continue;
            }

            System.out.println("Yurt Dışı Çıkış İşlemleriniz Tamam ! Yurt Dışına Çıkabilirsiniz...");
            break;
        }
    }
}