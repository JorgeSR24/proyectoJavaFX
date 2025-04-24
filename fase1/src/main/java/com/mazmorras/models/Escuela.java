package com.mazmorras.models;

import java.util.ArrayList;
import java.util.List;

public class Escuela {
    private String nombre;
    private List<Estudiante> listaEstudiantes;

    public Escuela(String nombre) {
        this.nombre = nombre;
        this.listaEstudiantes = new ArrayList<>(); // Inicialización importante
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void eliminarEstudiante(Estudiante estudiante){
        listaEstudiantes.remove(estudiante);
    }

    public void actualizarEstudiante(Estudiante estudiante){
        for(Estudiante estudi: listaEstudiantes){
            if(estudi.getNumMatricula().equals(estudiante.getNumMatricula())){
                estudi.setTelefono(estudiante.getTelefono());
                estudi.setApellido(estudiante.getApellido());
                estudi.setNombre(estudiante.getNombre());
            }
        }
    }
}
    
