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
public class Materias {
    private String link;
    private String nombreDeAplicacion;
    private Docente nombreDeDocente;

    public Materias(String link, String nombreDeAplicacion) {
        this.link = link;
        this.nombreDeAplicacion = nombreDeAplicacion;
    }

    public Materias(String link, Docente nombreDeDocente) {
        this.link = link;
        this.nombreDeDocente = nombreDeDocente;
    }

    public Materias(String link, String nombreDeAplicacion, Docente nombreDeDocente) {
        this.link = link;
        this.nombreDeAplicacion = nombreDeAplicacion;
        this.nombreDeDocente = nombreDeDocente;
    }
    
    

    public Materias() {
    }
    
    

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNombreDeAplicacion() {
        return nombreDeAplicacion;
    }

    public void setNombreDeAplicacion(String nombreDeAplicacion) {
        this.nombreDeAplicacion = nombreDeAplicacion;
    }

    public Docente getNombreDeDocente() {
        return nombreDeDocente;
    }

    public void setNombreDeDocente(Docente nombreDeDocente) {
        this.nombreDeDocente = nombreDeDocente;
    }
    
    
}
