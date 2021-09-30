package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.models.DomicilioDTO;
import com.example.clinicaOdontologica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    @Autowired
    IDomicilioService iDomicilioService;

    @PostMapping()
    public ResponseEntity<?> registrarDomicilio(@RequestBody DomicilioDTO domicilioDTO) throws BadRequestException {
        return ResponseEntity.ok(iDomicilioService.guardar(domicilioDTO));
    }

    @GetMapping("/{id}")
    public DomicilioDTO buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
            DomicilioDTO domicilioBuscado = iDomicilioService.buscar(id);
            ResponseEntity.ok(domicilioBuscado);
            return domicilioBuscado;
    }

    @PutMapping()
    public ResponseEntity<?> actualizarDomicilio(@RequestBody DomicilioDTO domicilioDTO) throws BadRequestException {
        iDomicilioService.actualizar(domicilioDTO);
           return ResponseEntity.ok("El domicilio fue actualizado con éxito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
       iDomicilioService.eliminar(id);
       return ResponseEntity.ok("El domicilio ha sido eliminado");
    }

    @GetMapping
    public ResponseEntity<Collection<DomicilioDTO>> buscarTodos(){
        return ResponseEntity.ok(iDomicilioService.buscarTodos());
    }
}
