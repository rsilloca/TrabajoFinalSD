package com.epis.demoRestAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Docente {
    private final String NOMBRES;
    private final String APELLIDOS;
    private final String DEPARTAMENTO;
    private final String CORREO;
    private final String TELEFONO;
    private final String DIRECCION;
    private final String DNI;
}
