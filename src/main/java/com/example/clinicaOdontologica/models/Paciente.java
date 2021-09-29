package com.example.clinicaOdontologica.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@Getter @Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Paciente.class)
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    @Column
    private Integer dni;
    @Column
    private Date fechaDeAlta;

    @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnos;

    public Paciente (){

    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio=" + domicilio +
                ", dni=" + dni +
                ", fechaDeAlta=" + fechaDeAlta +
                '}';
    }
}
