package com.example.clinicaOdontologica.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO implements Serializable {

    private Integer id;
    private String apellido;
    private String nombre;
    private Integer matricula;
    private Set<Turno> turnos;

    public OdontologoDTO() {
    }

    @Override
    public String toString() {
        return "OdontologoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                ", turnos=" + turnos +
                '}';
    }
}