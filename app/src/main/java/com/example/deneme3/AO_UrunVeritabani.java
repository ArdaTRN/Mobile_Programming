package com.example.deneme3;

import java.util.ArrayList;

public class AO_UrunVeritabani {
    static ArrayList<AO_URUN> ao_myurunler=new java.util.ArrayList<>();
    public static ArrayList<AO_URUN> getAo_urunler() {
        return ao_myurunler;
    }
    public static void setAo_urunler(ArrayList<AO_URUN> AO_URUN) {
        AO_UrunVeritabani.ao_myurunler = ao_myurunler;
    }
}
