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
public class Singleton {
    private String cedula;
    private String tipo;
    
    private static Singleton patronSingleton;
    
    public static synchronized Singleton patroSingleton(String cedula, String tipo){
        if(patronSingleton==null){
            patronSingleton=new Singleton();
            
        }
        return patronSingleton;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static Singleton getPatronSingleton() {
        return patronSingleton;
    }

    public static void setPatronSingleton(Singleton patronSingleton) {
        Singleton.patronSingleton = patronSingleton;
    }
    
    
}
