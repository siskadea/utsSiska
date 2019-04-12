package com.siska.utsjastip.models;

public class Barang {
    private long id;
    private String pemesan, nama, jumlah, harga;

    public Barang(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPemesan() {
        return pemesan;
    }

    public void setPemesan(String pemesan) {
        this.pemesan = pemesan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
    @Override
    public String toString()
    {
        return "Pesanan Jastip "+ pemesan+" "+nama +" "+ jumlah + " "+ harga;
    }
}
