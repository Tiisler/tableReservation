package com.example.backend_tableReservation.service;

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

    @PostConstruct
    public void lisaAlgandmed() {
        if (lauaRepository.count() == 0) {
            lauaRepository.save(new RestoraniLaud(1, 2, 50, 50));
            lauaRepository.save(new RestoraniLaud(2, 4, 200, 50));
            lauaRepository.save(new RestoraniLaud(3, 2, 350, 50));
            lauaRepository.save(new RestoraniLaud(4, 8, 500, 50));
            lauaRepository.save(new RestoraniLaud(5, 8, 650, 50));
            lauaRepository.save(new RestoraniLaud(6, 2, 50, 150));
            lauaRepository.save(new RestoraniLaud(7, 4, 200, 150));
            lauaRepository.save(new RestoraniLaud(8, 2, 350, 150));
            lauaRepository.save(new RestoraniLaud(9, 8, 500, 150));
            lauaRepository.save(new RestoraniLaud(10, 2, 650, 150));
        }
    }

    public List<RestoraniLaud> saaLauadSuvaliseBroneeringuga() {
        List<RestoraniLaud> lauad = lauaRepository.findAll();
        Random random = new Random();
        for (RestoraniLaud laud : lauad) {
            laud.setOnBroneeritud(random.nextBoolean());
        }
        return lauad;
    }
}
