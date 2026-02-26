package com.example.backend_tableReservation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_tableReservation.model.KasutajaEelistused;
import com.example.backend_tableReservation.model.RestoraniLaud;
import com.example.backend_tableReservation.service.LauaTeenus;

@RestController
@RequestMapping("/api/lauad")
@CrossOrigin(origins = "http://localhost:5173")
public class LauaController {

    private final LauaTeenus lauaTeenus;

    public LauaController(LauaTeenus lauaTeenus) {
        this.lauaTeenus = lauaTeenus;
    }

    @GetMapping
    public List<RestoraniLaud> saaLauad() {
        return lauaTeenus.saaLauad();
    }

    @GetMapping("/genereeri-algseis")
    public List<RestoraniLaud> genereeriAlgseis() {
        return lauaTeenus.saaLauadSuvaliseBroneeringuga();
    }

    @PostMapping("/soovitus")
    public RestoraniLaud saaSoovitus(@RequestBody KasutajaEelistused eelistused) {
        if (eelistused.isUuendaBroneeringuid()) {
            lauaTeenus.saaLauadSuvaliseBroneeringuga();
        }
        return lauaTeenus.arvutaParimLaud(eelistused);
    }

}
