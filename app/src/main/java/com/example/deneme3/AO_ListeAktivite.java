package com.example.deneme3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AO_ListeAktivite extends AppCompatActivity {
    ListView ao_urun_goster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_o__liste_aktivite);
        ao_urun_goster=findViewById(R.id.ao_urun_listele);
        ArrayList<AO_URUN> ao_urun= AO_UrunVeritabani.ao_myurunler;
       // Toast.makeText(AO_ListeAktivite.this,ao_urun.get(0).getAo_urunismi(),Toast.LENGTH_SHORT).show();
        AO_UrunAdapter ao_urunAdapter = new AO_UrunAdapter(AO_ListeAktivite.this, 0, ao_urun);
        ao_urun_goster.setAdapter(ao_urunAdapter);
    }
}
