package com.dh.Integrador.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="dentists")
public class Dentist {
    @Id
    @SequenceGenerator(name = "dentist_sequence",sequenceName = "dentist_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dentist_sequence")
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Turn> turns = new HashSet<>();

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }


    public Dentist() {
    }

    public Dentist(String name, String apellido, String matricula) {
        this.nombre = name;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Dentist(Long id, String name, String apellido, String matricula) {
        this.id = id;
        this.nombre = name;
        this.apellido = apellido;
        this.matricula = matricula;
    }


    public Long getId() {

        return id;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String name
    ) {

        this.nombre = name;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    public String getMatricula() {

        return matricula;
    }

    public void setMatricula(String  matricula) {

        this.matricula = matricula;
    }
}
