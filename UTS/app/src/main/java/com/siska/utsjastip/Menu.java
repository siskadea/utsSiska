package com.siska.utsjastip;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Menu extends Activity implements View.OnClickListener {
    private Button bTambah;
    private Button bLihat;
    private Button bKoleksi;
    private Button bKunjungi;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        bKoleksi = (Button) findViewById(R.id.button_koleksi);
        bKoleksi.setOnClickListener(this);
        bTambah = (Button) findViewById(R.id.button_tambah);
        bTambah.setOnClickListener(this);
        bLihat = (Button) findViewById(R.id.button_view);
        bLihat.setOnClickListener(this);
        bKunjungi = (Button) findViewById(R.id.button_ig);
        bKunjungi.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button_tambah :
                Intent i = new Intent(this, CreateData.class);
                startActivity(i);
                break;
            case R.id.button_view :
                Intent i2 = new Intent(this, ViewData.class);
                startActivity(i2);
                break;
            case R.id.button_koleksi:
                Intent i3 = new Intent(this, KoleksiActivity.class);
                startActivity(i3);
                break;
            case R.id.button_ig:
                String url = "https://instagram.com/miniso.indonesia?utm_source=ig_profile_share&igshid=fwprhigbevjj";
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else {
                    Log.d("ImplicitIntents", "Can't handle this intent");
                }
                break;
        }
    }

}
