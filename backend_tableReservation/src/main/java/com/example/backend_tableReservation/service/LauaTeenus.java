package com.example.backend_tableReservation.service;

import com.example.backend_tableReservation.model.KasutajaEelistused;
import com.example.backend_tableReservation.model.RestoraniLaud;
import com.example.backend_tableReservation.model.BroneeringuAndmed;
import com.example.backend_tableReservation.repository.LauaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

@Service
public class LauaTeenus {

    private final LauaRepository lauaRepository;

    public LauaTeenus(LauaRepository lauaRepository) {
        this.lauaRepository = lauaRepository;
    }

    public List<RestoraniLaud> saaLauad() {
        return lauaRepository.findAll();
    }

    @PostConstruct
    public void lisaAlgandmed() {
        if (lauaRepository.count() == 0) {

            // Veranda
            lauaRepository.save(new RestoraniLaud(1, 8, 550, 70, "veranda", true, false, false));
            lauaRepository.save(new RestoraniLaud(2, 6, 660, 70, "veranda", true, false, false));
                                                         // Selle laua aknajuures = false, kuna see pole veranda ääres, vaid keskel.
            lauaRepository.save(new RestoraniLaud(3, 4, 550, 190, "veranda", false, false, false));
            lauaRepository.save(new RestoraniLaud(4, 2, 660, 190, "veranda", true, false, false));

            // Peamine saal
            lauaRepository.save(new RestoraniLaud(5, 2, 64, 30, "saal", false, true, false));
            lauaRepository.save(new RestoraniLaud(6, 4, 228, 30, "saal", false, true, false));
            lauaRepository.save(new RestoraniLaud(7, 6, 397, 30, "saal", false, true, false));

            lauaRepository.save(new RestoraniLaud(8, 8, 64, 150, "saal", true, false, false));
            lauaRepository.save(new RestoraniLaud(9, 4, 228, 150, "saal", false, false, false));
            lauaRepository.save(new RestoraniLaud(10, 2, 397, 150, "saal", false, false, false));

            lauaRepository.save(new RestoraniLaud(11, 6, 64, 270, "saal", true, false, false));
            lauaRepository.save(new RestoraniLaud(12, 4, 228, 270, "saal", false, false, false));
            lauaRepository.save(new RestoraniLaud(13, 2, 397, 270, "saal", false, false, false));

            lauaRepository.save(new RestoraniLaud(14, 4, 64, 390, "saal", true, false, true));
            lauaRepository.save(new RestoraniLaud(15, 6, 228, 390, "saal", false, false, true));
            lauaRepository.save(new RestoraniLaud(16, 2, 397, 390, "saal", false, false, false));

            lauaRepository.save(new RestoraniLaud(17, 4, 228, 510, "saal", false, false, true));
            lauaRepository.save(new RestoraniLaud(18, 6, 397, 510, "saal", false, false, true));

            // Privaatne ruum
            lauaRepository.save(new RestoraniLaud(19, 20, 607, 440, "privaatne", false, false, false));
        }
    }

    // Peaaegu kõik selle meetodi loogikast on genereeritud AI poolt. Põhjalikumalt
    // täpsustasin dokumentatsioonis.
    public List<RestoraniLaud> saaLauadAjaPohjal(String kuupaev, String kellaaeg) {
        List<RestoraniLaud> lauad = lauaRepository.findAll();
        String hour = kellaaeg.split(":")[0];
        int minute = Integer.parseInt(kellaaeg.split(":")[1]);
        String interval = hour + (minute < 30 ? ":00" : ":30");
        long seed = (kuupaev + interval).hashCode();
        Random juhuslikkus = new Random(seed);
        long kolmTundi = 3 * 60 * 60 * 1000;

        try {
            String dateTimeString = kuupaev + "T" + kellaaeg;
            LocalDateTime valitudAeg = LocalDateTime.parse(dateTimeString);
            long valitudTimestamp = valitudAeg.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

            for (RestoraniLaud laud : lauad) {
                if (laud.isOnBroneeritud() && laud.getBroneeringuAeg() > 0) {
                    long erinevus = valitudTimestamp - laud.getBroneeringuAeg();
                    if (erinevus > kolmTundi || erinevus < 0) {
                        laud.setOnBroneeritud(false);
                        laud.setBroneeringuAeg(0);
                        lauaRepository.save(laud);
                    }
                }
                if (!laud.isOnBroneeritud()) {
                    laud.setOnBroneeritud(juhuslikkus.nextFloat() < 0.4);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lauad;
    }

    public RestoraniLaud arvutaParimLaud(List<RestoraniLaud> lauad, KasutajaEelistused eelistused) {
        return lauad.stream()
                .filter(l -> !l.isOnBroneeritud())
                .filter(l -> l.getKohtadeArv() >= eelistused.getInimesteArv())
                .filter(l -> l.getAsukoht().equalsIgnoreCase(eelistused.getAsukoht()))
                .sorted((l1, l2) -> {
                    int skoor1 = arvutaSkoor(l1, eelistused);
                    int skoor2 = arvutaSkoor(l2, eelistused);
                    if (skoor1 != skoor2) {
                        return Integer.compare(skoor2, skoor1);
                    }
                    return Integer.compare(l1.getKohtadeArv(), l2.getKohtadeArv());
                })
                .findFirst()
                .orElse(null);
    }

    private int arvutaSkoor(RestoraniLaud laud, KasutajaEelistused eelistused) {
        int skoor = 0;
        if (laud.getAsukoht().equals("privaatne")) {
            return 0;
        }
        if (eelistused.isAknaAll() && laud.isAknaJuures()) {
            skoor += 10;
        }
        if (eelistused.isVaikneNurk() && laud.isVaiksesNurgas()) {
            skoor += 10;
        }
        if (eelistused.isManguNurk() && laud.isManguNurgas()) {
            skoor += 10;
        }
        return skoor;
    }

    // Kuna AI aitas lahendada broneeringu ajaga seostuvaid probleeme, siis ka selles meetodiks on kasutatud mõne rea kirjutamiseks AI abi.
    public RestoraniLaud broneeriLaud(BroneeringuAndmed broneeringuAndmed) {
        return lauaRepository.findById(broneeringuAndmed.getLauaId()).map(laud -> {

            // Need kolm rida aitas genereerida AI.
            String dateTimeString = broneeringuAndmed.getKuupaev() + "T" + broneeringuAndmed.getKellaaeg();
            LocalDateTime broneeringuAeg = LocalDateTime.parse(dateTimeString);
            long timestamp = broneeringuAeg.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

            laud.setOnBroneeritud(true);
            laud.setBroneeringuAeg(timestamp);
            return lauaRepository.save(laud);
        }).orElse(null);
    }
}
