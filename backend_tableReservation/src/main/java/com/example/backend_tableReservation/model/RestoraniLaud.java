
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
    private boolean aknaJuures;

    public RestoraniLaud() {}

    public RestoraniLaud(int lauaNumber, int kohtadeArv, int x, int y, boolean aknaJuures) {
        this.lauaNumber = lauaNumber;
        this.kohtadeArv = kohtadeArv;
        this.x = x;
        this.y = y;
        this.onBroneeritud = false;
        this.aknaJuures = aknaJuures;
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

    public boolean getAknaJuures() {
        return aknaJuures;
    }

    public void setAknaJuures(boolean aknaJuures) {
        this.aknaJuures = aknaJuures;
    }

}