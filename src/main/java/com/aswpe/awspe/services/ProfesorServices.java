package com.aswpe.awspe.services;

import com.aswpe.awspe.dto.ProfesorDTO;
import com.aswpe.awspe.dto.request.PreProfesorRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Service
public class ProfesorServices {
    private List<ProfesorDTO> profesores = new ArrayList<>();
    public ProfesorServices() {
        this.profesores = new ArrayList<>();
    }

    public List<ProfesorDTO> getProfesores() {
        return profesores;
    }
//Obtener el profesor según su ID
    public ProfesorDTO getProfesorById(int id) {
        for (ProfesorDTO profesor : profesores) {
            if (profesor.getId() == id) {
                return profesor;
            }
        }
        return null;
    }
    //Crear un nuevo profesor
    public ProfesorDTO createProfesor(PreProfesorRequest profesorAuxiliar){
        ProfesorDTO nuevoProfesor = new ProfesorDTO(profesorAuxiliar.getId(), profesorAuxiliar.getNumeroEmpleado(), profesorAuxiliar.getNombres(), profesorAuxiliar.getApellidos(), profesorAuxiliar.getHorasClase());

        profesores.add(nuevoProfesor);
        return nuevoProfesor;
    }
    //Actualizar datos de un profesor existente
    public ProfesorDTO actualizar(int id, PreProfesorRequest profesorAuxiliar){
        Optional<ProfesorDTO> profesorExistente = profesores.stream().filter(a -> a.getId() == id).findFirst();
        profesorExistente.ifPresent(value -> {
            value.setNumeroEmpleado(profesorAuxiliar.getNumeroEmpleado());
            value.setNombres(profesorAuxiliar.getNombres());
            value.setApellidos(profesorAuxiliar.getApellidos());
            value.setHorasClase(profesorAuxiliar.getHorasClase());
        });
        return profesorExistente.orElse(null);
    }
    //Eliminar a un profesor
    public ProfesorDTO deleteProfesor(int id){
        ProfesorDTO profesorParaEliminar = null;
        for (ProfesorDTO profesor : profesores) {
            if (profesor.getId() == id) {
                profesorParaEliminar = profesor;
                break;
            }
        }
        if (profesorParaEliminar != null) {
            profesores.remove(profesorParaEliminar);
        }
        return profesorParaEliminar;
    }
}