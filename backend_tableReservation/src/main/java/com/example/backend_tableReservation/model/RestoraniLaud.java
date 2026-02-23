
package com.example.backend_tableReservation.model;

public class RestoraniLaud {
    private Long id;
    private int lauaNumber;
    private int suurus;
    private boolean onBroneeritud;

    public RestoraniLaud(Long id, int lauaNumber, int suurus, boolean onBroneeritud) {
        this.id = id;
        this.lauaNumber = lauaNumber;
        this.suurus = suurus;
        this.onBroneeritud = onBroneeritud;
    }

    public Long getId() {
        return id;
    }

    public int getLauaNumber() {
        return lauaNumber;
    }

    public int getSuurus() {
        return suurus;
    }

    public boolean isOnBroneeritud() {
        return onBroneeritud;
    }

}