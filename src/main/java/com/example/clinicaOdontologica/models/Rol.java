package com.example.clinicaOdontologica.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
}
