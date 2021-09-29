package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.Odontologo;
import com.example.clinicaOdontologica.models.OdontologoDTO;
import com.example.clinicaOdontologica.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService{
    @Autowired
    private OdontologoRepository repository;

    @Autowired
    ObjectMapper mapper;

    public OdontologoDTO guardar(OdontologoDTO odontologoDTO) throws BadRequestException {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        if (odontologo.getId() != null){
            throw new BadRequestException("El odontólogo que quieres crear ya existe");
        }
        else{
            Odontologo odontologoGuardado = repository.save(odontologo);
            OdontologoDTO odontologoDTOGuardado = mapper.convertValue(odontologoGuardado, OdontologoDTO.class);
            return odontologoDTOGuardado;
        }
    }

    public OdontologoDTO buscar(Integer id)throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO = null;
        Optional<Odontologo> odontologo = repository.findById(id);
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            return odontologoDTO;
        }else{
            throw new ResourceNotFoundException("El odontólogo que estas buscando no existe");
        }
    }

    public void actualizar(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
         repository.save(odontologo);
    }

    public void eliminar(Integer id) throws ResourceNotFoundException{
        buscar(id);
        repository.deleteById(id);
    }

    public Collection<OdontologoDTO> buscarTodos(){
        List<Odontologo> odontologos = repository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo : odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }
}
