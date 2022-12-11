package com.dh.Integrador.Models.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PatientDTO {
    private Long id;
    private String apellido;
    private String nombre;
    private String dni;
    private String domicilio;
}
