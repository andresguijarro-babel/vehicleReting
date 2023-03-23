package com.babel.bootcampBack.vehicleRenting.services.impl;

import com.babel.bootcampBack.vehicleRenting.exceptions.RequestApiValidationException;
import com.babel.bootcampBack.vehicleRenting.exceptions.RequiredMissingFieldException;
import com.babel.bootcampBack.vehicleRenting.exceptions.WrongLenghtFieldException;
import com.babel.bootcampBack.vehicleRenting.models.Direccion;
import com.babel.bootcampBack.vehicleRenting.models.Persona;
import com.babel.bootcampBack.vehicleRenting.persistance.database.mappers.DireccionMapper;
import com.babel.bootcampBack.vehicleRenting.persistance.database.mappers.PersonaMapper;
import com.babel.bootcampBack.vehicleRenting.services.PersonaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonaServiceImplTest {

    PersonaService servicio;

    PersonaMapper personaMapper;

    DireccionMapper direccionMapper;

    @BeforeEach
    void setUpAll(){
        personaMapper = Mockito.mock(PersonaMapper.class);
        direccionMapper = Mockito.mock(DireccionMapper.class);
        servicio = new PersonaServiceImpl(personaMapper, direccionMapper);
    }

    @Test
    public void addPersona_should_throwRequiredMissingFieldException_when_nombreIsNull() throws ParseException, RequiredMissingFieldException, WrongLenghtFieldException {

        Assertions.assertThrows(RequiredMissingFieldException.class,() -> {
            Persona persona = createPersona();
            persona.setNombre(null);

            this.servicio.addPersona(persona);
        });


    }

    @Test
    public void addPersona_should_throwRequiredMissingFieldException_when_nombreIsEmpty() throws ParseException, RequiredMissingFieldException, WrongLenghtFieldException {

        Assertions.assertThrows(RequiredMissingFieldException.class,() -> {
            Persona persona = createPersona();
            persona.setNombre("");

            this.servicio.addPersona(persona);
        });


    }

    @Test
    public void addPersonaDireccion_should_bothAddressEquals_when_dirDomicilioSameAsNotificacion() throws ParseException, RequiredMissingFieldException, WrongLenghtFieldException {
        //Given
        Persona persona = createPersona();
        //When
        this.servicio.addPersona(persona);
        //Then
        Assertions.assertEquals(persona.getDireccionDomicilio(),persona.getDireccionNotificacion());
    }

    @Test
    public void addPersonaDireccion_should_bothAddressDifferent_when_dirDomicilioSameAsNotificacion() throws ParseException, RequiredMissingFieldException, WrongLenghtFieldException {
        //Given
        Persona persona = createPersona();
        persona.setDireccionDomicilioSameAsNotificacion(false);
        //When
        this.servicio.addPersona(persona);
        //Then
        Assertions.assertNotEquals(persona.getDireccionDomicilio(),persona.getDireccionNotificacion());
    }

    @Test
    public void addPersonaDireccion_should_callInsertDireccionDomicilio() throws RequiredMissingFieldException, WrongLenghtFieldException, ParseException {
        int idDireccion=20;
        //when(direccionMapper.insertDireccion(any())).thenReturn(true); //Mockito?
        //Given
        Persona persona = createPersona();
        persona.setDireccionDomicilioSameAsNotificacion(false);
        //When
        persona=this.servicio.addPersona(persona);
        Assertions.assertNotEquals(persona.getDireccionDomicilio(),persona.getDireccionNotificacion());
    }



    @Test
    public void getPerson_should_throwApiValidationException_when_idNegative() {

        Assertions.assertThrows(RequestApiValidationException.class, () -> {
            //Given
            int idPersona=-50;

            //When
            Persona persona=servicio.getPerson(idPersona);
        });
    }
    @Test
    public void getPerson_should_throwApiValidationException_when_idZero() {

        Assertions.assertThrows(RequestApiValidationException.class, () -> {
            //Given
            int idPersona=0;

            //When
            Persona persona=servicio.getPerson(idPersona);
        });
    }

    private static Persona createPersona() throws ParseException {
        Persona persona=new Persona();
        persona.setNombre("Juan");
        persona.setApellido1("Francés");
        persona.setApellido2("Atúñez");
        persona.setFechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("29-12-1980"));

        Direccion domicilio = new Direccion();
        domicilio.setTipoViaId(1);
        domicilio.setNombreCalle("Gran via");
        domicilio.setNumero("120");
        domicilio.setCodPostal("36201");
        domicilio.setMunicipio("Pontevedra");
        domicilio.setProvinciaCod("36");

        Direccion notificacion = new Direccion();
        domicilio.setTipoViaId(2);
        domicilio.setNombreCalle("Plaza nueva");
        domicilio.setNumero("44");
        domicilio.setCodPostal("41001");
        domicilio.setMunicipio("Sevilla");
        domicilio.setProvinciaCod("24");


        persona.setDireccionDomicilio(domicilio);
        persona.setDireccionDomicilioSameAsNotificacion(true);
        persona.setDireccionNotificacion(notificacion);

        return persona;

    }
}
