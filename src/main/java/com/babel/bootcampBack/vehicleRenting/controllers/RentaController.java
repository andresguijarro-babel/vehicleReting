package com.babel.bootcampBack.vehicleRenting.controllers;

import com.babel.bootcampBack.vehicleRenting.exceptions.PersonaNotFoundException;
import com.babel.bootcampBack.vehicleRenting.exceptions.ProfesionNotFoundException;
import com.babel.bootcampBack.vehicleRenting.models.Renta;
import com.babel.bootcampBack.vehicleRenting.services.PersonaService;
import com.babel.bootcampBack.vehicleRenting.services.RentaService;
import org.springframework.http.HttpStatus;
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
        try {
            this.rentaService.addRenta(renta);
        } catch (ProfesionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Profesion no encontrada en la base de datos");
        } catch (PersonaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Persona no encontrada en la base de datos");
        }
        return ResponseEntity.ok(String.format("Renta añadida. Id: %d", renta.getRentaId()));
    }
}
