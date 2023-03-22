package com.babel.bootcampBack.vehicleRenting.controllers;

import com.babel.bootcampBack.vehicleRenting.models.Renta;
import com.babel.bootcampBack.vehicleRenting.services.PersonaService;
import com.babel.bootcampBack.vehicleRenting.services.RentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentaController {

    RentaService rentaService;

    public RentaController(RentaService rentaService) {
        this.rentaService = rentaService;
    }

    @PostMapping("/renta")
    ResponseEntity addRenta(@RequestBody Renta renta){
        this.rentaService.addRenta(renta);
        return ResponseEntity.ok(String.format("Renta añadida. Id: %d", renta.getRentaId()));
    }
}
