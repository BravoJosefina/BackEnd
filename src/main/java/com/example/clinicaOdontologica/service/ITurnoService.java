package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.TurnoDTO;

import java.util.Collection;


public interface ITurnoService {
    public TurnoDTO guardar(TurnoDTO turno) throws BadRequestException;
    public TurnoDTO buscar(Integer id) throws ResourceNotFoundException;
    public void actualizar(TurnoDTO turno);
    public void eliminar(Integer id)throws ResourceNotFoundException;
    public Collection<TurnoDTO> buscarTodos();
}
