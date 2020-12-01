/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Alumno;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dutan2000
 */
public class ControladorAlumno {
    private Alumno alumno;
    private RandomAccessFile archivos;
    private int tamanioDeArchivos;
    private String eliminar10bytes;
    private String eliminar25bytes;
    private ControladorDocente controladord;
    
    /*
    private String cedula| 10 bytes + 2 bytes
    private String nombre| 25 bytes +2 bytes
    private String apellido| 25 bytes + 2 bytes
    private String tipo| 25 bytes + 2 bytes
    private String Docente(nombre)| 25 bytes + 2 bytes
    
    total:120
    */

    public ControladorAlumno() {
        try {
            archivos=new RandomAccessFile("datos/Alumnos.dat", "rw");
            tamanioDeArchivos=120;
            alumno=new Alumno();
            eliminar25bytes = "                         ";
            eliminar10bytes = "          ";
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error de escritura y lectura [ControladorAlumno]");
            System.out.println(ex);
        }   
    }
    
     public void create(Alumno alumno) {
        try {
            archivos.seek(archivos.length());
            archivos.writeUTF(alumno.getCedula());
            archivos.writeUTF(alumno.getNombre());
            archivos.writeUTF(alumno.getApellido());
            archivos.writeUTF(alumno.getTipo());
            archivos.writeUTF(alumno.getDocente().getNombre());

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [create ControladorAlumno]");
            System.out.println(ex);
        }
    }

    public void update(Alumno alumno) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                this.alumno = new Alumno();
                this.alumno.setCedula(archivos.readUTF());
                if (this.alumno.getCedula().equals(alumno.getCedula())) {
                    archivos.seek(salto + 10);
                    archivos.writeUTF(alumno.getNombre());
                    archivos.writeUTF(alumno.getApellido());
                    archivos.writeUTF(alumno.getTipo());
                    archivos.writeUTF(alumno.getDocente().getNombre());
                    break;
                }
                salto+=tamanioDeArchivos;
            }

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [update ControladorAlumno]");
            System.out.println(ex);
        }
    }
    
    public Alumno readAlumno(String cedula){
        int salto=0;
        try {
            while(salto<archivos.length()){
                archivos.seek(salto);
                alumno=new Alumno();
                alumno.setCedula(archivos.readUTF());
                if(alumno.getCedula().equals(cedula)){
                    archivos.seek(salto+10);
                    alumno.setNombre(archivos.readUTF().trim());
                    alumno.setApellido(archivos.readUTF().trim());
                    alumno.setTipo(archivos.readUTF().trim());
                    alumno.setDocente(controladord.readNombre(archivos.readUTF()));
                    return alumno;
                }
                salto+=tamanioDeArchivos;
            }
        } catch (IOException ex) {
          System.out.println("Error de escritura y lectura [read ControladorAlumno]");
          System.out.println(ex);  
        }
        return null;
    }
    
    public void delete(Alumno alumno) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                this.alumno = new Alumno();
                this.alumno.setCedula(archivos.readUTF());
                if (alumno.getCedula() == this.alumno.getCedula()) {
                    archivos.seek(salto);
                    archivos.writeUTF(eliminar10bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar25bytes); 
                    break;
                }
                salto+=tamanioDeArchivos;
            }

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [delete ControladorAlumno]");
            System.out.println(ex);
        }
    }
    
        public List<Alumno >findAllDocentes(String docente) {
        List<Alumno> alumnosLista = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                alumno = new Alumno();
                alumno.setCedula(archivos.readUTF().trim());
                alumno.setNombre(archivos.readUTF().trim());
                alumno.setApellido(archivos.readUTF().trim());
                alumno.setTipo(archivos.readUTF().trim());
                alumno.setDocente(controladord.readNombre(archivos.readUTF()));
                if (!alumno.getNombre().equals(eliminar25bytes)&&alumno.getDocente().getNombre().equals(docente)) {
                    alumnosLista.add(alumno);
                }

                salto += tamanioDeArchivos;
            }

            return alumnosLista;
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (List : BodegaDAO)");
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
