package com.aswpe.awspe.controller;
import com.aswpe.awspe.dto.request.PreProfesorRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import com.aswpe.awspe.dto.ProfesorDTO;
import com.aswpe.awspe.services.ProfesorServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@CrossOrigin(origins = {"*"})
public class ProfesorController {
    private final ProfesorServices profesorServices;

    public ProfesorController(ProfesorServices profesorServices) {
        this.profesorServices = profesorServices;
    }
    @GetMapping("")
    @Operation(summary = "Listar a todos los profesores")
    public ResponseEntity<List<ProfesorDTO>> getAllProfesores() {
        List<ProfesorDTO> profesores = this.profesorServices.getProfesores();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Listar a un profesor según su ID")
    public ResponseEntity<ProfesorDTO> getProfesorById(@PathVariable int id){
        ProfesorDTO newProfesor = this.profesorServices.getProfesorById(id);
        if(newProfesor == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newProfesor,HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo profesor")
    public ResponseEntity<ProfesorDTO> createProfesor(@Valid @RequestBody PreProfesorRequest info){
        ProfesorDTO newProfesor = this.profesorServices.createProfesor(info);
        return new ResponseEntity<>(newProfesor,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar profesor existente")
    public ResponseEntity<ProfesorDTO> editProfesorByid(@Valid @RequestBody PreProfesorRequest info, @PathVariable int id){
        ProfesorDTO newProfesor = this.profesorServices.actualizar(id,info);
        return new ResponseEntity<>(newProfesor,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un profesor según su ID")
    public ResponseEntity<ProfesorDTO> delete(@PathVariable int id){
        ProfesorDTO newProfesor = this.profesorServices.deleteProfesor(id);

        if (newProfesor != null) {
            return new ResponseEntity<>(newProfesor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
