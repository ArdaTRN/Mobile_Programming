package com.example.deneme3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
public class AO_UrunAdapter extends ArrayAdapter<AO_URUN> {
    Context context;
    public AO_UrunAdapter(@NonNull Context context, int resource, @NonNull List<AO_URUN> objects) {
        super(context, resource, objects);
        this.context=context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =LayoutInflater.from(context);

        convertView=inflater.inflate(R.layout.ao_urun_satir,parent,false);
        AO_URUN ao_urun = getItem(position);
        TextView ao_urun_ad=convertView.findViewById(R.id.ao_txt1);
        TextView ao_urun_aciklamasi=convertView.findViewById(R.id.ao_txt2);
        TextView ao_urun_fiyat=convertView.findViewById(R.id.ao_txt3);
        TextView ao_urun_tipi =convertView.findViewById(R.id.ao_txt4);
        TextView ao_urunbilgi=convertView.findViewById(R.id.ao_txt5);
        TextView ao_urunfavorilerim=convertView.findViewById(R.id.ao_txt6);
        Button ao_siparis=convertView.findViewById(R.id.ao_btn_siparis);
        ImageView ao_imageview = convertView.findViewById(R.id.ao_imageView_fotogoster);


        ao_urun_ad.setText(ao_urun.getAo_urunismi());
        ao_urun_aciklamasi.setText(ao_urun.getAo_urunaciklama());
        ao_urun_fiyat.setText(String.valueOf(ao_urun.getAo_fiyat()));
        ao_urun_tipi.setText(ao_urun.getAo_urunmiktar());
        ao_imageview.setImageBitmap(ao_urun.getAo_bitmap());
        ao_urunbilgi.setText(ao_urun.getAo_urun_bilgisi());
        ao_urunfavorilerim.setText(ao_urun.getAo_urun_favori());



        ao_siparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ao_urun.getAo_urunismi()+ " : Sipariş Oluşturulmuştur.", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
