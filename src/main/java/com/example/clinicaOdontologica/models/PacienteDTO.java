package com.example.clinicaOdontologica.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private Domicilio domicilio;
    private Integer dni;
    private Date fechaDeAlta;
    private Set<Turno> turnos;

    public PacienteDTO(){

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
