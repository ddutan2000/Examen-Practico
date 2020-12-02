/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Dutan2000
 */
public class Alumno extends Persona{
    private Docente docente;

    public Alumno(Docente docente, String cedula, String nombre, String apellido, String tipo) {
        super(cedula, nombre, apellido, tipo);
        this.docente = docente;
    }

    public Alumno() {
    }
    

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    
}
