package com.example.backend_tableReservation.service;

import com.example.backend_tableReservation.model.KasutajaEelistused;
import com.example.backend_tableReservation.model.RestoraniLaud;
import com.example.backend_tableReservation.repository.LauaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

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
            lauaRepository.save(new RestoraniLaud(2, 8, 660, 70, "veranda", true, false, false));
            lauaRepository.save(new RestoraniLaud(3, 8, 550, 190, "veranda", false, false, false));
            lauaRepository.save(new RestoraniLaud(4, 2, 660, 190, "veranda", true, false, false));

            // Peamine saal
            lauaRepository.save(new RestoraniLaud(5, 2, 64, 30, "saal", false, true, false));
            lauaRepository.save(new RestoraniLaud(6, 4, 228, 30, "saal", false, true, false));
            lauaRepository.save(new RestoraniLaud(7, 2, 397, 30, "saal", false, true, false));

            lauaRepository.save(new RestoraniLaud(8, 2, 64, 150, "saal", true, false, false));
            lauaRepository.save(new RestoraniLaud(9, 4, 228, 150, "saal", false, false, false));
            lauaRepository.save(new RestoraniLaud(10, 2, 397, 150, "saal", false, false, false));

            lauaRepository.save(new RestoraniLaud(11, 6, 64, 270, "saal", true, false, false));
            lauaRepository.save(new RestoraniLaud(12, 4, 228, 270, "saal", false, false, false));
            lauaRepository.save(new RestoraniLaud(13, 2, 397, 270, "saal", false, false, false));

            lauaRepository.save(new RestoraniLaud(14, 6, 64, 390, "saal", true, false, true));
            lauaRepository.save(new RestoraniLaud(15, 4, 228, 390, "saal", false, false, true));
            lauaRepository.save(new RestoraniLaud(16, 2, 397, 390, "saal", false, false, false));

            lauaRepository.save(new RestoraniLaud(17, 4, 228, 510, "saal", false, false, true));
            lauaRepository.save(new RestoraniLaud(18, 2, 397, 510, "saal", false, false, true));

            // Privaatne ruum
            lauaRepository.save(new RestoraniLaud(19, 10, 607, 440, "privaatne", false, false, false));
        }
    }

    public List<RestoraniLaud> saaLauadSuvaliseBroneeringuga() {
        List<RestoraniLaud> lauad = lauaRepository.findAll();
        Random random = new Random();
        for (RestoraniLaud laud : lauad) {
            laud.setOnBroneeritud(random.nextBoolean());
        }
        lauaRepository.saveAll(lauad);
        return lauad;
    }

    public RestoraniLaud arvutaParimLaud(KasutajaEelistused eelistused) {
        return lauaRepository.findAll().stream()
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
}
