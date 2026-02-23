package com.example.backend_tableReservation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_tableReservation.model.RestoraniLaud;
import com.example.backend_tableReservation.service.LauaTeenus;

@RestController
@RequestMapping("/api/tables")
@CrossOrigin(origins = "http://localhost:5173")
public class LauaController {

    private final LauaTeenus lauaTeenus;

    public LauaController(LauaTeenus lauaTeenus) {
        this.lauaTeenus = lauaTeenus;
    }

    @GetMapping
    public List<RestoraniLaud> getAllTables() {
        return lauaTeenus.saaLauadSuvaliseBroneeringuga();
    }
}
