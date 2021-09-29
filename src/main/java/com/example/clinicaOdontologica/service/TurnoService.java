package com.example.clinicaOdontologica.service;


import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.Turno;
import com.example.clinicaOdontologica.models.TurnoDTO;
import com.example.clinicaOdontologica.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private TurnoRepository repository;

    @Autowired
    ObjectMapper mapper;

    public TurnoDTO guardar(TurnoDTO turnoDTO) throws BadRequestException {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        if (turno.getId() != null){
            throw new BadRequestException("El turno que quieres crear ya existe");
        }
        else{
            Turno turnoGuardado = repository.save(turno);
            TurnoDTO turnoDTOGuardado = mapper.convertValue(turnoGuardado, TurnoDTO.class);
            return turnoDTOGuardado;
        }
    }

    public TurnoDTO buscar(Integer id)throws ResourceNotFoundException {
        Optional<Turno> turno = repository.findById(id);
        if(turno.isPresent()){
            return mapper.convertValue(turno, TurnoDTO.class);
        }else{
            throw new ResourceNotFoundException("El turno que estas buscando no existe");
        }
    }

    public void actualizar(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        repository.save(turno);
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        buscar(id);
        repository.deleteById(id);
    }

    public Collection<TurnoDTO> buscarTodos(){
        List<Turno> turnos = repository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for (Turno turno : turnos) {
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }
}


