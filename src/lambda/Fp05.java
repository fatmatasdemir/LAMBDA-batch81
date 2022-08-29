package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp05 {


    public static void main(String[] args) {

        Courses courseTurkishDay = new Courses("Summer", "Turkish Day", 97, 128);
        Courses courseTurkishNight = new Courses("Winter", "Turkish Night", 98, 154);
        Courses courseEnglishDay = new Courses("Spring", "English Day", 95, 132);
        Courses courseEnglishNight = new Courses("Winter", "English Night", 93, 144);


        List<Courses> coursesList = new ArrayList<>();
        coursesList.add(courseTurkishDay);
        coursesList.add(courseTurkishNight);
        coursesList.add(courseEnglishDay);
        coursesList.add(courseEnglishNight);

        System.out.println("ortalamaPuanlarVerilenSayidanBuyukMu :" +ortalamaPuanlarVerilenSayidanBuyukMu(coursesList,10));

        System.out.println( "kelimeKursAdlariIcindeVarMi :" +kelimeKursAdlariIcindeVarMi(coursesList,"Turkish"));
        ortalamasıEnYuksekKursunAdiniYazdir(coursesList);
        System.out.println(    ortalamaPuanaGoreSiralaVeIlkVerilenleriAtla(coursesList,1));


    }
    //1)Tüm ortalama puanların verilen sayıdan büyük olup olmadığını kontrol etmek için bir method oluşturun.
    public static boolean ortalamaPuanlarVerilenSayidanBuyukMu(List<Courses>list,double x){

        return  list.stream().allMatch(t->t.getAverageScore()>x);//ortalamaPuanlarVerilenSayidanBuyukMu :true 75

        // 93 YAZARSAK   ortalamaPuanlarVerilenSayidanBuyukMu :false son sayimiz 93 diye
    }


    //2)Kurs adlarından en az birinin verilen kelimeyi içerip içermediğini kontrol etmek için bir method oluşturun

    public static boolean kelimeKursAdlariIcindeVarMi(List<Courses>list, String kelime){

        return  list.stream().anyMatch(t->t.getCourseName().contains(kelime));
        // anyMatch ===> herhangi biri demek //sonra kursname gitti bakti yazdigimiz iceriyormu diye
        // kelimeKursAdlariIcindeVarMi :true  SOUT ICINE Turkish yazmistik


    }


    //3) Ortalama puanı en yüksek olan kursu yazdırmak için bir yöntem oluşturun

    public static void ortalamasıEnYuksekKursunAdiniYazdir(List<Courses>list){

        String sonuc= list.stream().sorted(Comparator.comparing(Courses::getAverageScore).reversed()).findFirst().get().getCourseName();
        // Comparator rakamlari icinde dolanir yuksek olani bulur
        // findFirst ==> objesi getirir Turkish Night --->get(); TN(obj)  --->ICINDEN KURSUN ADINI ALIR YAZAR

        System.out.println(sonuc); // Turkish Night

    }

    //4) Liste öğelerini artan düzende ortalama puana göre sıralayın ve ilk verilenleri atlayın

    public static List<Courses> ortalamaPuanaGoreSiralaVeIlkVerilenleriAtla(List<Courses>list,int x){


        return list.stream().sorted(Comparator.comparing(Courses::getAverageScore)).skip(x).collect(Collectors.toList());
    }


    //[Course: Season=Spring, courseName=English Day, averageScore=95, numberOfStudents=132,
    // Course: Season=Summer, courseName=Turkish Day, averageScore=97, numberOfStudents=128,
    // Course: Season=Winter, courseName=Turkish Night, averageScore=98, numberOfStudents=154]
    //(1) yazdik diye english night yazdirmadi 2.den basladi
    //(3) yazarsak ilk 3 gecer sadece 1 tane yazar
    //bunu [Course: Season=Winter, courseName=Turkish Night, averageScore=98, numberOfStudents=154]

}










