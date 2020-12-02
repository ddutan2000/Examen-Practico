/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dutan2000
 */
public class ControladorDocente {

    private RandomAccessFile archivos;
    private int tamañoDeArchivo;
    private String eliminar10bytes;
    private String eliminar25bytes;
    private String eliminar30bytes;
    private String eliminar50bytes;
    private Docente docente;
    private ControladorAlumno controladorAlumno;
    private ControladorMateria controladorM;
    private Docente docente1=new Docente();

    /*
    private String cedula| 10 bytes + 2 bytes
    private String nombre| 25 bytes +2 bytes
    private String apellido| 25 bytes + 2 bytes
    private String tipo| 25 bytes + 2 bytes
    private String correo| 30 bytes +2 bytes
    private String contrasenia| 10 bytes + 2 bytes
    private String curso| 50 bytes + 2 bytes
    
    total= 189;
     */
    public ControladorDocente(ControladorAlumno controladorA) {
        try {
            archivos = new RandomAccessFile("datos/Docente.dat", "rw");
            docente = new Docente();
            tamañoDeArchivo = 189;
            controladorAlumno = controladorA;
            eliminar25bytes = "                         ";
            eliminar10bytes = "          ";
            eliminar30bytes = "                              ";
            eliminar50bytes = "                                                  ";

        } catch (FileNotFoundException ex) {
            System.out.println("Error de escritura y lectura [ControladorDocente]");
            System.out.println(ex);
        }
    }

    public void create(Docente docente) {
        try {
            archivos.seek(archivos.length());
            archivos.writeUTF(docente.getCedula());
            archivos.writeUTF(docente.getNombre());
            archivos.writeUTF(docente.getApellido());
            archivos.writeUTF(docente.getTipo());
            archivos.writeUTF(docente.getCurso());
            archivos.writeUTF(docente.getCorreo());
            archivos.writeUTF(docente.getContrasenia());

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [create ControladorDocente]");
            System.out.println(ex);
        }
    }

    public void update(Docente docente) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                this.docente = new Docente();
                this.docente.setCedula(archivos.readUTF());
                if (docente.getCedula() == this.docente.getCedula()) {
                    archivos.seek(salto + 10);
                    archivos.writeUTF(docente.getNombre());
                    archivos.writeUTF(docente.getApellido());
                    archivos.writeUTF(docente.getTipo());
                    archivos.writeUTF(docente.getCurso());
                    archivos.writeUTF(docente.getCorreo());
                    archivos.writeUTF(docente.getContrasenia());
                    break;
                }
                salto += tamañoDeArchivo;
            }

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [update ControladorDocente]");
            System.out.println(ex);
        }
    }

    public Docente read(String cedula) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                docente = new Docente();
                docente.setCedula(archivos.readUTF());
                if (docente.getCedula().equals(cedula)) {
                    archivos.seek(salto + 10);
                    docente.setNombre(archivos.readUTF().trim());
                    docente.setApellido(archivos.readUTF().trim());
                    docente.setTipo(archivos.readUTF().trim());
                    docente.setCurso(archivos.readUTF().trim());
                    docente.setCorreo(archivos.readUTF().trim());
                    docente.setContrasenia(archivos.readUTF().trim());
                    return docente;
                }
                salto += tamañoDeArchivo;
            }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [read ControladorDocente]");
            System.out.println(ex);
        }
        return null;
    }

    public Docente readNombre(String nombre) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                docente = new Docente();
                docente.setCedula(archivos.readUTF());
                docente.setNombre(archivos.readUTF());
                if (docente.getNombre().equals(nombre)) {
                    archivos.seek(salto + 39);
                    docente.setApellido(archivos.readUTF());
                    docente.setTipo(archivos.readUTF());
                    docente.setCurso(archivos.readUTF());
                    docente.setCorreo(archivos.readUTF());
                    docente.setContrasenia(archivos.readUTF());
                    return docente;
                }
                salto += tamañoDeArchivo;
            }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [readNombre ControladorDocente]");
            System.out.println(ex);
        }
        return null;
    }

    public void delete(Docente docente) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                this.docente = new Docente();
                this.docente.setCedula(archivos.readUTF());
                if (docente.getCedula() == this.docente.getCedula()) {
                    archivos.seek(salto);
                    archivos.writeUTF(eliminar10bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar50bytes);
                    archivos.writeUTF(eliminar30bytes);
                    archivos.writeUTF(eliminar10bytes);
                    break;
                }
                salto += tamañoDeArchivo;
            }

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [delete ControladorRector]");
            System.out.println(ex);
        }
    }

    public void creatAlumno(List<Alumno> alumnos) {
        for (int i = 0; i < alumnos.size(); i++) {
            controladorAlumno.create(alumnos.get(i));
        }
    }
    
    public void creatLink(Materias materias){
            controladorM.create(materias);
    }
    
    public Docente verDocente(){
        return docente1;
    }

    public Docente login(String correo, String contresenia) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                docente = new Docente();
                docente.setCedula(archivos.readUTF());
                docente.setNombre(archivos.readUTF());
                docente.setApellido(archivos.readUTF());
                docente.setTipo(archivos.readUTF());
                docente.setCorreo(archivos.readUTF());
                docente.setContrasenia(archivos.readUTF());
                if (docente.getCorreo().equals(correo) && docente.getContrasenia().equals(contresenia)) {
                    docente1=docente;
                    return docente;
                    
                }
                salto += tamañoDeArchivo;
            }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [login ControladorDocente]");
            System.out.println(ex);
        }
        return null;
    }

    public List<Docente> findAllDocentes() {
        List<Docente> docenteLista = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                docente = new Docente();
                docente.setCedula(archivos.readUTF().trim());
                docente.setNombre(archivos.readUTF().trim());
                docente.setApellido(archivos.readUTF().trim());
                docente.setTipo(archivos.readUTF().trim());
                docente.setCurso(archivos.readUTF().trim());
                docente.setCorreo(archivos.readUTF().trim());
                docente.setContrasenia(archivos.readUTF().trim());
                if (!docente.getNombre().equals(eliminar25bytes)) {
                    docenteLista.add(docente);
                }
                
                salto += tamañoDeArchivo;
            }
            return docenteLista;
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (List : BodegaDAO)");
            ex.printStackTrace();
        }
        return null;
    }

}
