package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.*;
import com.example.clinicaOdontologica.repository.DomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DomicilioService implements IDomicilioService{
    @Autowired
    private DomicilioRepository repository;

    @Autowired
    ObjectMapper mapper;

    public DomicilioDTO guardar(DomicilioDTO domicilioDTO) throws BadRequestException {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        if (domicilio.getId() != null){
            throw new BadRequestException("El domicilio que quieres crear ya existe");
        }
        else{
            Domicilio domicilioGuardado = repository.save(domicilio);
            DomicilioDTO domicilioDTOGuardado = mapper.convertValue(domicilioGuardado, DomicilioDTO.class);
            return domicilioDTOGuardado;
        }
    }

    public DomicilioDTO buscar(Integer id)throws ResourceNotFoundException {
        DomicilioDTO domicilioDTO = null;
        Optional<Domicilio> domicilio = repository.findById(id);
        if(domicilio.isPresent()){
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
            return domicilioDTO;
        }else{
            throw new ResourceNotFoundException("El domicilio que estas buscando no existe");
        }
    }

    public void actualizar(DomicilioDTO domicilioDTO)throws BadRequestException{
        if(domicilioDTO.getId() != null){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        repository.save(domicilio);
        }else{
            throw new BadRequestException("El domicilio que quieres actualizar no existe.");
        }
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        buscar(id);
        repository.deleteById(id);
    }

    public Collection<DomicilioDTO> buscarTodos(){
        List<Domicilio> domicilios = repository.findAll();
        Set<DomicilioDTO> domiciliosDTO = new HashSet<>();
        for (Domicilio domicilio : domicilios) {
            domiciliosDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domiciliosDTO;
    }
}