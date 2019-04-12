package com.siska.utsjastip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.siska.utsjastip.adapter.KoleksiAdapter;
import com.siska.utsjastip.models.Koleksi;

import java.util.ArrayList;
import java.util.List;

public class KoleksiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);

        List<Koleksi> dataList = new ArrayList<>();
        dataList.add(new Koleksi("brand_1", "HnM","Baju, aksesoris",R.drawable.hm));
        dataList.add(new Koleksi("brand_2", "ZARA","Tas, baju", R.drawable.z));
        dataList.add(new Koleksi("brand_3", "MINISO","Tas, aksesoris, kosmetik", R.drawable.m));
        dataList.add(new Koleksi("brand_4", "BERSKHA","Baju, aksesoris" ,R.drawable.b));
        dataList.add(new Koleksi("brand_5", "FILA","Baju, sepatu" ,R.drawable.f));
        dataList.add(new Koleksi("brand_5", "PULL n BEAR","Baju, jaket, aksesoris" , R.drawable.pb));


        KoleksiAdapter adapterKoleksi = new KoleksiAdapter(dataList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_daftar);
        recyclerView.setAdapter(adapterKoleksi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
