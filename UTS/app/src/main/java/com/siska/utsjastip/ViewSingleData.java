package com.siska.utsjastip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewSingleData extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_single_data);

        TextView tvPemesan = (TextView) findViewById(R.id.tv_pemesan);
        TextView tvNama = (TextView) findViewById(R.id.tv_nama_barang);
        TextView tvJumlah = (TextView) findViewById(R.id.tv_jumlah_barang);
        TextView tvHarga = (TextView) findViewById(R.id.tv_harga_barang);

        System.out.println("APPINVENT "+getIntent().getExtras().getString("pemesan"));
        tvPemesan.setText("Pemesan "+getIntent().getExtras().getString("pemesan"));
        tvNama.setText("Barang "+getIntent().getExtras().getString("nama"));
        tvJumlah.setText("Jumlah "+getIntent().getExtras().getString("jumlah"));
        tvHarga.setText("Harga "+getIntent().getExtras().getString("harga"));

        Button buttonOK = (Button) findViewById(R.id.bt_ok);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
