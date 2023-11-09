package com.aswpe.awspe.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PreProfesorRequest {
    private int id;

    @Positive(message = "El número de empleado del profesor deben ser enteros mayores a 0 ")
    private int numeroEmpleado;

    @NotNull
    @NotBlank
    private String nombres;

    @NotNull
    @NotBlank
    private String apellidos;

    @Positive(message = "El número de horas del profesor deben ser enteros mayores a 0")
    private  int horasClase;
}
