package com.siska.utsjastip.db;

import android.view.View;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.siska.utsjastip.R;
import com.siska.utsjastip.models.Barang;

public class DbDataSource {
    private SQLiteDatabase database;
    private DbHelper dbHelper;
    //ambil semua nama kolom
    private String[] allColumns = { DbHelper.COLUMN_ID,
            DbHelper.COLUMN_PEMESAN,DbHelper.COLUMN_NAME, DbHelper.COLUMN_JUMLAH,DbHelper.COLUMN_HARGA};

    public DbDataSource(Context context)
    {
        dbHelper = new DbHelper(context);
    }

    //membuat sambungan baru ke database
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    //menutup sambungan ke database
    public void close() {
        dbHelper.close();
    }
    //insert barang ke database
    public Barang createBarang(String pemesan, String nama, String jumlah, String harga) {

        // mengambil data dari db
        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_PEMESAN, pemesan);
        values.put(DbHelper.COLUMN_NAME, nama);
        values.put(DbHelper.COLUMN_JUMLAH, jumlah);
        values.put(DbHelper.COLUMN_HARGA, harga);

        // insert data
        long insertId = database.insert(DbHelper.TABLE_NAME, null,
                values);
        // menyesuaikan data dengan menyesuaikan ID
        Cursor cursor = database.query(DbHelper.TABLE_NAME,
                allColumns, DbHelper.COLUMN_ID + " = " + insertId, null,null,
                null, null, null);
        // pindah ke data paling pertama
        cursor.moveToFirst();
        Barang newBarang = cursorToBarang(cursor);
        cursor.close();
        return newBarang;
    }

    private Barang cursorToBarang(Cursor cursor)
    {
        Barang barang = new Barang();
        // debug LOGCAT
        Log.v("info", "The getLONG "+cursor.getLong(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));

        barang.setId(cursor.getLong(0));
        barang.setPemesan(cursor.getString(1));
        barang.setNama(cursor.getString(2));
        barang.setJumlah(cursor.getString(3));
        barang.setHarga(cursor.getString(4));
        return barang;
    }


    public ArrayList<Barang> getAllBarang() {
        ArrayList<Barang> daftarBarang = new ArrayList<Barang>();
        //select all
        Cursor cursor = database.query(DbHelper.TABLE_NAME,
                allColumns, null, null, null, null, null, null);
        cursor.moveToFirst();
        // jika masih ada data, masukkan data barang ke
        // daftar barang
        while (!cursor.isAfterLast()) {
            Barang barang = cursorToBarang(cursor);
            daftarBarang.add(barang);
            cursor.moveToNext();
        }
        cursor.close();
        return daftarBarang;
    }

    //ambil satu barang sesuai id
    public Barang getBarang(long id)
    {
        Barang barang = new Barang(); //inisialisasi barang
        //select query
        Cursor cursor = database.query(DbHelper.TABLE_NAME, allColumns, null, null, null, null, null, null);
        //ambil data yang pertama
        cursor.moveToFirst();
        //masukkan data cursor ke objek barang
        barang = cursorToBarang(cursor);
        cursor.close();
        return barang;
    }

    //update barang yang diedit
    public void updateBarang(Barang b)
    {
        //ambil id barang
        String strFilter = "_id=" + b.getId();
        //memasukkan ke content values
        ContentValues args = new ContentValues();
        //masukkan data sesuai dengan kolom pada database
        args.put(DbHelper.COLUMN_PEMESAN, b.getPemesan());
        args.put(DbHelper.COLUMN_NAME, b.getNama());
        args.put(DbHelper.COLUMN_JUMLAH, b.getJumlah());
        args.put(DbHelper.COLUMN_HARGA, b.getHarga() );
        //update query
        database.update(DbHelper.TABLE_NAME, args, strFilter, null);
    }
    // delete barang sesuai ID
    public void deleteBarang(long id)
    {
        String strFilter = "_id="+id;
        database.delete(DbHelper.TABLE_NAME, strFilter, null);
    }
}
