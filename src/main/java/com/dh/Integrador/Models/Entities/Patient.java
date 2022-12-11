package com.dh.Integrador.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @SequenceGenerator(name = "patient_sequence",sequenceName = "patient_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patient_sequence")
    private Long id;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private String email;
    @Column
    private int dni;
    @Column
    private LocalDate fechaIngreso;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_address",referencedColumnName = "id")
    //@JsonIgnore
    private Address address;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turn> turns = new HashSet<>();

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }


    public Patient() {
    }

    public Patient(Long id, String apellido, String name, String email, int dni, LocalDate fechaIngreso, Address address) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = name;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.address = address;
    }

    public Patient(String apellido, String name, String email, int dni, LocalDate fechaIngreso, Address address) {
        this.apellido = apellido;
        this.nombre = name;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.address = address;
    }


    public Long getId() {

        return id;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String name) {

        this.nombre = name;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public int getDni() {

        return dni;
    }

    public void setDni(int dni) {

        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {

        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {

        this.fechaIngreso = fechaIngreso;
    }

    public Address getAddress() {

        return address;
    }

    public void setAddress(Address address) {

        this.address = address;
    }
}
