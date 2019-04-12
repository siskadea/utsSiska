package com.siska.utsjastip;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.siska.utsjastip.db.DbDataSource;
import com.siska.utsjastip.models.Barang;

public class CreateData extends Activity implements View.OnClickListener {
    //inisilisasi elemen-elemen pada layout
    private Button buttonSubmit;
    private EditText edPemesan;
    private EditText edNama;
    private EditText edJumlah;
    private EditText edHarga;

    //inisialisasi kontroller/Data Source
    private DbDataSource dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_data);

        buttonSubmit = (Button) findViewById(R.id.buttom_submit);
        buttonSubmit.setOnClickListener(this);
        edPemesan = (EditText) findViewById(R.id.pemesan);
        edNama = (EditText) findViewById(R.id.nama_barang);
        edHarga = (EditText) findViewById(R.id.harga_barang);
        edJumlah = (EditText) findViewById(R.id.jumlah_barang);

        // instanstiasi kelas DBDataSource
        dataSource = new DbDataSource(this);

        //membuat sambungan baru ke database
        dataSource.open();
    }

    //KETIKA Tombol Submit Diklik
    @Override
    public void onClick(View v) {
        // Inisialisasi data barang
        String pemesan = null;
        String nama = null;
        String jumlah = null;
        String harga = null;
        @SuppressWarnings("unused")

        //inisialisasi barang baru (masih kosong)
                Barang barang = null;
        if (edPemesan.getText() != null && edNama.getText() != null && edJumlah.getText() != null && edHarga.getText() != null) {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            pemesan = edPemesan.getText().toString();
            nama = edNama.getText().toString();
            jumlah = edJumlah.getText().toString();
            harga = edHarga.getText().toString();
        }

        switch (v.getId()) {
            case R.id.buttom_submit:
                // insert data barang baru
                barang = dataSource.createBarang(pemesan, nama, jumlah, harga);

                //konfirmasi kesuksesan
                Toast.makeText(this, "Pesanan masuk \n" +
                        " pemesan" + barang.getPemesan() +
                        " nama" + barang.getNama() +
                        " jumlah" + barang.getJumlah() +
                        " harga" + barang.getHarga(), Toast.LENGTH_LONG).show();
                break;
        }

    }
}
