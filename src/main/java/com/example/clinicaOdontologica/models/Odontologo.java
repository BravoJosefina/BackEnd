package com.example.clinicaOdontologica.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@Getter @Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Odontologo.class)
public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Integer id;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private Integer matricula;

    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnos;

    public Odontologo(){}

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
