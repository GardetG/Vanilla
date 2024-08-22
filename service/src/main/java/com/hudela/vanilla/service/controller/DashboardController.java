package com.hudela.vanilla.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for Api status
 */
@RestController
@RequestMapping("/api/status")
public class DashboardController {

    @GetMapping()
    public ResponseEntity<String> message() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
