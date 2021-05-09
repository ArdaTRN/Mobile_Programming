package com.example.deneme3;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ao_isim,ao_aciklama,ao_fiyat;
    Spinner ao_urun_miktar;
    ArrayList<AO_URUN> ao_urunler;
    ArrayList<String> ao_urun_checkbox , ao_urun_radio;
    Button ao_urun_listele,ao_btn_foto_cek;
    RadioButton ao_urun_yiyecek,ao_urun_icecek,ao_urun_diger;
    CheckBox ao_favori;
    ImageView ao_imageview;
    Bitmap ao_bitmap;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Bundle ao_bnd = data.getExtras();
            ao_bitmap = (Bitmap) ao_bnd.get("data");
            ao_imageview.setImageBitmap(ao_bitmap);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ao_isim=findViewById(R.id.ao_etxt_urun_isim);
        ao_aciklama=findViewById(R.id.ao_etxt_urun_aciklama);
        ao_fiyat=findViewById(R.id.ao_etxt_urun_fiyat);
        ao_urun_miktar=findViewById(R.id.ao_spinner);
        ao_urun_listele=findViewById(R.id.ao_urun_listele);
        ao_urunler=new ArrayList<>();
        ao_imageview=findViewById(R.id.ao_imageView2_foto);
        ao_btn_foto_cek=findViewById(R.id.ao_btn_fotograf_cek);
        ao_urun_yiyecek=findViewById(R.id.ao_rdb_yiyecek);
        ao_urun_icecek=findViewById(R.id.ao_rdb_icecek);
        ao_urun_diger=findViewById(R.id.ao_rdb_diger);
        ao_favori=findViewById(R.id.ao_chb_favori);
        ao_urun_radio = new ArrayList<>();
        ao_urun_checkbox = new ArrayList<>();
        ao_urun_yiyecek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ao_urun_yiyecek.isChecked()) {
                    ao_urun_radio.add("Yiyecek");
                } else {
                    ao_urun_radio.remove("Yiyecek");
                }
            }
        });
        ao_urun_icecek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ao_urun_icecek.isChecked()) {
                    ao_urun_radio.add("İçecek");
                } else {
                    ao_urun_radio.remove("İçecek");
                }
            }
        });
        ao_urun_diger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ao_urun_diger.isChecked()) {
                    ao_urun_radio.add("Diğer ürün");
                } else {
                    ao_urun_radio.remove("Diğer ürün");
                }
            }
        });
        ao_favori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (ao_favori.isChecked()) {
                        ao_urun_checkbox.add("Favorilere Eklendi");
                    } else {
                        ao_urun_checkbox.add(" ");
                    }
            }
        });


        ao_urun_listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ao_intent=new Intent(MainActivity.this, AO_ListeAktivite.class);
                AO_UrunVeritabani.ao_myurunler=ao_urunler;
                startActivity(ao_intent);
            }
        });
        ao_btn_foto_cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ao_intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(ao_intent,1 );
            }
        });
    }


    public void ao_urunOlustur(View view) {
        for (String ao_radio_add : ao_urun_radio) {
            for (String ao_checkbox_add : ao_urun_checkbox){
                ao_urunler.add(new AO_URUN(MainActivity.this, ao_isim.getText().toString(),
                        ao_aciklama.getText().toString(),
                        ao_urun_miktar.getSelectedItem().toString(),
                        Double.parseDouble(ao_fiyat.getText().toString()), ao_bitmap, ao_radio_add, ao_checkbox_add));
            Toast.makeText(getApplicationContext(), "Ürün Sayısı: " + ao_urunler.size() + " , Eklenen : " + ao_urunler.get(ao_urunler.size() - 1).getAo_urunismi(),
                    Toast.LENGTH_LONG).show();
        }
    }
    }
}
