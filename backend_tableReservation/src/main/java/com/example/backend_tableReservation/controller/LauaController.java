package com.example.backend_tableReservation.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_tableReservation.model.KasutajaEelistused;
import com.example.backend_tableReservation.model.RestoraniLaud;
import com.example.backend_tableReservation.model.BroneeringuAndmed;
import com.example.backend_tableReservation.service.LauaTeenus;

@RestController
@RequestMapping("/api/lauad")
@CrossOrigin(origins = { "http://localhost:5173", "http://localhost:5174" })
public class LauaController {

    private final LauaTeenus lauaTeenus;

    public LauaController(LauaTeenus lauaTeenus) {
        this.lauaTeenus = lauaTeenus;
    }

    @GetMapping
    public List<RestoraniLaud> saaLauad(@RequestParam String kuupaev, @RequestParam String kellaaeg) {
        return lauaTeenus.saaLauadAjaPohjal(kuupaev, kellaaeg);
    }

    @PostMapping("/soovitus")
    public ResponseEntity<RestoraniLaud> saaSoovitus(@RequestBody KasutajaEelistused eelistused) {
        List<RestoraniLaud> lauad = lauaTeenus.saaLauadAjaPohjal(eelistused.getKuupaev(), eelistused.getKellaaeg());
        RestoraniLaud laud = lauaTeenus.arvutaParimLaud(lauad, eelistused);
        return ResponseEntity.ok(laud);
    }

    @PostMapping("/broneeri")
    public ResponseEntity<RestoraniLaud> broneeriLaud(@RequestBody BroneeringuAndmed broneeringuAndmed) {
        RestoraniLaud broneeritudLaud = lauaTeenus.broneeriLaud(broneeringuAndmed);
        return ResponseEntity.ok(broneeritudLaud);
    }

}
