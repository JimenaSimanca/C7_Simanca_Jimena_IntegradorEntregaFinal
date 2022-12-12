package com.dh.Integrador.Models.Dtos;

import javax.validation.constraints.NotNull;

public class DentistDTO {

    public Integer id;
    @NotNull
    public String nombre;
    @NotNull
    public String apellido;
    public Integer matricula;

    public DentistDTO(){

    }
    public DentistDTO(String nombre, String apellido, Integer matricula){
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
