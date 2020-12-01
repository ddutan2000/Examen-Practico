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
public class Rector extends Persona {
    private List<Docente> docentes;
    private String correo;
    private String contrasenia;

    public Rector(String correo, String contrasenia,String cedula, String nombre, String apellido, String tipo) {
        super(cedula, nombre, apellido, tipo);
        docentes=new ArrayList<>();
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    

    public Rector() {
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
    
    public void createDocente(Docente docente){
        docentes.add(docente);
    }
    
    public Docente readDocente(int cedula){
        return docentes.stream().filter(objeto -> objeto.getCedula().equals(cedula)).findFirst().get();
    }
    
    public void updateDocente(Docente docente){
        Docente d =readDocente(Integer.parseInt(docente.getCedula()));
        if(d!=null){
            for (int i = 0; i < docentes.size(); i++) {
                Docente f=docentes.get(i);
                if(f.getCedula()==d.getCedula()){
                    docentes.add(i, docente);
                }
            }
        }
    }
    
    public void deleteDocente(Docente docente){
        Docente d =readDocente(Integer.parseInt(docente.getCedula()));
        if(d!=null){
            for (int i = 0; i < docentes.size(); i++) {
                Docente f=docentes.get(i);
                if(f.getCedula()==d.getCedula()){
                    docentes.remove(i);
                }
            }
        }
    }
    
    public List<Docente> findall(){
        return docentes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.correo);
        hash = 13 * hash + Objects.hashCode(this.contrasenia);
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
        final Rector other = (Rector) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        return true;
    }
    
    
    
}
