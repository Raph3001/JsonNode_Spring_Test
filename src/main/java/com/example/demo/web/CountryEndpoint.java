package com.example.demo.web;

import com.example.demo.beans.Country;
import com.example.demo.db.CustomerDB;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Project: Exa_01_Spring_Intro
 * Created by: SF
 * Date: 20.09.2023
 * Time: 08:17
 */
@RestController
@RequestMapping("/countries")
@Slf4j
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CountryEndpoint {

    private final CustomerDB countryDB;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Country>> getAllCountries() {
        return ResponseEntity.ok(countryDB.getAllCountries());

    }

    @GetMapping("/all/{countryCode}")
    public ResponseEntity<Iterable<Country>> getCountriesByCountryCode(@PathVariable String countryCode, @RequestParam(name = "pageNo", required = false) Integer pageNo, @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        return ResponseEntity.ok(countryDB.getAllCountries().stream().filter(c -> c.getCountry_code().equals(countryCode)).toList());

    }


}
