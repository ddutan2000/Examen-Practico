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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dutan2000
 */
public class ControladorRector {

    private RandomAccessFile archivos;
    private Rector rector;
    private Docente docente;
    private int tamanioDeArchivo;
    private int codigo;
    private String eliminar10bytes;
    private String eliminar25bytes;
    private String eliminar30bytes;
    private ControladorDocente controladorDocente;

    /*
    private String cedula| 10 bytes + 2 bytes
    private String nombre| 25 bytes +2 bytes
    private String apellido| 25 bytes + 2 bytes
    private String tipo| 25 bytes + 2 bytes
    private String correo| 30 bytes +2 bytes
    private String contrasenia| 10 bytes + 2 bytes
    
    total= 141;
     */
    public ControladorRector(ControladorDocente controladorD) {
        try {
            archivos = new RandomAccessFile("datos/Rector.dat", "rw");
            rector = new Rector();
            tamanioDeArchivo = 137;
            codigo = 0;
            controladorDocente = controladorD;
            eliminar25bytes = "                         ";
            eliminar10bytes = "          ";
            eliminar30bytes = "                              ";
        } catch (FileNotFoundException ex) {
            System.out.println("Error de escritura y lectura [ControladorRector]");
            System.out.println(ex);
        }

    }

    public void create(Rector rector) {
        try {
            archivos.seek(archivos.length());
            archivos.writeUTF(rector.getCedula());
            archivos.writeUTF(rector.getNombre());
            archivos.writeUTF(rector.getApellido());
            archivos.writeUTF(rector.getTipo());
            archivos.writeUTF(rector.getCorreo());
            archivos.writeUTF(rector.getContrasenia());

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [create ControladorRector]");
            System.out.println(ex);
        }
    }

    public void update(Rector rector) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                this.rector = new Rector();
                this.rector.setCedula(archivos.readUTF());
                if (rector.getCedula() == this.rector.getCedula()) {
                    archivos.seek(salto + 10);
                    archivos.writeUTF(rector.getNombre());
                    archivos.writeUTF(rector.getApellido());
                    archivos.writeUTF(rector.getTipo());
                    archivos.writeUTF(rector.getCorreo());
                    archivos.writeUTF(rector.getContrasenia());
                    break;
                }
                salto += tamanioDeArchivo;
            }

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [update ControladorRector]");
            System.out.println(ex);
        }
    }

    public Rector read(String cedula) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                rector = new Rector();
                rector.setCedula(archivos.readUTF());
                if (rector.getCedula().equals(cedula)) {
                    archivos.seek(salto + 10);
                    rector.setNombre(archivos.readUTF().trim());
                    rector.setApellido(archivos.readUTF().trim());
                    rector.setTipo(archivos.readUTF().trim());
                    rector.setCorreo(archivos.readUTF().trim());
                    rector.setContrasenia(archivos.readUTF().trim());
                    return rector;
                }
                salto += tamanioDeArchivo;
            }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [read ControladorRector]");
            System.out.println(ex);
        }
        return null;
    }

    public void delete(Rector rector) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                this.rector = new Rector();
                this.rector.setCedula(archivos.readUTF());
                if (rector.getCedula() == this.rector.getCedula()) {
                    archivos.seek(salto);
                    archivos.writeUTF(eliminar10bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar25bytes);
                    archivos.writeUTF(eliminar30bytes);
                    archivos.writeUTF(eliminar10bytes);
                    break;
                }
                salto += tamanioDeArchivo;
            }

        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [delete ControladorRector]");
            System.out.println(ex);
        }
    }

    public void createDocente(List<Docente> docente) {
        for (int i = 0; i < docente.size(); i++) {
            controladorDocente.create(docente.get(i));
            break;
        }
    }

    public Rector login(String correo, String contresenia) {
        int salto = 0;
        try {
            while (salto < archivos.length()) {
                archivos.seek(salto);
                rector = new Rector();
                rector.setCedula(archivos.readUTF());
                rector.setNombre(archivos.readUTF());
                rector.setApellido(archivos.readUTF());
                rector.setTipo(archivos.readUTF());
                rector.setCorreo(archivos.readUTF());
                rector.setContrasenia(archivos.readUTF());
                if (rector.getCorreo().equals(correo) && rector.getContrasenia().equals(contresenia)) {
                    return rector;
                }
                salto += tamanioDeArchivo;
            }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura [login ControladorRector]");
            System.out.println(ex);
        }
        return null;
    }
}
