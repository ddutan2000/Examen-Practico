/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.paint.Material;

/**
 *
 * @author Dutan2000
 */
public class ControladorRegex {
        private Pattern patron;
    private Matcher corpus;
    private Materias materia;
    
    public void ingreseRegex(String regex){
        patron=Pattern.compile(regex);
    }
    public boolean validar(String texto){
        corpus=patron.matcher(texto);
        return corpus.find();
    }
    
    public List<String> obtenerNombrePropios(String buscar){
        List<String> resultado=new ArrayList<>();
        corpus=patron.matcher(buscar);
        while(corpus.find()){
            resultado.add(corpus.group(0));
        }
        return resultado;
    }
    
    public List<Materias> obtenerURLGoogle(String pagina,Docente docente ){
        List<Materias> lista=new ArrayList<>();
        corpus=patron.matcher(pagina);
        while(corpus.find()){
            String link=corpus.group(0).replaceFirst("<a\\shref=\"", "https://play.google.com/store/search?q=");
            lista.add(materia=new Materias(link,docente));
        }
        return lista;
    }

    public Pattern getPatron() {
        return patron;
    }

    public void setPatron(Pattern patron) {
        this.patron = patron;
    }

    public Matcher getCorpus() {
        return corpus;
    }

    public void setCorpus(Matcher corpus) {
        this.corpus = corpus;
    }
}
