package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.PacienteDTO;
import com.example.clinicaOdontologica.models.TurnoDTO;
import com.example.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService iTurnoService;

    @PostMapping()
    public ResponseEntity<?> registrarTurno(@RequestBody TurnoDTO turnoDTO) throws BadRequestException {
        return ResponseEntity.ok(iTurnoService.guardar(turnoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        TurnoDTO turnoBuscado = iTurnoService.buscar(id);
        return ResponseEntity.ok(turnoBuscado);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarTurno(@RequestBody TurnoDTO turnoDTO){
        iTurnoService.actualizar(turnoDTO);
        return ResponseEntity.ok("El turno fue actualizado con éxito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        iTurnoService.eliminar(id);
        return ResponseEntity.ok("El turno ha sido eliminado");
    }

    @GetMapping()
    public ResponseEntity<Collection<TurnoDTO>> buscarTodos(){
        return ResponseEntity.ok(iTurnoService.buscarTodos());
    }
}

