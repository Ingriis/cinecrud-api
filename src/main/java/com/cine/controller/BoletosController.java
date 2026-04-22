package com.cine.controller;

import com.cine.model.request.BoletosRequest;
import com.cine.model.response.BoletosResponse;
import com.cine.service.IBoletosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Boletos")
public class BoletosController {

    @Autowired
    private IBoletosService boletosService;

    @PostMapping("/AgregarBoletos")
    public ResponseEntity<BoletosResponse> agregarBoleto(@RequestBody BoletosRequest request) {
        BoletosResponse response = boletosService.guardarBoleto(request);
        return ResponseEntity.ok(response);
    }
}