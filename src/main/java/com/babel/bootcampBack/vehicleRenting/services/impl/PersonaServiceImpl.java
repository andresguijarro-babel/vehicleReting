package com.babel.bootcampBack.vehicleRenting.services.impl;


import com.babel.bootcampBack.vehicleRenting.exceptions.RequiredMissingFieldException;
import com.babel.bootcampBack.vehicleRenting.exceptions.WrongLenghtFieldException;
import com.babel.bootcampBack.vehicleRenting.models.Persona;
import com.babel.bootcampBack.vehicleRenting.persistance.database.mappers.DireccionMapper;
import com.babel.bootcampBack.vehicleRenting.persistance.database.mappers.PersonaMapper;
import com.babel.bootcampBack.vehicleRenting.services.PersonaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private DireccionMapper direccionMapper;
    private PersonaMapper personaMapper;

    PersonaServiceImpl(PersonaMapper personaMapper, DireccionMapper direccionMapper){
        this.personaMapper=personaMapper;
        this.direccionMapper = direccionMapper;
    }

    @Override
    @Transactional
    public Persona addPersona(Persona persona) throws RequiredMissingFieldException, WrongLenghtFieldException {

        this.validatePersonData(persona);

        persona=this.addPersonaDireccion(persona);
        this.personaMapper.insertPersona(persona);

        return persona;
    }

    private Persona addPersonaDireccion(Persona persona){
        this.direccionMapper.insertDireccion(persona.getDireccionDomicilio());

        if (persona.isDireccionDomicilioSameAsNotificacion()){
            persona.setDireccionNotificacion(persona.getDireccionDomicilio());
        }else{
            this.direccionMapper.insertDireccion(persona.getDireccionNotificacion());
        }


        return persona;
    }

    private void validatePersonData(Persona persona) throws RequiredMissingFieldException, WrongLenghtFieldException {
        this.validateNombre(persona);
    }

    private void validateNombre(Persona persona) throws RequiredMissingFieldException, WrongLenghtFieldException {
        if ((persona.getNombre() == null) || persona.getNombre().isEmpty()) {
            throw new RequiredMissingFieldException();
        }
        if (persona.getNombre().length() > 50){
            throw new WrongLenghtFieldException();
        }
    }
}
