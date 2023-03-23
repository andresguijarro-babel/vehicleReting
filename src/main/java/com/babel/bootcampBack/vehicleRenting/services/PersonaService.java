package com.babel.bootcampBack.vehicleRenting.services;

import com.babel.bootcampBack.vehicleRenting.exceptions.RequestApiValidationException;
import com.babel.bootcampBack.vehicleRenting.exceptions.RequiredMissingFieldException;
import com.babel.bootcampBack.vehicleRenting.exceptions.WrongLenghtFieldException;
import com.babel.bootcampBack.vehicleRenting.models.Persona;

public interface PersonaService {

    Persona addPersona(Persona persona) throws RequiredMissingFieldException, WrongLenghtFieldException;

    Persona getPerson(int idPersona) throws RequestApiValidationException;
}
