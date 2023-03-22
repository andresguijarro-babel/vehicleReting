package com.babel.bootcampBack.vehicleRenting.models;

import java.util.Date;

public class Renta {
    private int rentaId;
    private int personaId;
    private int profesionId;
    private int anio;
    private int importe;
    private int isCuentaPropia;
    private String iae;
    private String cifEmpleador;
    private Date fechaInicioEmpleo;


    public int getRentaId() {
        return rentaId;
    }

    public void setRentaId(int rentaId) {
        this.rentaId = rentaId;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public int getProfesionId() {
        return profesionId;
    }

    public void setProfesionId(int profesionId) {
        this.profesionId = profesionId;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public int getIsCuentaPropia() {
        return isCuentaPropia;
    }

    public void setIsCuentaPropia(int isCuentaPropia) {
        this.isCuentaPropia = isCuentaPropia;
    }

    public String getIae() {
        return iae;
    }

    public void setIae(String iae) {
        this.iae = iae;
    }

    public String getCifEmpleador() {
        return cifEmpleador;
    }

    public void setCifEmpleador(String cifEmpleador) {
        this.cifEmpleador = cifEmpleador;
    }

    public Date getFechaInicioEmpleo() {
        return fechaInicioEmpleo;
    }

    public void setFechaInicioEmpleo(Date fechaInicioEmpleo) {
        this.fechaInicioEmpleo = fechaInicioEmpleo;
    }
}
