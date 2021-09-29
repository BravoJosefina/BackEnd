package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.DomicilioDTO;

import java.util.Collection;



public interface IDomicilioService {
    public DomicilioDTO guardar(DomicilioDTO domicilio) throws BadRequestException;
    public DomicilioDTO buscar(Integer id) throws ResourceNotFoundException;
    public void actualizar(DomicilioDTO domicilio)throws BadRequestException;
    public void eliminar(Integer id)throws ResourceNotFoundException;
    public Collection<DomicilioDTO> buscarTodos();
}
