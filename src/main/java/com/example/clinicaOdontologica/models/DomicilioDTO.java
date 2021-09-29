package com.example.clinicaOdontologica.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDTO implements Serializable {

    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    public DomicilioDTO() {
    }

    @Override
    public String toString() {
        return "DomicilioDTO {" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}