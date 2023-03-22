package com.babel.bootcampBack.vehicleRenting.services;

import com.babel.bootcampBack.vehicleRenting.exceptions.PersonaNotFoundException;
import com.babel.bootcampBack.vehicleRenting.exceptions.ProfesionNotFoundException;
import com.babel.bootcampBack.vehicleRenting.models.Renta;

public interface RentaService {
    Renta addRenta(Renta renta) throws ProfesionNotFoundException, PersonaNotFoundException;
}
