package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.Paciente;
import com.example.clinicaOdontologica.models.PacienteDTO;
import com.example.clinicaOdontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PacienteService implements IPacienteService{
    @Autowired
    private PacienteRepository repository;

    @Autowired
    ObjectMapper mapper;

    public PacienteDTO guardar(PacienteDTO pacienteDTO) throws BadRequestException {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        if (paciente.getId() != null){
            throw new BadRequestException("El paciente que quieres crear ya existe");
        }
        else{
            Paciente pacienteGuardado = repository.save(paciente);
            PacienteDTO pacienteDTOGuardado = mapper.convertValue(pacienteGuardado, PacienteDTO.class);
            return pacienteDTOGuardado;
        }
    }

    public PacienteDTO buscar(Integer id)throws ResourceNotFoundException {
        PacienteDTO pacienteDTO = null;
        Optional<Paciente> paciente = repository.findById(id);
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            return pacienteDTO;
        }else{
            throw new ResourceNotFoundException("El paciente que estas buscando no existe");
        }
    }

    public void actualizar(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        repository.save(paciente);
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        buscar(id);
        repository.deleteById(id);
    }

    public Collection<PacienteDTO> buscarTodos(){
        List<Paciente> pacientes = repository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente : pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }
}
