package com.example.deneme3;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

public class AO_URUN {
   private String ao_urunismi;
   private String ao_urunaciklama;
   private String ao_urunmiktar;
   private Double ao_fiyat;
   private String ao_urun_bilgisi;
   private String ao_urun_favori;
   private Bitmap  ao_bitmap;

    Context ao_context;

    public void setAo_context(Context ao_context) {
        this.ao_context = ao_context;
    }


    public AO_URUN(Context ao_context, String ao_urunismi, String ao_urunaciklama, String ao_urunmiktar, Double ao_fiyat, Bitmap ao_bitmap, String ao_urun_bilgisi, String ao_urun_favori) {
        this.ao_urunismi = ao_urunismi;
        this.ao_urunaciklama = ao_urunaciklama;
        this.ao_urunmiktar = ao_urunmiktar;
        this.ao_fiyat = ao_fiyat;
        this.ao_context=ao_context;
        this.ao_bitmap=ao_bitmap;
        this.ao_urun_bilgisi=ao_urun_bilgisi;
        this.ao_urun_favori=ao_urun_favori;
    }
    public String getAo_urun_favori() {
        return ao_urun_favori;
    }

    public void setAo_urun_favori(String ao_urun_favori) {
        this.ao_urun_favori = ao_urun_favori;
    }
    public String getAo_urun_bilgisi() {
        return ao_urun_bilgisi;
    }

    public void setAo_urun_bilgisi(String ao_urun_bilgisi) {
        this.ao_urun_bilgisi = ao_urun_bilgisi;
    }


    public Bitmap getAo_bitmap() {
        return ao_bitmap;
    }

    public void setAo_bitmap(Bitmap ao_bitmap) {
        this.ao_bitmap = ao_bitmap;
    }

    public String getAo_urunismi() {
        return ao_urunismi;
    }

    public void setAo_urunismi(String ao_urunismi) {
        this.ao_urunismi = ao_urunismi;
    }

    public String getAo_urunaciklama() {
        return ao_urunaciklama;
    }

    public void setAo_urunaciklama(String ao_urunaciklama) {
        this.ao_urunaciklama = ao_urunaciklama;
    }

    public String getAo_urunmiktar() {
        return ao_urunmiktar;
    }

    public void setAo_urunmiktar(String ao_urunmiktar) {
        this.ao_urunmiktar = ao_urunmiktar;
    }

    public Double getAo_fiyat() {
        return ao_fiyat;
    }

    public void setAo_fiyat(Double ao_fiyat) {
        if (ao_fiyat<0){
            if(ao_context!=null) {
                Toast.makeText(ao_context,
                        "ürün fiyatı negatif olamaz", Toast.LENGTH_SHORT).show();
            }
            this.ao_fiyat=0.0;
        }else{
            this.ao_fiyat=ao_fiyat;
        }

    }
}
