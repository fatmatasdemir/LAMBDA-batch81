package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fp03 {

    public static void main(String[] args) {


        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");

        System.out.println(liste);
        //[Ali, Ali, Mark, Amanda, Christopher, Jackson, Mariano, Alberto, Tucker, Benjamin]
        buyukHarfleYazdir(liste);
        System.out.println();
        //  buyukHarfleYazdir02(liste);//[ALİ, ALİ, MARK, AMANDA, CHRİSTOPHER, JACKSON, MARİANO, ALBERTO, TUCKER, BENJAMİN]

        System.out.println();
        uzunlugaGoreYazdir(liste);
        System.out.println();
        uzunlugaGoreTersYazdir(liste);
        System.out.println();
        sonKaraktereGoreTekrarsizYazdir(liste);
        System.out.println();
        uzunlukVeIlkHarfeGoreSiralaYazdir(liste);
        System.out.println();
        // bestenBuyukleriSil(liste);  LISTEMIZI TAMAMEN DEGISTIRDIGI ICIN YORUM ICINE ALDIK
        // System.out.println(liste);
        System.out.println();
        //baslangiciAYadaSonuNOlaniSil(liste);
        //baslangiciAYadaSonuNOlaniSil02(liste);
        //uzunlugu8ile10arasiveOIleBiteniSil(liste);
        System.out.println("uzunlugu12denAzMi :"+ uzunlugu12denAzMi(liste));
        System.out.println("xIleBaslamiyorMu :" +xIleBaslamiyorMu(liste));
        System.out.println("rIleBitiyorMu :" +rIleBitiyorMu(liste));

    }


    //1) Tüm elemanları büyük harf ile yazdıran bir method oluşturun.
    // 1:YOL
    public static void buyukHarfleYazdir(List<String> list) {

        list.stream().map(String::toUpperCase).forEach(Utils::ayniSatirdaBosluklaYazdir);
        // ALİ ALİ MARK AMANDA CHRİSTOPHER JACKSON MARİANO ALBERTO TUCKER BENJAMİN
    }

// 2.YOL


  /*  public static void buyukHarfleYazdir02(List<String>list) {

        list.replaceAll(String::toUpperCase);
        TUM ELEMANLARI AL String toUpperCase METHODU ILE BUYUK YAP

        System.out.println(list);//[ALİ, ALİ, MARK, AMANDA, CHRİSTOPHER, JACKSON, MARİANO, ALBERTO, TUCKER, BENJAMİN]


    }
*/

    //2) Elemanları uzunluklarına göre sıralayıp yazdıran bir method oluşturun.

    public static void uzunlugaGoreYazdir(List<String> list) {

        list.stream().sorted(Comparator.comparing(String::length)).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
        //Comparator.comparing (); siralama kosulun belirtmek icin kullanilir

        // Ali Ali Mark Amanda Tucker Jackson Mariano Alberto Benjamin Christopher

    }


    //3) Elemanları uzunluklarına göre ters sıralayıp yazdıran bir method oluşturun.

    public static void uzunlugaGoreTersYazdir(List<String> list) {

        list.stream().
                sorted(Comparator.comparing(String::length).reversed()).
                forEach(Utils::ayniSatirdaBosluklaYazdir);

        // Christopher Benjamin Jackson Mariano Alberto Amanda Tucker Mark Ali Ali

    }

    //4) Elemanları son karakterlerine göre sıralayıp tekrarsız yazdıran bir method oluşturun.

    public static void sonKaraktereGoreTekrarsizYazdir(List<String>list){

        list.stream().distinct().sorted(Comparator.comparing(Utils::sonKarakteriAl)).
                forEach(Utils::ayniSatirdaBosluklaYazdir);

        //Amanda Ali Mark Jackson Benjamin Mariano Alberto Christopher Tucker
        //yukardaki ekleme liste sirasindan dolayi   jackson dan sonra benjamin geliyor
    }



    //5) Elemanları önce uzunluklarına göre ve sonra ilk karakterine göre sıralayıp yazdıran bir method oluşturun.

    public static void uzunlukVeIlkHarfeGoreSiralaYazdir(List<String>list){

        list.stream().sorted(Comparator.comparing(String::length).
                thenComparing(Utils::ilkKarakteriAl)).forEach(Utils::ayniSatirdaBosluklaYazdir);

        // //thenComparing() :==>siralama icin bir kosul daha belirtir
        // Ali Ali Mark Amanda Tucker Alberto Jackson Mariano Benjamin Christopher
        // 1:HEDEF uzunluk 2:hedef ilkharfler


    }

     /*    6: SORU YORUMA ALDIK CUNKU AKTIF OLSA LISTEMIZ DE SADECE Ali, Ali, Mark olur
     list mutable oldugu icin elemanlari islem sonrasi kalici
      //6) Uzunluğu 5'ten büyük olan elemanları silen bir method oluşturun.

    public static void bestenBuyukleriSil(List<String>list){

        list.removeIf(t->t.length()>5);
        System.out.println(list); // [Ali, Ali, Mark]
        // UZUNLUGU 5 ten buyuk olanlari alip listeden sildi

        stream kullanırsak liste degistirecek metodları kullanamıyoruz zaten.
        stream kullanmazsak removeIf, replace gibi listeyi degiştiren metodları kullanabiliyoruz


    }
*/
    //7) ‘A’, ‘a’ ile başlayan yada ‘N’, ‘n’ ile biten elemanları silen bir method oluşturun.
    //1. Yol
//    public static void baslangiciAYadaSonuNOlaniSil(List<String> list){
//
//        list.removeIf(t->t.charAt(0)=='A'||t.charAt(0)=='a'||t.charAt(t.length()-1)=='N'||t.charAt(t.length()-1)=='n');
//        System.out.println(list);
//
//    }
    //2. Yol
//    public static void baslangiciAYadaSonuNOlaniSil02(List<String > list){
//
//        list.removeIf(t->t.startsWith("A")||t.startsWith("a")||t.endsWith("N")||t.endsWith("n"));
//        System.out.println(list);//[Mark, Christopher, Mariano, Tucker]
//
//    }
    //8) Uzunluğu 8 ile 10 arası olan yada 'o' ile biten elemanları silen bir method oluşturun.
//    public static void uzunlugu8ile10arasiveOIleBiteniSil(List<String > list){
//
//        list.removeIf(t->(t.length()>7 && t.length()<11) || t.endsWith("o"));
//        System.out.println(list);
//
//    }


    // 9) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol eden bir method oluşturun.


    public static boolean uzunlugu12denAzMi(List<String> list){

        return list.stream().allMatch(t->t.length()<12);
       //
        // Uzunlugu12denAzMi :true
        // anyMath herhangi biri demek anlaminda herhangi biri karsiliyorsa ,uyuyorsa
    }



    //10) Hiçbir elemanın 'X' ile başlamadığını kontrol eden bir method oluşturun.

    public static boolean xIleBaslamiyorMu(List<String>list){

        return list.stream().noneMatch(t->t.startsWith("X") || t.startsWith("x"));

        // xIleBaslamiyorMu :true


    }


    //11) Herhangi bir elemanın 'r' ile bitip bitmediğini kontrol eden bir method oluşturun.

    public static boolean rIleBitiyorMu(List<String> list){

        return list.stream().anyMatch(t->t.endsWith("r"));

        // rIleBitiyorMu :true


    }










}
