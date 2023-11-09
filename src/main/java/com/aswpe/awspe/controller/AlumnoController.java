package com.aswpe.awspe.controller;

import com.aswpe.awspe.dto.AlumnoDTO;
import com.aswpe.awspe.dto.request.PreAlumnoRequest;
import com.aswpe.awspe.services.AlumnoServices;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
@CrossOrigin(origins = {"*"})
public class AlumnoController {
    private final AlumnoServices alumnoServices;

    public AlumnoController(AlumnoServices alumnoServices) {
        this.alumnoServices = alumnoServices;
    }

    @GetMapping("")
    @Operation(summary = "Listar a todos los alumnos")
    public ResponseEntity<List<AlumnoDTO>> obtenerAllAlumnos() {
        List<AlumnoDTO> alumnos = this.alumnoServices.getAlumnos();
    return new ResponseEntity<>(alumnos,HttpStatus.OK);
}

    @GetMapping("/{id}")
    @Operation(summary = "Listar a un alumno segpun su id")
    public ResponseEntity<AlumnoDTO> getAlumnoById(@PathVariable int id){
        AlumnoDTO newAlumno = this.alumnoServices.getAlumnoById(id);
        if(newAlumno == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newAlumno,HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo alumno")
    public ResponseEntity<?> createAlumno(@Valid @RequestBody PreAlumnoRequest info){
        AlumnoDTO newAlumno = this.alumnoServices.createAlumno(info);
        return new ResponseEntity<>(newAlumno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar alumno existente")
    public ResponseEntity<AlumnoDTO> editAlumnoByid(@Valid @RequestBody PreAlumnoRequest info, @PathVariable int id){
        AlumnoDTO newAlumno = this.alumnoServices.actualizar(id,info);
        return new ResponseEntity<>(newAlumno,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un estudiante según su ID")
    public ResponseEntity<AlumnoDTO> delete(@PathVariable int id){
        AlumnoDTO alumnoAEliminar = this.alumnoServices.deleteAlumno(id);

        if (alumnoAEliminar != null) {
            return new ResponseEntity<>(alumnoAEliminar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
