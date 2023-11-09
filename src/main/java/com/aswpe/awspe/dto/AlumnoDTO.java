package com.aswpe.awspe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AlumnoDTO {
    private int id;
    private String nombres;
    private String apellidos;
    private String matricula;
    private double promedio;
}
