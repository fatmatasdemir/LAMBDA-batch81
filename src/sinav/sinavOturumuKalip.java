package sinav;

import java.util.List;

public class sinavOturumuKalip implements SinifOturum{
    List<String> ogrenciad;
    String sinif;
    String dersKodu;
    String dersAd;
    String ogretmen;
    String oturumSaati;

    public sinavOturumuKalip(){}
    public sinavOturumuKalip(List<String> ogretmenad, List<String> ogrenciad, int count,int aynianda, List<String>oturumSaati, String dersKodu, String dersAd) {
        this.ogretmen =setOgretmen(ogrenciad, ogretmenad);
        this.ogrenciad = ogrenciad;
        setOturumSaatleri(count,oturumSaati);
        this.dersKodu = dersKodu;
        this.dersAd = dersAd;
        sinifBelirleme(ogrenciad,aynianda);

    }

    private void setOturumSaatleri(int oturum, List<String> oturumSaati) {

        if (oturum<=9){
            this.oturumSaati="1. hafta "+oturumSaati.get(oturum);

        }else if (oturum<20) {
            this.oturumSaati="2. hafta "+oturumSaati.get(oturum-10);

        }
    }


    public String setOgretmen(List<String> ogrenciad, List<String> ogretmenad) {
        String og="";
        if (ogrenciad.size()>sinifMevcudu*2&&!(ogretmenad.isEmpty())) {

            og="--"+ogretmenad.get(0);
            ogretmenad.remove(ogretmenad.get(0));
        }
        if (ogrenciad.size()>sinifMevcudu&&!(ogretmenad.isEmpty())) {

            og = "--"+ogretmenad.get(0)+og;;
            ogretmenad.remove(ogretmenad.get(0));

        }
        if (ogrenciad.size() >0&&!(ogretmenad.isEmpty())) {
            og = ogretmenad.get(0)+og;  ;
            ogretmenad.remove(ogretmenad.get(0));

        }
        this.ogretmen=og;
        return ogretmen;
    }

    public String sinifBelirleme(List<String> ogrenciad, int session) {

        switch (session) {
            case 1:
                if (ogrenciad.size() < sinifMevcudu) {
                    this.sinif = "A-101";
                } else if (ogrenciad.size() < sinifMevcudu*2) {
                    this.sinif = "A-101 --- A-102";
                } else if (ogrenciad.size() < sinifMevcudu*3) {
                    this.sinif = "A-101--- A-102--- A-103";
                }
                break;
            case 2:
                if (ogrenciad.size() < sinifMevcudu) {
                    this.sinif = "B-101";
                } else if (ogrenciad.size() < sinifMevcudu*2) {
                    this.sinif = "B-101 --- B-102";
                } else if (ogrenciad.size() < sinifMevcudu*3) {
                    this.sinif = "B-101--- B-102--- B-103";
                }
                break;

        }
        return sinif;

    }
















}
