package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.OdontologoDTO;

import java.util.Collection;



public interface IOdontologoService {
    public OdontologoDTO guardar(OdontologoDTO odontologo) throws BadRequestException;
    public OdontologoDTO buscar(Integer id) throws ResourceNotFoundException;
    public void actualizar(OdontologoDTO odontologo);
    public void eliminar(Integer id) throws ResourceNotFoundException;
    public Collection<OdontologoDTO> buscarTodos();
}
