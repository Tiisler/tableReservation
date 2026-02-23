package com.example.backend_tableReservation.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_tableReservation.model.RestoraniLaud;

@RestController
@RequestMapping("/api/tables")
@CrossOrigin(origins = "http://localhost:5173") 
public class LauaController {

    @GetMapping
    public List<RestoraniLaud> getTables() {
        return Arrays.asList(
            new RestoraniLaud(1L, 1, 2, false),
            new RestoraniLaud(2L, 2, 4, true),
            new RestoraniLaud(3L, 3, 6, false)
        );
    }
}
