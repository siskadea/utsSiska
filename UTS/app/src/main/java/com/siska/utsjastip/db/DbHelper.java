package com.siska.utsjastip.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    //deklarasi konstanta-konstanta yang digunakan pada database, seperti nama tabel,
    //        nama-nama kolom, nama database, dan versi dari database
    public static final String TABLE_NAME = "data_jastip";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PEMESAN = "pemesan";
    public static final String COLUMN_NAME = "nama";
    public static final String COLUMN_JUMLAH = "jumlah";
    public static final String COLUMN_HARGA = "harga";
    private static final String db_name ="jastip.db";
    private static final int db_version=1;

    //membuat tabel database baru
    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_PEMESAN+ " varchar(50) not null, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_JUMLAH+ " varchar(50) not null, "
            + COLUMN_HARGA+ " varchar(50) not null);";

    public DbHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    //mengeksekusi perintah SQL di atas untuk membuat tabel database baru
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }

    //dijalankan apabila ingin mengupgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DbHelper.class.getName(),"Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
