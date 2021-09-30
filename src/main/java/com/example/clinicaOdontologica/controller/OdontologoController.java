package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.OdontologoDTO;
import com.example.clinicaOdontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private IOdontologoService iOdontologoService;

    @PostMapping()
    public ResponseEntity<?> registrarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        return ResponseEntity.ok(iOdontologoService.guardar(odontologoDTO));
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        OdontologoDTO odontologoBuscado = iOdontologoService.buscar(id);
        ResponseEntity.ok(odontologoBuscado);
        return odontologoBuscado;
    }

    @PutMapping()
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        iOdontologoService.actualizar(odontologoDTO);
        return ResponseEntity.ok("El odontólogo fue actualizado con éxito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        iOdontologoService.eliminar(id);
        return ResponseEntity.ok("El odontólogo ha sido eliminado");
    }

    @GetMapping
    public ResponseEntity<Collection<OdontologoDTO>> buscarTodos(){
        return ResponseEntity.ok(iOdontologoService.buscarTodos());
    }
}
