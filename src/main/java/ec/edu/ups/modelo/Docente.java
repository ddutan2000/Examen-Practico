/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Dutan2000
 */
public class Docente extends Persona {

    private String curso;
    private String correo;
    private String contrasenia;
    private List<Alumno> alumnos;
    private List<Materias> materias;

    public Docente(String curso, String correo, String contrasenia, String cedula, String nombre, String apellido, String tipo) {
        super(cedula, nombre, apellido, tipo);
        this.curso = curso;
        this.correo = correo;
        this.contrasenia = contrasenia;
        alumnos = new ArrayList<>();
        materias=new ArrayList<>();
    }

    public Docente() {
        alumnos = new ArrayList<>();
        materias=new ArrayList<>();
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void createAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public Alumno readAlumno(String cedula) {
        return alumnos.stream().filter(objeto -> objeto.getCedula().equals(cedula)).findFirst().get();
    }
    
    public List<Alumno> findAllAlumnos(){
        return alumnos;
    }

    public void createLink(List<Materias> materias) {
        for (int i = 0; i < materias.size(); i++) {
            this.materias.add(materias.get(i));
        }
    }

    public Materias readMateria(String docente) {
        return materias.stream().filter(objeto -> objeto.getNombreDeDocente().getNombre().equals(docente)).findFirst().get();
    }

    public List<Materias> findAllMaterias() {
        return materias;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Docente other = (Docente) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }

}
