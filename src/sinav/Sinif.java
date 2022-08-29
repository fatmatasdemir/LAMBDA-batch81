package sinav;

import java.util.*;

public class Sinif {

    public static void oturumSaatleri(Map<String, String> derslerveKodlar, Map<String,Ogrenci>ogrencilerveDersleri, List<String> ogretmenlisteleri){
        List <String> oturumsuzKodlar=new ArrayList<String>();
        List <String> oturumluKodlar=new ArrayList<String>();
        List <String> ogrencilerlist=new ArrayList<String>();
        for (Map.Entry<String,String> each:derslerveKodlar.entrySet()) {
            oturumsuzKodlar.add(each.getKey());

        }
        int count =0;
        List <String>oturumsaaatleri=new ArrayList<String>();
        oturumsaaatleri.add("pazartesi 09:00");
        oturumsaaatleri.add("pazartesi 14:00");
        oturumsaaatleri.add("sali 09:00");
        oturumsaaatleri.add("sali 14:00");
        oturumsaaatleri.add("carsamba 09:00");
        oturumsaaatleri.add("carsamba 14:00");
        oturumsaaatleri.add("persembe 09:00");
        oturumsaaatleri.add("persembe 14:00");
        oturumsaaatleri.add("cuma 09:00");
        oturumsaaatleri.add("cuma 14:00");
        while (!oturumsuzKodlar.isEmpty()){
            int rnd=new Random().nextInt(oturumsuzKodlar.size());
            String  derskodu=oturumsuzKodlar.get(rnd);
            oturumsuzKodlar.remove(derskodu);
            oturumluKodlar.add(derskodu);
            ogrencilerlist=dersKodunaGoreOgrenciler(ogrencilerveDersleri,derskodu);
            int oturum=1;
            sinavOturumuKalip sinav=new sinavOturumuKalip(ogretmenlisteleri,ogrencilerlist,count,oturum,oturumsaaatleri,derskodu,derslerveKodlar.get(derskodu));
            System.out.printf("%-30s",sinav.oturumSaati);
            System.out.printf("%-15s",sinav.dersKodu);
            System.out.printf("%-30s",sinav.dersAd);
            System.out.printf("%-45s",sinav.ogretmen);
            System.out.printf("%-30s",sinav.sinif);
            //System.out.println(sinav.ogrenciad);
            System.out.println();
            List <String> ayniOtrumluDersListi=new ArrayList<String>();
            ayniOtrumluDersListi=aynioturumdaYapilabilecekSinavlar(ogrencilerveDersleri,ogrencilerlist,derslerveKodlar);
            if(ayniOtrumluDersListi.size()>0){
                String derskodu2=ayniOtrumluDersListi.get(0);
                if(!oturumluKodlar.contains(derskodu2)){
                    oturum=2;
                    oturumluKodlar.add(derskodu2);
                    oturumsuzKodlar.remove(derskodu2);
                    ogrencilerlist=dersKodunaGoreOgrenciler(ogrencilerveDersleri,derskodu2);
                    sinavOturumuKalip sinav2=new sinavOturumuKalip(ogretmenlisteleri,ogrencilerlist,count,oturum,oturumsaaatleri,derskodu2,derslerveKodlar.get(derskodu2));
                    System.out.printf("%-30s",sinav2.oturumSaati);
                    System.out.printf("%-15s",sinav2.dersKodu);
                    System.out.printf("%-30s",sinav2.dersAd);
                    System.out.printf("%-45s",sinav2.ogretmen);
                    System.out.printf("%-30s",sinav2.sinif);

                    // System.out.println(sinav2.ogrenciad);
                    System.out.println();

                }
            }

            count++; }
    }






    private static List<String> aynioturumdaYapilabilecekSinavlar(Map<String, Ogrenci> ogrencilerveDersleri,  List <String> ogrencilerlist, Map<String, String> derslerveKodlar) {
        Set<String> kodlar=new HashSet<>();
        Set<String> alinanDersler=new HashSet<>();
        for(Map.Entry<String, String> each : derslerveKodlar.entrySet()){
            kodlar.add(each.getKey());
        }for(String each : ogrencilerlist){
            for(Map.Entry<String, Ogrenci> each2:ogrencilerveDersleri.entrySet()){
                if(each.equals(each2.getValue().ogr_adi)){
                    alinanDersler.add(each2.getValue().ogr_ders);
                }}
        }

        kodlar.removeAll(alinanDersler);
        return new ArrayList<String>(kodlar);
    }


    private static List<String> dersKodunaGoreOgrenciler(Map<String, Ogrenci> ogrencilerveDersleri,String derskoduOturum) {
        List <String>dersKoduOgrenciler = new ArrayList<String>();
        for(Map.Entry<String, Ogrenci> entry : ogrencilerveDersleri.entrySet()){
            if(derskoduOturum.equals(entry.getValue().ogr_ders)){
                dersKoduOgrenciler.add(entry.getValue().ogr_adi);
            }
        }

        return dersKoduOgrenciler;}

}

















