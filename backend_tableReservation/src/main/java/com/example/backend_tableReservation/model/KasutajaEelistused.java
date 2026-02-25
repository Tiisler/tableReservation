package com.example.backend_tableReservation.model;

public class KasutajaEelistused {
    private String asukoht;
    private boolean aknaAll;
    private boolean vaikneNurk;
    private boolean manguNurk;
    private int inimesteArv;
    private String kuupaev;
    private String kellaaeg;


    public boolean isAknaAll() {
        return aknaAll;
    }

    public void setAknaAll(boolean aknaAll) {
        this.aknaAll = aknaAll;
    }

    public int getInimesteArv() {
        return inimesteArv;
    }

    public void setInimesteArv(int inimesteArv) {
        this.inimesteArv = inimesteArv;
    }

    public boolean isVaikneNurk() {
        return vaikneNurk;
    }

    public void setVaikneNurk(boolean vaikneNurk) {
        this.vaikneNurk = vaikneNurk;
    }

    public boolean isManguNurk() {
        return manguNurk;
    }

    public void setManguNurk(boolean manguNurk) {
        this.manguNurk = manguNurk;
    }

    public String getKuupaev() {
        return kuupaev;
    }

    public void setKuupaev(String kuupaev) {
        this.kuupaev = kuupaev;
    }

    public String getKellaaeg() {
        return kellaaeg;
    }

    public void setKellaaeg(String kellaaeg) {
        this.kellaaeg = kellaaeg;
    }

    public String getAsukoht() {
        return asukoht;
    }

    public void setAsukoht(String asukoht) {
        this.asukoht = asukoht;
    }
}
