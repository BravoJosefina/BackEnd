package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.PacienteDTO;

import java.util.Collection;


public interface IPacienteService {
    public PacienteDTO guardar(PacienteDTO paciente) throws BadRequestException;
    public PacienteDTO buscar(Integer id) throws ResourceNotFoundException;
    public void actualizar(PacienteDTO paciente);
    public void eliminar(Integer id)throws ResourceNotFoundException;;
    public Collection<PacienteDTO> buscarTodos();
}
