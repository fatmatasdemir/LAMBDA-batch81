package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02 {


    /*
    1)  t-> "Logic" , (t, u)-> "Logic"
        Bu yapıya "Lambda Expession"
    2) Functional Programming kapsamında "Lambda Expession" kullanılabilir ama önerilmez.
       "Lambda Expession" yerine "Method Reference" tercih edilir.
    3) "Method Reference" kullanımı "Class Name :: Method Name"

       Aynı zamanda kendi class'larınızı da kullanabilirsiniz.
       Örneğin bir Animal class'ınız var ve bu class "eat()" methoduna sahip ==> "Animal :: eat"
     */
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();

        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste); // [8, 9, 131, 10, 9, 10, 2, 8]

        listElemanlariniYazdirFunctional(liste);//  8 9 131 10 9 10 2
        System.out.println();
        ciftElemanlarinYazdirFunctional(liste);//8 10 10 2 8
        System.out.println();
        tekElemanlarinKareleriniYazdir(liste); // 81 17161 81
        System.out.println();
        tekrarsizTekElemanlarinKupunuYazdir(liste); // 729 2248091  // 4:SORU
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami02(liste); // 168
        tekrarsizCiftElemanlarinKareToplami03(liste);// 168
        System.out.println();
        tekrarsizCiftElemanlarinKuplerininCarpimi(liste); // // 4096000
        System.out.println();
        getMaxEleman(liste);
        System.out.println();
        yedidenBuyukCiftMin(liste); // 8
        tersSiralamaylaTekrarsizElemanlarinYarisi(liste);

    }
    //1) Ardışık list elemanlarını aynı satırda aralarında boşluk bırakarak
    // yazdıran bir method oluşturun.(Functional ve method reference)

        public static void listElemanlariniYazdirFunctional(List<Integer>list){

          list.stream().forEach(Utils::ayniSatirdaBosluklaYazdir);
          // Utils clasina git ====>< public static void ayniSatirdaBosluklaYazdir(Object obj) {
            //        System.out.print(obj + " ");  calistir

        }


    //2)Ardışık çift list elementlerini aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.(Functional)

        public static void ciftElemanlarinYazdirFunctional(List<Integer>list){

        list.stream().filter(Utils::ciftElemaniSec).forEach(Utils::ayniSatirdaBosluklaYazdir); // 8 10 10 2 8
       // distinct() basa eklersek sonuc bu olur ===>>> 8 10 2  tekrarli olanlari yazdirmaz

        }

    // 3) Ardışık tek list elemanlarının karelerini aynı satırda
      //  aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)

        public static void tekElemanlarinKareleriniYazdir(List<Integer>list){

        list.stream().filter(Utils::tekElemaniSec).map(Utils::karesiniAl).forEach(Utils::ayniSatirdaBosluklaYazdir);
         // // 81 17161 81

        }


        // /4) Ardışık tek list elemanlarının küplerini tekrarsız olarak
        // aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.

         public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer>list) {

             list.stream().distinct().filter(Utils::tekElemaniSec).map(Utils::kupunuAl).forEach(Utils::ayniSatirdaBosluklaYazdir);
             // 729(9)  2248091 (131) sonucu
             // tekrar edenleri eler  UTILS clasina gider tekElemaniSec bakar ===>  return x%2!=0;
             // sonra 9 ve 131 secer ve map () kupunu alir forEach aynisatirda yazdirir

         }

         //5) Tekrarsız çift elemanların karelerinin toplamını hesaplayan bir method oluşturun
         // 1.YOL
            public static void tekrarsizCiftElemanlarinKareToplami(List<Integer>list){

      Integer toplam=list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesiniAl).reduce(0,Math::addExact);
                     //TEKRARSIZ//        / CIFTELEMANLAR /         /KARESINI AL/            /TOPLA/
                // baslangic 0 yazmak yerine  reduce(Math::addExact).get(); yazarsak yine calisir

                System.out.println(toplam);//168


            }

        public static void tekrarsizCiftElemanlarinKareToplami02(List<Integer>list){

            Integer toplam=list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesiniAl).reduce(Math::addExact).get();
            //TEKRARSIZ//        / CIFTELEMANLAR /         /KARESINI AL/            /TOPLA/


            System.out.println(toplam);//168


        }


     //3 .yol
        public static void tekrarsizCiftElemanlarinKareToplami03(List<Integer>list){

            Integer toplam=list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesiniAl).reduce(0,Integer::sum );
            //TEKRARSIZ//        / CIFTELEMANLAR /         /KARESINI AL/            /TOPLA/


            System.out.println(toplam);//168


        }


        //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.

          public  static void tekrarsizCiftElemanlarinKuplerininCarpimi(List<Integer>list){

        Integer carpim= list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::kupunuAl).reduce(1,Math::multiplyExact);

              System.out.println(carpim); // 4096000
          }



          //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.

          public static void getMaxEleman(List<Integer>list){

         Integer max= list.stream().distinct().reduce(Math::max).get();

              System.out.println(max); // 131



          }

          //  ÖDEV 8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(Method Reference)






        //9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.

          public static void yedidenBuyukCiftMin(List<Integer>list){

          Integer min= list.stream().distinct().filter(t->t>7).filter(Utils::ciftElemaniSec).reduce(Math::min).get();
              System.out.println(min);


          }


           //10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların
        // yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.

        public static void tersSiralamaylaTekrarsizElemanlarinYarisi(List<Integer>list){

      List<Double> sonuc=  list.stream(). // gerekli methodlari kullanmamizi saglar
                distinct(). // tekrarli olanlari almaz
                filter(t->t>5). // kosula göre filtreleme yapar
                map(Utils::yarisinAl). // her bir elemanin degerini degistirmeye yarar
                sorted(Comparator.reverseOrder()). //TERS SIRALAM YAPAR BU METHOD
                 collect(Collectors.toList()); // //Elamanları collection'a çevirir.

            System.out.println(sonuc);// [65.5, 5.0, 4.5, 4.0]

        }






    }

