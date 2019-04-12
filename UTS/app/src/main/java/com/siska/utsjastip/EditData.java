package com.siska.utsjastip;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.app.Activity;

import com.siska.utsjastip.db.DbDataSource;
import com.siska.utsjastip.models.Barang;

public class EditData extends Activity implements View.OnClickListener {
    private DbDataSource dataSource;

    private long id;
    private String pemesan;
    private String nama;
    private String jumlah;
    private String harga;

    private EditText edPemesan;
    private EditText edNama;
    private EditText edJumlah;
    private EditText edHarga;

    private TextView txId;

    private Button btnSave;
    private Button btnCancel;

    private Barang barang;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data);
        //inisialisasi variabel
        edPemesan = (EditText) findViewById(R.id.editText_pemesan);
        edNama = (EditText) findViewById(R.id.editText_nama);
        edJumlah = (EditText) findViewById(R.id.editText_jumlah);
        edHarga = (EditText) findViewById(R.id.editText_harga);
        txId = (TextView) findViewById(R.id.text_id_barang);
        //buat sambungan baru ke database
        dataSource = new DbDataSource(this);
        dataSource.open();
        // ambil data barang dari extras
        Bundle bun = this.getIntent().getExtras();
        id = bun.getLong("id");
        pemesan = bun.getString("pemesan");
        nama = bun.getString("nama");
        jumlah = bun.getString("jumlah");
        harga = bun.getString("harga");
        //masukkan data-data barang tersebut ke field editor
        txId.append(String.valueOf(id));
        edPemesan.setText(pemesan);
        edNama.setText(nama);
        edJumlah.setText(jumlah);
        edHarga.setText(harga);

        //set listener pada tombol
        btnSave = (Button) findViewById(R.id.button_save_update);
        btnSave.setOnClickListener(this);
        btnCancel = (Button) findViewById(R.id.button_cancel_update);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
            // apabila tombol save diklik (update barang)
            case R.id.button_save_update :
                barang = new Barang();
                barang.setPemesan(edPemesan.getText().toString());
                barang.setNama(edNama.getText().toString());
                barang.setJumlah(edJumlah.getText().toString());
                barang.setHarga(edHarga.getText().toString());
                barang.setId(id);
                dataSource.updateBarang(barang);
                Intent i = new Intent(this, ViewData.class);
                startActivity(i);
                EditData.this.finish();
                dataSource.close();
                break;
            // apabila tombol cancel diklik, finish activity
            case R.id.button_cancel_update :
                finish();
                dataSource.close();
                break;
        }
    }

    }

