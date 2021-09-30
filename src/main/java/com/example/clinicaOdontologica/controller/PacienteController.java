package com.example.clinicaOdontologica.controller;


import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.OdontologoDTO;
import com.example.clinicaOdontologica.models.Paciente;
import com.example.clinicaOdontologica.models.PacienteDTO;
import com.example.clinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {
    @Autowired
    private IPacienteService iPacienteService;

    @PostMapping()
    public ResponseEntity<?> registrarPaciente(@RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        return ResponseEntity.ok(iPacienteService.guardar(pacienteDTO));
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        PacienteDTO pacienteBuscado = iPacienteService.buscar(id);
        ResponseEntity.ok(pacienteBuscado);
        return pacienteBuscado;
    }

    @PutMapping()
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        iPacienteService.actualizar(pacienteDTO);
        return ResponseEntity.ok("El paciente fue actualizado con éxito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        iPacienteService.eliminar(id);
        return ResponseEntity.ok("El paciente ha sido eliminado");
    }

    @GetMapping
    public ResponseEntity<Collection<PacienteDTO>> buscarTodos(){
        return ResponseEntity.ok(iPacienteService.buscarTodos());
    }
}
