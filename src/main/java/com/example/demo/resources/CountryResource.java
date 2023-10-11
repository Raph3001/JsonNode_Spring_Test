package com.example.demo.resources;

import com.example.demo.db.CustomerDB;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.annotation.Repeatable;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Project: Exa_01_Spring_Intro
 * Created by: SF
 * Date: 20.09.2023
 * Time: 08:17
 */
@RestController
@RequestMapping("/exam")
@Slf4j
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CountryResource {

    private final CustomerDB customerDB;




}
