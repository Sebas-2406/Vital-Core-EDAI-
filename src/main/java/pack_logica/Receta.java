package pack_logica;

import java.time.LocalDate;
import java.util.List;
import pack_estructuras.ListaEnlazada;

public abstract class Receta {
    protected String idReceta, dosis, indicaciones;
    protected int vigencia;
    protected LocalDate fecha;
    protected ListaEnlazada<Medicina> medicinas;

    public Receta(String idReceta,LocalDate fecha, ListaEnlazada<Medicina> medicinas, String dosis, String indicaciones, int vigencia) {
        this.idReceta = idReceta;
        this.fecha = fecha;
        this.medicinas = medicinas;
        this.dosis = dosis;
        this.indicaciones = indicaciones;
        this.vigencia = vigencia;
    }

    public abstract void agregarMedicina(Medicina medicina);
    public abstract boolean validarVigencia();

    public String getIdReceta() {return idReceta;}

    public void setIdReceta(String idReceta) {this.idReceta = idReceta;}
    public String getDosis() {return dosis;}
    public void setDosis(String dosis) {this.dosis = dosis;}
    public String getIndicaciones() {return indicaciones;}
    public void setIndicaciones(String indicaciones) {this.indicaciones = indicaciones;}
    public int getVigencia() {return vigencia;}
    public void setVigencia(int vigencia) {this.vigencia = vigencia;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public ListaEnlazada<Medicina> getMedicinas() {return medicinas;}
    public void setMedicinas(ListaEnlazada<Medicina> medicinas) {this.medicinas = medicinas;}
}
