package fiksturFUTBOLMAC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fikstur {



    static int takimSayisi;
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("liginiz kaç takımlı olsun");
        takimSayisi=scanner.nextInt();
        List<String> takimlar = new ArrayList<String>();
        while(takimlar.size()!=takimSayisi) {
            System.out.println("takimlarinizi giriniz");
            takimlar.add(scanner.next());
        }
        if(takimSayisi%2!=0){
            takimlar.add("BAY");
            takimSayisi++;
        }
        List<String>karilmisTakimlar = new ArrayList<String>();
        for (int i = 0; i <takimSayisi ; i++) {
            int rnd=new Random().nextInt(takimlar.size());
            karilmisTakimlar.add(takimlar.get(rnd));
            takimlar.remove(takimlar.get(rnd));
        } haftalikMaclar(karilmisTakimlar);
    }

    private static void haftalikMaclar(List<String> karilmisTakimlar) {
        int hafta=1;
        while(hafta<=2*takimSayisi-2){
            System.out.println("hafta = " + hafta);
            String takimX="",takimY="";
            for (int i = 0; i <takimSayisi/2 ; i++) {
                if(i==0&&hafta%2!=0){
                    takimY = karilmisTakimlar.get(i);
                    takimX = karilmisTakimlar.get(takimSayisi - i - 1);
                }else if(hafta%2==0){
                    takimX =karilmisTakimlar.get(i);
                    takimY=karilmisTakimlar.get(takimSayisi-i-1);
                }else {
                    takimY = karilmisTakimlar.get(i);
                    takimX = karilmisTakimlar.get(takimSayisi - i - 1);
                }

                System.out.println(takimY+" vs "+takimX);

            } String ctakim=karilmisTakimlar.get(1);
            karilmisTakimlar.remove(ctakim);
            karilmisTakimlar.add(ctakim);
            hafta++;  }

    }
}
















