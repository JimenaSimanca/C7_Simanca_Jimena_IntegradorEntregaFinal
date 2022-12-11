package com.dh.Integrador.Models.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turns")
public class Turn {
    @Id
    @SequenceGenerator(name = "turn_sequence",sequenceName = "turn_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "turn_sequence")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "dentist_id",nullable = false)
    private Dentist dentist;
    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;
    @Column
    private LocalDate date;


    public Turn() {
    }
    public Turn(Long id, Dentist dentist, Patient patient, LocalDate date) {
        this.id = id;
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    public Turn(Dentist dentist, Patient patient, LocalDate date) {
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }
    public Turn(Long idDentist, Long idPatient, LocalDate date) {
        this.dentist = dentist;
        this.dentist = dentist;
        this.date = date;
    }

    public Long getId() {

        return id;
    }

    public Dentist getDentist() {

        return dentist;
    }

    public void setDentist(Dentist dentist) {

        this.dentist = dentist;
    }

    public Patient getPatient() {

        return patient;
    }

    public void setPatient(Patient patient) {

        this.patient = patient;
    }

    public LocalDate getDate() {

        return date;
    }

    public void setDate(LocalDate date) {

        this.date = date;
    }
}
