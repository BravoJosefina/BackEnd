package com.example.clinicaOdontologica.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter

public class TurnoDTO {
    private Integer id;
    private Paciente paciente;
    private Odontologo odontologo;
    private Date date;

    public TurnoDTO(){
    }

    public TurnoDTO(Turno turno) {
        this.id = turno.getId();
        this.paciente = turno.getPaciente();
        this.odontologo = turno.getOdontologo();
        this.date = turno.getDate();
    }

    @Override
    public String toString() {
        return "Turno{" +
                "paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", date=" + date +
                '}';
    }
}
