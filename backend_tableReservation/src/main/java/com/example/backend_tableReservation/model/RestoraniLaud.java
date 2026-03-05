
package com.example.backend_tableReservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RestoraniLaud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    private int lauaNumber;
    private int kohtadeArv;
    private int x;
    private int y;
    private boolean onBroneeritud;
    private long broneeringuAeg;
    private String asukoht;
    private boolean aknaJuures;
    private boolean vaiksesNurgas;
    private boolean manguNurgas;

    public RestoraniLaud() {}

    public RestoraniLaud(int lauaNumber, int kohtadeArv, int x, int y, String asukoht, boolean aknaJuures, boolean vaiksesNurgas, boolean manguNurgas) {
        this.onBroneeritud = false;
        this.broneeringuAeg = 0;
        this.lauaNumber = lauaNumber;
        this.kohtadeArv = kohtadeArv;
        this.x = x;
        this.y = y;
        this.asukoht = asukoht;
        this.aknaJuures = aknaJuures;
        this.vaiksesNurgas = vaiksesNurgas;
        this.manguNurgas = manguNurgas;
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLauaNumber() {
        return lauaNumber;
    }

    public void setLauaNumber(int lauaNumber) {
        this.lauaNumber = lauaNumber;
    }

    public int getKohtadeArv() {
        return kohtadeArv;
    }

    public void setKohtadeArv(int kohtadeArv) {
        this.kohtadeArv = kohtadeArv;
    }

    public boolean isOnBroneeritud() {
        return onBroneeritud;
    }

    public void setOnBroneeritud(boolean onBroneeritud) {
        this.onBroneeritud = onBroneeritud;
    }

    public long getBroneeringuAeg() {
        return broneeringuAeg;
    }

    public void setBroneeringuAeg(long broneeringuAeg) {
        this.broneeringuAeg = broneeringuAeg;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAknaJuures() {
        return aknaJuures;
    }

    public void setAknaJuures(boolean aknaJuures) {
        this.aknaJuures = aknaJuures;
    }

    public boolean isVaiksesNurgas() {
        return vaiksesNurgas;
    }

    public void setVaiksesNurgas(boolean vaiksesNurgas) {
        this.vaiksesNurgas = vaiksesNurgas;
    }

    public boolean isManguNurgas() {
        return manguNurgas;
    }

    public void setManguNurgas(boolean manguNurgas) {
        this.manguNurgas = manguNurgas;
    }

    public String getAsukoht() {
        return asukoht;
    }

    public void setAsukoht(String asukoht) {
        this.asukoht = asukoht;
    }

    

}