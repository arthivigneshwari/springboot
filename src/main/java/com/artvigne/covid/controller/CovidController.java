package com.artvigne.covid.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.artvigne.covid.service.CovidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
@RequiredArgsConstructor
public class CovidController {

    private final CovidService covidService;

    @GetMapping("/get-all-country-covid-data")
    public ResponseEntity<?> callRapidEndpointoToGetCovidData(){
            return ResponseEntity.ok(covidService.getAllCountryCovidData());
    }

}
