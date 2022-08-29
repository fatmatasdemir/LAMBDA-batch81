package lambda;

import java.util.stream.IntStream;

public class Fp04 {



    public static void main(String[] args) {

        System.out.println(get7den100eToplam()); // 5029
        System.out.println("get7den100eToplam02 :" + get7den100eToplam02());
        System.out.println("get2den11eCarpim :" + get2den11eCarpim());
        System.out.println(faktoriyelHesapla(4));// 6 YAZINCA 720 YAZAR

        System.out.println(ikiSayiArasindakiTumSayilarinRakamlariToplami(13,11));



    }

    ///1) 7'den 100'e kadar integer değerlerinin toplamını bulan bir method oluşturun.

    public static int get7den100eToplam() {

        // 2 SEKILDE YAPILIR 0 Ile baslayan yada getAsInt
        // return  IntStream.range(7,101).reduce(0,Math::addExact); // 5029
        return IntStream.range(7, 101).reduce(Math::addExact).getAsInt();

    }

    // 2.YOL

    public static int get7den100eToplam02() {

        return IntStream.rangeClosed(7, 100).reduce(Math::addExact).getAsInt();//get7den100eToplam02 :5029


    }

    //2) 2'den 11'e kadar integer değerlerinin çarpımını bulan bir method oluşturun.


    public static int get2den11eCarpim() {

        return IntStream.rangeClosed(2, 11).reduce(Math::multiplyExact).getAsInt();    // get2den11eCarpim :39916800


    }

    // //3) Verilen bir sayının faktoriyelini hesaplayan bir method oluşturun. (5 factorial = 1*2*3*4*5  ==> 5! = 1*2*3*4*5)
    public static int faktoriyelHesapla(int x) {

        if (x >= 0 ) {
            return IntStream.rangeClosed(1, x).reduce(Math::multiplyExact).getAsInt();


        }

        System.out.println("0'dan buyuk deger giriniz"); // 24


        return 0;

    }

    //4) Verilen iki sayı arasındaki çift sayıların toplamını bulan bir method oluşturun.

    // rangeClosed ==>> 5 ile 10 arasi ... dersek 10 dahil oluyor
    // range dersek 5 ile 10 arasi 10 almaz 9dahil eder
    // z=y;
    // y YI Z ATA  z=10; olur kendi icinde sayilar yer degistirir







    //5) Verilen iki sayı arasındaki tüm sayıların rakamlarının toplamını hesaplayan bir method oluşturun.
    //  23 and 32 ==> 2+3  +  2+4  +  2+5  +  2+6  +  2+7  +   2+8  +   2+9  +   3+0  +   3+1  +   3+2 ==> 68

    public static int ikiSayiArasindakiTumSayilarinRakamlariToplami(int x,int y){
        int z = 0;
        if (x>y){
            z = x;
            x = y;
            y = z;
        }



        return IntStream.rangeClosed(x, y).map(Utils::rakamlarToplaminiAl).sum();// 23,32 denedik ===>>68cikti
        // (11,13) yazdik =====> 9 CIKTI BURADA int z=0; yoktu
        // sonra 13, 11 YAPTIK SONUC YINE 9

    }



}








