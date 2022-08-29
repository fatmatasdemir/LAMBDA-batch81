package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01 {



        /*
        1) Lambda (Functional Programming) Java 8 ile kullanilmaya baslamistir
        2)Functional Programming'de "Ne yapilacak"(What to do ) uzerine yogunlasilir .
        Structured Programming "Nasil yapilacak" (How to do ) uzerine yogunlasir.
        3) Functional Programming, Arrays ve Collections ile kullanilir.
        4)entrySet() methodu ile Map , Set'e donusturulerek Functional Programming de kullanilabilir

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

            listElemanlariniYazdirStructured(liste);
            System.out.println();
            listElemanlariniYazdirFunctional(liste);
            System.out.println();
            ciftElemanlaiYazdirStructured(liste);
            System.out.println();
            System.out.println("Functional :");
            ciftElemanlariYazdirFunctional(liste);
            System.out.println();
            tekElemanlarinKareleriniYazdir(liste); // 81 17161 81
            System.out.println();
            tekrarsizTekElemanlarinKupunuYazdir(liste); // 729 2248091
            System.out.println();
            tekrarsizCiftElemanlarinKareToplami(liste); // 168
            tekrarsizCiftElemanlarinKupununCarpimi(liste);
            getMaxEleman01(liste);
            getMaxEleman02(liste);
            getYedidenBuyukCiftMin(liste);
            getYedidenBuyukCiftMin2(liste);
            getYedidenBuyukCiftMin3(liste);
            getTersSiralamaylaTekrarsizElemanlarinYarisi(liste);


        }



    //1) Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Structured)

      public static  void listElemanlariniYazdirStructured(List<Integer>list){

          for (Integer w :list){

              System.out.print(w+" "); // 8 9 131 10 9 10 2 8

          }


      }
     // Lambda sindi uygulacagiz 49. satirdan itibaren
    //1)Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)

        public static  void listElemanlariniYazdirFunctional(List<Integer>list){

            list.stream().forEach(t-> System.out.print(t+" "));   // 8 9 131 10 9 10 2 8

            // stream() methodu collection dan elementleri akisa dahil etmek icin ve methodlara ulasmak icin kullanilir

    /*


       [8, 9, 131, 10, 9, 10, 2, 8] listemiz ilk boyleydi
       stream ile asagidaki gibi oldugunu dusunun
         //stream aliyor bir forma koyuyor
         forEach tek tek aliyor t 'ye koyuyor  yazdirirken soutun icinde bosluk ile yazdiriyor (t+" ")
         STREAM akisi sagliyor  forEach dogru
     8
     9
     131
     10
     9
     10
     2
     8


     */

        }

          //2.  çift sayi  list elemanlarini aynı satırda aralarında
         // boşluk bırakarak yazdıran bir method oluşturun.(Structured)

        public static void ciftElemanlaiYazdirStructured(List<Integer>list){ // Nasil yapilir java bilgimiz ile yaptik

            for (Integer w:list) {
                if(w%2==0){
                    System.out.print(w+" "); // 8 10 10 2 8
                }
            }

        }

        //2.  çift sayi  list elemanlarini aynı satırda aralarında
        // boşluk bırakarak yazdıran bir method oluşturun.(Functional)

        public static void ciftElemanlariYazdirFunctional(List<Integer>list){

            list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" ")); //8 10 10 2 8

            //FILTER  2 bölenden kalan 0 olmazsa filterden gecmez //kalan 0 olursa filterden gecer forEach a gider

        }

        //3) Ardışık (ardarda) tek list elemanlarinin karelerini
    // aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)

       public static void tekElemanlarinKareleriniYazdir(List<Integer>list){

            list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t+" ")); //// 81 17161 81
          // t%2==1 yapabiliriz degerler degisecegi icin map()  nethodunu kulladik (karelerini alacagiz)

           // list miz hep ayni atama sonra yapmadik diye biz sadece gecici oynamalar yaptik
           /*
           listemizdeki sayilari stream ile filter gonderiyoruz kalan sifir degilse filterden gecer map gider
           mapda carpim olur Ornek 9*9->81 OLUR  sonra forEach gider yazdirir arada bosluk birakarak
            */
       }

    /*  Ardışık tek list elementlerinin
        küplerini tekrarsız olarak aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
    */
        public static void  tekrarsizTekElemanlarinKupunuYazdir(List<Integer>list) {

            list.stream().distinct().filter(t -> t % 2 != 0).map(t -> t * t * t).forEach(t-> System.out.print(t+" "));

                //   distinct()tekrar eden sayilari eler. ayni sayilari almamamiz icin kullaniyoruz
                // [8, 9, 131, 10, 9, 10, 2, 8] LISTEDE  iki tane 8 var ,9 var bu method ile sadece bir 8,bir 9 alinip
                // filter gider orada 2 ile bolunmede kalan 0 degilse filterden gecer map gider islem gorur (9*9*9)
                // distinct her yere koyulabilir basa koyarsak kolaylik olur cunku tekrar edenler en basta eler

             // 729 2248091




            /*
            [8, 9, 131, 10, 9, 10, 2, 8]

            ILK 8 gider distinct () gecer  filter gider kalan 0 diye filterden gecmez
            9 gelir filterden gecer devam eder map  gider
            131 de gecer
            10 gecmez
            9 gelir distinct de bakar önceden 9 islendi diye devam etmez
            8 ; 9 ;10 aynilar bu yuzden distinct 2 kez gecmez

             */
        }

        //5) Tekrarsız çift elemanlarin karelerinin toplamını hesaplayan bir method oluşturun.

        public static void tekrarsizCiftElemanlarinKareToplami(List<Integer> list){

         Integer toplam= list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);
         // ilk olarak ayni sayilar elenir sonra filter gider kalan 0 olanlari secer sonra
            // kareleri alinir sonra toplanir

         // [8, 9, 131, 10, 9, 10, 2, 8]

            /*
            tekrarsiz cift sayilar 8 (64) ,10(100) , 2 (4)      64+100+2=168 olur

            0 ilk olarak atanir
            t-->0 olur
                    ========>>> 64 OLUR
            u-->64
            **************************
            t-->64
                     ======>>>> 164
            u-->100
            ****************************

            t---> 164
               =============>>>>>>  168 OLUR
            u--->4
             */



           /*
       reduce() => Azaltmak demek. Reduce işlemi genelde kümülatif operasyonlarda sıkça kullanılır. Bir veri
    setinde sırayla işlem yapmak istiyorsanız ve bir önceki yaptığınız işlemi de dahil etmek istiyorsanız
    reduce metodunu kullanabilirsiniz. İlişkili bir biriktirme işlevi kullanarak bu akışın öğelerinde bir
    azalma gerçekleştirir ve varsa indirgenmiş
    değeri açıklayan bir İsteğe Bağlı döndürür. Maksimumminimum bulma, toplama-çarpma işleminde kullanılır.




            */





             // bu bize bir sayi verdi u yuzden Integer toplam = yazdik
            //reduce () methodu tek degere indirmek icin misal 10,8 ,
            // KARELERI alinacak sonra toplanacak ortaya bir deger cikacak
            // reduce de toplama yaparken icine 2 deger yazmamiz layim t,u
             // 0 baslangic olarak yazdik / Integer NON-PRIMITIVE data turudur



            System.out.println(toplam); // 168



        }
        //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.
        public static void tekrarsizCiftElemanlarinKupununCarpimi(List<Integer> list){

            Integer carpim = list.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)-> t*u);

            System.out.println(carpim);
        }





        //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
        //1. Yol:
        public static void getMaxEleman01(List<Integer> list){

            Integer max = list.stream().distinct().reduce(Integer.MIN_VALUE, (t,u)-> t>u ? t : u );

            System.out.println(max);
        }

        //2. Yol:
        public static void getMaxEleman02(List<Integer> list){

            Integer max = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t,u)->u);

            System.out.println("max = " + max);
        }

        //Ödev
        //8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(2 Yol ile)



        //9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.
        //1. Yol:
        public static void getYedidenBuyukCiftMin(List<Integer> list){

            Integer min =  list.
                    stream().
                    distinct().
                    filter(t->t%2==0).
                    filter(t->t>7).
                    reduce(Integer.MAX_VALUE,(t,u)-> t<u ? t : u);

            System.out.println(min);
        }

        //2. Yol:
        public static void getYedidenBuyukCiftMin2(List<Integer> list){

            Integer min = list.
                    stream().
                    distinct().
                    filter(t->t%2==0).
                    filter(t->t>7).
                    sorted(Comparator.reverseOrder()).
                    reduce(Integer.MAX_VALUE,(t,u)->u);

            System.out.println(min);
        }
        //3. Yol:
        public static void getYedidenBuyukCiftMin3(List<Integer> list){

            Integer min = list.
                    stream().
                    filter(t->t%2==0).
                    filter(t->t>7).
                    sorted().
                    findFirst().
                    get();

            System.out.println(min); //

        }

        //10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.

        public static void getTersSiralamaylaTekrarsizElemanlarinYarisi(List<Integer> list){

            List<Double> sonuc =  list.stream().distinct().filter(t-> t>5).map(t->t/2.0).
                    sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            System.out.println(sonuc); //

        }

    /*
    [8, 9, 131, 10, 9, 10, 2, 8]
    8 9 131 10 9 10 2 8
    8 9 131 10 9 10 2 8
    8 10 10 2 8
    Functional :
    8 10 10 2 8
    81 17161 81
    729 2248091
    168
    4096000
    131
    max = 131
    8
    8
    8
    [65.5, 5.0, 4.5, 4.0]













     */















    }

