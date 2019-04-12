package com.siska.utsjastip.models;

public class Koleksi {
    private String id;
    private String brand;
    private String ket;
    private String img;
    private int img_local;

    public Koleksi(String id, String brand, String ket, String img) {
        this.id = id;
        this.brand= brand;
        this.ket = ket;
        this.img = img;
    }
    public Koleksi(String id, String brand, String ket, int img_local) {
        this.id = id;
        this.brand = brand;
        this.ket = ket;
        this.img_local = img_local;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getImg_local() {
        return img_local;
    }

    public void setImg_local(int img_local) {
        this.img_local = img_local;
    }
}
