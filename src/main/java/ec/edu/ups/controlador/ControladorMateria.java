/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.modelo.Materias;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dutan2000
 */
public class ControladorMateria {
    private RandomAccessFile archivos;
    private int tamanio;
    private ControladorDocente controladorDocente;
    private String eliminar100bytes;
    private String eliminar25bytes;
    private ControladorDocente controladorD;
    private Materias materia;
    
    /*
    private String link| 100 bytes + 2 bytes 
    private String nombreDeAplicacion| 25 bytes + 2 bytes
    private Docente nombreDeDocente| 25 bytes + 2 bytes 
    
    total=158

    */

    public ControladorMateria() {
        try {
            archivos=new RandomAccessFile("datos/Links.dat", "rw");
            materia=new Materias();
            eliminar25bytes = "                         ";
            eliminar100bytes ="                                                                                                    ";
            tamanio=158;
        } catch (FileNotFoundException ex) {
            
        }  
    }
    
            public void create(Materias materia) {
        try {
            archivos.seek(archivos.length());
            archivos.writeUTF(materia.getLink());
            archivos.writeUTF(materia.getNombreDeAplicacion());
            archivos.writeUTF(materia.getNombreDeDocente().getNombre());

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [create ControladorMateria]");
            System.out.println(ex);
        }
    }
    
        public void update(Materias materia) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                this.materia = new Materias();
                this.materia.setLink(archivos.readUTF());
                this.materia.setNombreDeAplicacion(archivos.readUTF());
                this.materia.setNombreDeDocente(controladorDocente.readNombre(archivos.readUTF()));
                if (materia.getNombreDeDocente().getNombre() == this.materia.getNombreDeDocente().getNombre()) {
                    archivos.seek(salto);
                    archivos.writeUTF(materia.getLink());
                    archivos.writeUTF(materia.getNombreDeAplicacion());
                    archivos.writeUTF(materia.getNombreDeDocente().getNombre());
                    break;
                }
                salto+=tamanio;
            }

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [update ControladorMaterias]");
            System.out.println(ex);
        }
    }
    
    public Materias read(String nombre){
        int salto=0;
        try {
            while(salto<archivos.length()){
                archivos.seek(salto);
                materia=new Materias();
                this.materia.setLink(archivos.readUTF());
                this.materia.setNombreDeAplicacion(archivos.readUTF());
                this.materia.setNombreDeDocente(controladorDocente.readNombre(archivos.readUTF()));
                if(materia.getNombreDeDocente().getNombre().equals(nombre)){
                    archivos.seek(salto);
                    materia.setLink(archivos.readUTF().trim());
                    materia.setNombreDeAplicacion(archivos.readUTF().trim());
                    materia.setNombreDeDocente(controladorDocente.readNombre(archivos.readUTF()));
                    return materia;
                }
                salto+=tamanio;
            }
        } catch (IOException ex) {
          System.out.println("Error de escritura y lectura [read ControladorMaterias]");
          System.out.println(ex);  
        }
        return null;
    }
    
    public void delete(Materias materia) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                this.materia.setLink(archivos.readUTF());
                this.materia.setNombreDeAplicacion(archivos.readUTF());
                this.materia.setNombreDeDocente(controladorDocente.readNombre(archivos.readUTF()));
                if (materia.getNombreDeDocente().getNombre().equals(this.materia.getNombreDeDocente().getNombre())) {
                    archivos.seek(salto);
                    archivos.writeUTF(eliminar100bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar25bytes); 
                    break;
                }
                salto+=tamanio;
            }

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [delete ControladorMaterias]");
            System.out.println(ex);
        }
    }
    
        public List<Materias> findAllMaterias(String docente) {
        List<Materias> materiasLista = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                materia = new Materias();
                materia.setLink(archivos.readUTF().trim());
                materia.setNombreDeAplicacion(archivos.readUTF().trim());
                materia.setNombreDeDocente(controladorD.readNombre(archivos.readUTF().trim()));
                if (!materia.getLink().equals(eliminar100bytes)&&materia.getNombreDeDocente().getNombre().equals(docente)) {
                    materiasLista.add(materia);
                }

                salto += tamanio;
            }

            return materiasLista;
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (List : BodegaDAO)");
            ex.printStackTrace();
        }
        return null;
    }
}
