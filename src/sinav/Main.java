package sinav;

import java.io.IOException;

import static sinav.DosyaOkuma.*;
import static sinav.Sinif.oturumSaatleri;

public class Main {

    public static void main(String[] args) throws IOException {
        oturumSaatleri(dersvevKodlariniOkuma(),ogrencivealdigiDersleriOkuma(),ogretmenListiOlusturma());
    }




}
