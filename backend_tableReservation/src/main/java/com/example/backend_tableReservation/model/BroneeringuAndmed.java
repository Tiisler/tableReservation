// Andmete mudel, mis esindab broneeringu kinnitamiseks kasutatavaid andmeid.

package com.example.backend_tableReservation.model;

public class BroneeringuAndmed {
    private Long lauaId;
    private String nimi;
    private String email;
    private String telefoninumber;
    private String kuupaev;
    private String kellaaeg;

    public BroneeringuAndmed() {}

    public BroneeringuAndmed(Long lauaId, String nimi, String email, String telefoninumber, String kuupaev, String kellaaeg) {
        this.lauaId = lauaId;
        this.nimi = nimi;
        this.email = email;
        this.telefoninumber = telefoninumber;
        this.kuupaev = kuupaev;
        this.kellaaeg = kellaaeg;
    }

    public Long getLauaId() {
        return lauaId;
    }

    public void setLauaId(Long lauaId) {
        this.lauaId = lauaId;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoninumber() {
        return telefoninumber;
    }

    public void setTelefoninumber(String telefoninumber) {
        this.telefoninumber = telefoninumber;
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
}
