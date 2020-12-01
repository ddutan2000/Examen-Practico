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
public class Docente extends Persona{
    private String curso;
    private String correo;
    private String contrasenia;
    private List<Alumno> alumnos;

    public Docente(String curso, String correo, String contrasenia, int identificacion, String cedula, String nombre, String apellido, String tipo) {
        super(identificacion, cedula, nombre, apellido, tipo);
        this.curso = curso;
        this.correo = correo;
        this.contrasenia = contrasenia;
        alumnos=new ArrayList<>();
    }

    public Docente() {
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
    
        public void createAlumno(Alumno alumno){
        alumnos.add(alumno);
    }
    
    public Alumno readAlumno(int cedula){
        return alumnos.stream().filter(objeto -> objeto.getCedula().equals(cedula)).findFirst().get();
    }
    
    public void updateAlumno(Alumno alumno){
        Alumno d =readAlumno(Integer.parseInt(alumno.getCedula()));
        if(d!=null){
            for (int i = 0; i < alumnos.size(); i++) {
                Alumno f=alumnos.get(i);
                if(f.getCedula()==d.getCedula()){
                    alumnos.add(i, alumno);
                }
            }
        }
    }
    
    public void deleteAlumno(Alumno alumno){
        Alumno d =readAlumno(Integer.parseInt(alumno.getCedula()));
        if(d!=null){
            for (int i = 0; i < alumnos.size(); i++) {
                Alumno f=alumnos.get(i);
                if(f.getCedula()==d.getCedula()){
                    alumnos.remove(i);
                }
            }
        }
    }
    
    public List<Alumno> findAll(){
        return alumnos;
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
